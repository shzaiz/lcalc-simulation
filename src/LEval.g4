grammar LEval;

/*
 * LEXER RULES
 */
NEWLINE  : [\r\n]+ -> skip ;
SPACE    : [ \t]+ -> skip ;
COMMENT  : '#' ~[\r\n]* -> skip ;

// Single-character tokens
SEMICOLON   : ';' ;
LPAREN      : '(' ;
RPAREN      : ')' ;
LBRACK      : '[' ;
RBRACK      : ']' ;
LCHEVRON    : '<' ;
RCHEVRON    : '>' ;
COMMA       : ',' ;
DOT         : '.' ;

// Multi-character tokens
COLONCOLON      : '::' ;
ASSIGN          : ':=' ;
ASSIGN_NO_EVAL  : '<-' ;

// Either '\' or 'λ'
LAMBDA  : '\\' | '\u03BB' ;

// Keywords
HELP      : 'help' ;
CLEAR     : 'clear' ;
EXIT      : 'exit' ;
LISTALL   : 'listall' ;
SHOWLASTINFOS : 'showlastinfos' ;
VERBOSE   : 'verbose' ;
REDUCE    : 'reduce' ;
BETA      : 'beta' ;
ETA       : 'eta' ;
BOTH      : 'both' ;
PRINT     : 'print' ;
PRINTNOEVAL : 'pne' ;
IMPORT    : 'import' ;
DEFAULTCOMBINATOR : 'defaultcombinator' ;
FIGOPTION  : 'figure' ;
TRUE_     : 'on' ;
FALSE_    : 'off' ;

// A numeric literal
NUMBER
 : [0-9]+
 ;

// A generic name (variables, function names, etc.)
NAME
 : [a-zA-Z_] [a-zA-Z0-9_]*
 ;

// For paths "like/this/file.lc"
STRING
 : '"' (~["\r\n] | '""')* '"'
 ;


/*
 * PARSER RULES
 *
 * Rough equivalents of your Python grammar:
 *   L -> I ; L | (empty)
 *   I -> help | clear | exit | ...
 *   T, R, E replicate your lambda-expression grammar
 */

// Entry point: a sequence of instructions
program
 : (instruction SEMICOLON)* (instruction SEMICOLON?)? EOF
 ;

// One instruction
instruction
 // 1. Built-in commands
 : HELP
 | CLEAR
 | EXIT
 | LISTALL
 | SHOWLASTINFOS
 | VERBOSE booleanOption
 | REDUCE reduceOption
 | PRINT term
 | PRINTNOEVAL term
 | IMPORT STRING
 | DEFAULTCOMBINATOR term
 | FIGOPTION booleanOption
 // 2. Assignment
 | NAME (ASSIGN | ASSIGN_NO_EVAL) term
 ;

// booleanOption -> true|false
booleanOption
 : TRUE_
 | FALSE_
 ;

// reduceOption -> beta|eta|both
reduceOption
 : BETA
 | ETA
 | BOTH
 ;


// A term
// T -> R {R*} is effectively left-recursive. We'll do it in a normal ANTLR approach.
term
 : application
 ;

application
 // T -> R (R)*
 : rExpr ( rExpr )*
 ;

// R -> E | E :: R
rExpr
 : eExpr (COLONCOLON rExpr)?
 ;

// E -> (term) | NAME | NUMBER
//    | LAMBDA (NAME+) DOT term
//    | < term (, term)* >
//    | [ term (, term)* ] or []
eExpr
 : LPAREN term RPAREN
 | NAME
 | NUMBER
 | LAMBDA lambdaVars DOT term
 | LCHEVRON tupleElements RCHEVRON
 | LBRACK listElements? RBRACK
 ;

lambdaVars
 // one or more NAME
 : NAME (NAME)*
  ;

// For tuple
tupleElements
 : term (COMMA term)*
  ;

// For list, optional elements
listElements
 : term (COMMA term)*
  ;
