// Generated from LEval.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LEvalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEWLINE=2, SPACE=3, COMMENT=4, SEMICOLON=5, LPAREN=6, RPAREN=7, 
		LBRACK=8, RBRACK=9, LCHEVRON=10, RCHEVRON=11, COMMA=12, DOT=13, COLONCOLON=14, 
		ASSIGN=15, ASSIGN_NO_EVAL=16, LAMBDA=17, HELP=18, CLEAR=19, EXIT=20, LISTALL=21, 
		SHOWLASTINFOS=22, VERBOSE=23, REDUCE=24, BETA=25, ETA=26, BOTH=27, PRINT=28, 
		PRINTNOEVAL=29, IMPORT=30, DEFAULTCOMBINATOR=31, FIGOPTION=32, TRUE_=33, 
		FALSE_=34, EVAL=35, STEPS=36, HIGHLIGHT=37, HORIZONTAL=38, NUMBER=39, 
		NAME=40, STRING=41;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_booleanOption = 2, RULE_reduceOption = 3, 
		RULE_latexExportOptions = 4, RULE_term = 5, RULE_application = 6, RULE_rExpr = 7, 
		RULE_eExpr = 8, RULE_lambdaVars = 9, RULE_tupleElements = 10, RULE_listElements = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruction", "booleanOption", "reduceOption", "latexExportOptions", 
			"term", "application", "rExpr", "eExpr", "lambdaVars", "tupleElements", 
			"listElements"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", null, null, null, "';'", "'('", "')'", "'['", "']'", "'<'", 
			"'>'", "','", "'.'", "'::'", "':='", "'<-'", null, "'help'", "'clear'", 
			"'exit'", "'listall'", "'showlastinfos'", "'verbose'", "'reduce'", "'beta'", 
			"'eta'", "'both'", "'print'", "'printnoeval'", "'import'", "'defaultcombinator'", 
			"'figure'", "'on'", "'off'", "'eval'", "'steps'", "'highlight'", "'horizontal'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEWLINE", "SPACE", "COMMENT", "SEMICOLON", "LPAREN", "RPAREN", 
			"LBRACK", "RBRACK", "LCHEVRON", "RCHEVRON", "COMMA", "DOT", "COLONCOLON", 
			"ASSIGN", "ASSIGN_NO_EVAL", "LAMBDA", "HELP", "CLEAR", "EXIT", "LISTALL", 
			"SHOWLASTINFOS", "VERBOSE", "REDUCE", "BETA", "ETA", "BOTH", "PRINT", 
			"PRINTNOEVAL", "IMPORT", "DEFAULTCOMBINATOR", "FIGOPTION", "TRUE_", "FALSE_", 
			"EVAL", "STEPS", "HIGHLIGHT", "HORIZONTAL", "NUMBER", "NAME", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LEval.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LEvalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LEvalParser.EOF, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LEvalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LEvalParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					instruction();
					setState(25);
					match(SEMICOLON);
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HELP) | (1L << CLEAR) | (1L << EXIT) | (1L << LISTALL) | (1L << SHOWLASTINFOS) | (1L << VERBOSE) | (1L << REDUCE) | (1L << PRINT) | (1L << PRINTNOEVAL) | (1L << IMPORT) | (1L << DEFAULTCOMBINATOR) | (1L << FIGOPTION) | (1L << NAME))) != 0)) {
				{
				setState(32);
				instruction();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(33);
					match(SEMICOLON);
					}
				}

				}
			}

			setState(38);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public TerminalNode HELP() { return getToken(LEvalParser.HELP, 0); }
		public TerminalNode CLEAR() { return getToken(LEvalParser.CLEAR, 0); }
		public TerminalNode EXIT() { return getToken(LEvalParser.EXIT, 0); }
		public TerminalNode LISTALL() { return getToken(LEvalParser.LISTALL, 0); }
		public TerminalNode SHOWLASTINFOS() { return getToken(LEvalParser.SHOWLASTINFOS, 0); }
		public TerminalNode VERBOSE() { return getToken(LEvalParser.VERBOSE, 0); }
		public BooleanOptionContext booleanOption() {
			return getRuleContext(BooleanOptionContext.class,0);
		}
		public TerminalNode REDUCE() { return getToken(LEvalParser.REDUCE, 0); }
		public ReduceOptionContext reduceOption() {
			return getRuleContext(ReduceOptionContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(LEvalParser.PRINT, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PRINTNOEVAL() { return getToken(LEvalParser.PRINTNOEVAL, 0); }
		public TerminalNode IMPORT() { return getToken(LEvalParser.IMPORT, 0); }
		public TerminalNode STRING() { return getToken(LEvalParser.STRING, 0); }
		public TerminalNode DEFAULTCOMBINATOR() { return getToken(LEvalParser.DEFAULTCOMBINATOR, 0); }
		public TerminalNode FIGOPTION() { return getToken(LEvalParser.FIGOPTION, 0); }
		public TerminalNode NAME() { return getToken(LEvalParser.NAME, 0); }
		public TerminalNode ASSIGN() { return getToken(LEvalParser.ASSIGN, 0); }
		public TerminalNode ASSIGN_NO_EVAL() { return getToken(LEvalParser.ASSIGN_NO_EVAL, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		int _la;
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HELP:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(HELP);
				}
				break;
			case CLEAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(CLEAR);
				}
				break;
			case EXIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(EXIT);
				}
				break;
			case LISTALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(LISTALL);
				}
				break;
			case SHOWLASTINFOS:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				match(SHOWLASTINFOS);
				}
				break;
			case VERBOSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				match(VERBOSE);
				setState(46);
				booleanOption();
				}
				break;
			case REDUCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				match(REDUCE);
				setState(48);
				reduceOption();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 8);
				{
				setState(49);
				match(PRINT);
				setState(50);
				term();
				}
				break;
			case PRINTNOEVAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				match(PRINTNOEVAL);
				setState(52);
				term();
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				match(IMPORT);
				setState(54);
				match(STRING);
				}
				break;
			case DEFAULTCOMBINATOR:
				enterOuterAlt(_localctx, 11);
				{
				setState(55);
				match(DEFAULTCOMBINATOR);
				setState(56);
				term();
				}
				break;
			case FIGOPTION:
				enterOuterAlt(_localctx, 12);
				{
				setState(57);
				match(FIGOPTION);
				setState(58);
				booleanOption();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 13);
				{
				setState(59);
				match(NAME);
				setState(60);
				_la = _input.LA(1);
				if ( !(_la==ASSIGN || _la==ASSIGN_NO_EVAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(61);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanOptionContext extends ParserRuleContext {
		public TerminalNode TRUE_() { return getToken(LEvalParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(LEvalParser.FALSE_, 0); }
		public BooleanOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitBooleanOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanOptionContext booleanOption() throws RecognitionException {
		BooleanOptionContext _localctx = new BooleanOptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_booleanOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==TRUE_ || _la==FALSE_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReduceOptionContext extends ParserRuleContext {
		public TerminalNode BETA() { return getToken(LEvalParser.BETA, 0); }
		public TerminalNode ETA() { return getToken(LEvalParser.ETA, 0); }
		public TerminalNode BOTH() { return getToken(LEvalParser.BOTH, 0); }
		public ReduceOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reduceOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitReduceOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReduceOptionContext reduceOption() throws RecognitionException {
		ReduceOptionContext _localctx = new ReduceOptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reduceOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BETA) | (1L << ETA) | (1L << BOTH))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LatexExportOptionsContext extends ParserRuleContext {
		public List<TerminalNode> EVAL() { return getTokens(LEvalParser.EVAL); }
		public TerminalNode EVAL(int i) {
			return getToken(LEvalParser.EVAL, i);
		}
		public List<TerminalNode> STEPS() { return getTokens(LEvalParser.STEPS); }
		public TerminalNode STEPS(int i) {
			return getToken(LEvalParser.STEPS, i);
		}
		public List<TerminalNode> HIGHLIGHT() { return getTokens(LEvalParser.HIGHLIGHT); }
		public TerminalNode HIGHLIGHT(int i) {
			return getToken(LEvalParser.HIGHLIGHT, i);
		}
		public List<TerminalNode> HORIZONTAL() { return getTokens(LEvalParser.HORIZONTAL); }
		public TerminalNode HORIZONTAL(int i) {
			return getToken(LEvalParser.HORIZONTAL, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(LEvalParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(LEvalParser.NUMBER, i);
		}
		public LatexExportOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latexExportOptions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitLatexExportOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LatexExportOptionsContext latexExportOptions() throws RecognitionException {
		LatexExportOptionsContext _localctx = new LatexExportOptionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_latexExportOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(76);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EVAL:
					{
					setState(68);
					match(EVAL);
					}
					break;
				case STEPS:
					{
					setState(69);
					match(STEPS);
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(70);
						match(T__0);
						setState(71);
						match(NUMBER);
						}
					}

					}
					break;
				case HIGHLIGHT:
					{
					setState(74);
					match(HIGHLIGHT);
					}
					break;
				case HORIZONTAL:
					{
					setState(75);
					match(HORIZONTAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EVAL) | (1L << STEPS) | (1L << HIGHLIGHT) | (1L << HORIZONTAL))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			application();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApplicationContext extends ParserRuleContext {
		public List<RExprContext> rExpr() {
			return getRuleContexts(RExprContext.class);
		}
		public RExprContext rExpr(int i) {
			return getRuleContext(RExprContext.class,i);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_application);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			rExpr();
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					rExpr();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RExprContext extends ParserRuleContext {
		public EExprContext eExpr() {
			return getRuleContext(EExprContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(LEvalParser.COLONCOLON, 0); }
		public RExprContext rExpr() {
			return getRuleContext(RExprContext.class,0);
		}
		public RExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitRExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExprContext rExpr() throws RecognitionException {
		RExprContext _localctx = new RExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			eExpr();
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(90);
				match(COLONCOLON);
				setState(91);
				rExpr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(LEvalParser.LPAREN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LEvalParser.RPAREN, 0); }
		public TerminalNode NAME() { return getToken(LEvalParser.NAME, 0); }
		public TerminalNode NUMBER() { return getToken(LEvalParser.NUMBER, 0); }
		public TerminalNode LAMBDA() { return getToken(LEvalParser.LAMBDA, 0); }
		public LambdaVarsContext lambdaVars() {
			return getRuleContext(LambdaVarsContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LEvalParser.DOT, 0); }
		public TerminalNode LCHEVRON() { return getToken(LEvalParser.LCHEVRON, 0); }
		public TupleElementsContext tupleElements() {
			return getRuleContext(TupleElementsContext.class,0);
		}
		public TerminalNode RCHEVRON() { return getToken(LEvalParser.RCHEVRON, 0); }
		public TerminalNode LBRACK() { return getToken(LEvalParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(LEvalParser.RBRACK, 0); }
		public ListElementsContext listElements() {
			return getRuleContext(ListElementsContext.class,0);
		}
		public EExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitEExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EExprContext eExpr() throws RecognitionException {
		EExprContext _localctx = new EExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_eExpr);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(LPAREN);
				setState(95);
				term();
				setState(96);
				match(RPAREN);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(NAME);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(NUMBER);
				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(LAMBDA);
				setState(101);
				lambdaVars();
				setState(102);
				match(DOT);
				setState(103);
				term();
				}
				break;
			case LCHEVRON:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				match(LCHEVRON);
				setState(106);
				tupleElements();
				setState(107);
				match(RCHEVRON);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				match(LBRACK);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRACK) | (1L << LCHEVRON) | (1L << LAMBDA) | (1L << NUMBER) | (1L << NAME))) != 0)) {
					{
					setState(110);
					listElements();
					}
				}

				setState(113);
				match(RBRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaVarsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(LEvalParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LEvalParser.NAME, i);
		}
		public LambdaVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaVars; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitLambdaVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaVarsContext lambdaVars() throws RecognitionException {
		LambdaVarsContext _localctx = new LambdaVarsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lambdaVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(NAME);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(117);
				match(NAME);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupleElementsContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LEvalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LEvalParser.COMMA, i);
		}
		public TupleElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleElements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitTupleElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleElementsContext tupleElements() throws RecognitionException {
		TupleElementsContext _localctx = new TupleElementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tupleElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			term();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(124);
				match(COMMA);
				setState(125);
				term();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListElementsContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LEvalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LEvalParser.COMMA, i);
		}
		public ListElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listElements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LEvalVisitor ) return ((LEvalVisitor<? extends T>)visitor).visitListElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListElementsContext listElements() throws RecognitionException {
		ListElementsContext _localctx = new ListElementsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			term();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132);
				match(COMMA);
				setState(133);
				term();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u008e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\5\2"+
		"%\n\2\5\2\'\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\5\6K\n\6\3\6\3\6\6\6O\n\6\r\6\16\6P\3\7\3\7\3\b\3\b\7\b"+
		"W\n\b\f\b\16\bZ\13\b\3\t\3\t\3\t\5\t_\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\n\5\nu\n\n\3\13\3"+
		"\13\7\13y\n\13\f\13\16\13|\13\13\3\f\3\f\3\f\7\f\u0081\n\f\f\f\16\f\u0084"+
		"\13\f\3\r\3\r\3\r\7\r\u0089\n\r\f\r\16\r\u008c\13\r\3\r\2\2\16\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\2\5\3\2\21\22\3\2#$\3\2\33\35\2\u00a0\2\37\3\2"+
		"\2\2\4@\3\2\2\2\6B\3\2\2\2\bD\3\2\2\2\nN\3\2\2\2\fR\3\2\2\2\16T\3\2\2"+
		"\2\20[\3\2\2\2\22t\3\2\2\2\24v\3\2\2\2\26}\3\2\2\2\30\u0085\3\2\2\2\32"+
		"\33\5\4\3\2\33\34\7\7\2\2\34\36\3\2\2\2\35\32\3\2\2\2\36!\3\2\2\2\37\35"+
		"\3\2\2\2\37 \3\2\2\2 &\3\2\2\2!\37\3\2\2\2\"$\5\4\3\2#%\7\7\2\2$#\3\2"+
		"\2\2$%\3\2\2\2%\'\3\2\2\2&\"\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\2\2\3)"+
		"\3\3\2\2\2*A\7\24\2\2+A\7\25\2\2,A\7\26\2\2-A\7\27\2\2.A\7\30\2\2/\60"+
		"\7\31\2\2\60A\5\6\4\2\61\62\7\32\2\2\62A\5\b\5\2\63\64\7\36\2\2\64A\5"+
		"\f\7\2\65\66\7\37\2\2\66A\5\f\7\2\678\7 \2\28A\7+\2\29:\7!\2\2:A\5\f\7"+
		"\2;<\7\"\2\2<A\5\6\4\2=>\7*\2\2>?\t\2\2\2?A\5\f\7\2@*\3\2\2\2@+\3\2\2"+
		"\2@,\3\2\2\2@-\3\2\2\2@.\3\2\2\2@/\3\2\2\2@\61\3\2\2\2@\63\3\2\2\2@\65"+
		"\3\2\2\2@\67\3\2\2\2@9\3\2\2\2@;\3\2\2\2@=\3\2\2\2A\5\3\2\2\2BC\t\3\2"+
		"\2C\7\3\2\2\2DE\t\4\2\2E\t\3\2\2\2FO\7%\2\2GJ\7&\2\2HI\7\3\2\2IK\7)\2"+
		"\2JH\3\2\2\2JK\3\2\2\2KO\3\2\2\2LO\7\'\2\2MO\7(\2\2NF\3\2\2\2NG\3\2\2"+
		"\2NL\3\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RS\5\16"+
		"\b\2S\r\3\2\2\2TX\5\20\t\2UW\5\20\t\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY"+
		"\3\2\2\2Y\17\3\2\2\2ZX\3\2\2\2[^\5\22\n\2\\]\7\20\2\2]_\5\20\t\2^\\\3"+
		"\2\2\2^_\3\2\2\2_\21\3\2\2\2`a\7\b\2\2ab\5\f\7\2bc\7\t\2\2cu\3\2\2\2d"+
		"u\7*\2\2eu\7)\2\2fg\7\23\2\2gh\5\24\13\2hi\7\17\2\2ij\5\f\7\2ju\3\2\2"+
		"\2kl\7\f\2\2lm\5\26\f\2mn\7\r\2\2nu\3\2\2\2oq\7\n\2\2pr\5\30\r\2qp\3\2"+
		"\2\2qr\3\2\2\2rs\3\2\2\2su\7\13\2\2t`\3\2\2\2td\3\2\2\2te\3\2\2\2tf\3"+
		"\2\2\2tk\3\2\2\2to\3\2\2\2u\23\3\2\2\2vz\7*\2\2wy\7*\2\2xw\3\2\2\2y|\3"+
		"\2\2\2zx\3\2\2\2z{\3\2\2\2{\25\3\2\2\2|z\3\2\2\2}\u0082\5\f\7\2~\177\7"+
		"\16\2\2\177\u0081\5\f\7\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\27\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u008a\5\f\7\2\u0086\u0087\7\16\2\2\u0087\u0089\5\f\7\2\u0088\u0086\3"+
		"\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\31\3\2\2\2\u008c\u008a\3\2\2\2\20\37$&@JNPX^qtz\u0082\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}