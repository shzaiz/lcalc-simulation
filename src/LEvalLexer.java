// Generated from LEval.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LEvalLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "NEWLINE", "SPACE", "COMMENT", "SEMICOLON", "LPAREN", "RPAREN", 
			"LBRACK", "RBRACK", "LCHEVRON", "RCHEVRON", "COMMA", "DOT", "COLONCOLON", 
			"ASSIGN", "ASSIGN_NO_EVAL", "LAMBDA", "HELP", "CLEAR", "EXIT", "LISTALL", 
			"SHOWLASTINFOS", "VERBOSE", "REDUCE", "BETA", "ETA", "BOTH", "PRINT", 
			"PRINTNOEVAL", "IMPORT", "DEFAULTCOMBINATOR", "FIGOPTION", "TRUE_", "FALSE_", 
			"EVAL", "STEPS", "HIGHLIGHT", "HORIZONTAL", "NUMBER", "NAME", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", null, null, null, "';'", "'('", "')'", "'['", "']'", "'<'", 
			"'>'", "','", "'.'", "'::'", "':='", "'<-'", null, "'help'", "'clear'", 
			"'exit'", "'listall'", "'showlastinfos'", "'verbose'", "'reduce'", "'beta'", 
			"'eta'", "'both'", "'print'", "'pne'", "'import'", "'defaultcombinator'", 
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


	public LEvalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LEval.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0136\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\6\3Y\n\3\r\3\16\3Z\3\3\3\3\3\4\6\4`\n\4\r\4\16\4a\3\4\3\4\3\5\3\5"+
		"\7\5h\n\5\f\5\16\5k\13\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\6(\u0121\n(\r(\16(\u0122\3)\3)\7)\u0127\n)\f)"+
		"\16)\u012a\13)\3*\3*\3*\3*\7*\u0130\n*\f*\16*\u0133\13*\3*\3*\2\2+\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+\3\2\t\4\2\f\f\17\17\4\2\13\13\"\"\4\2^^\u03bd\u03bd"+
		"\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\f\f\17\17$$\2\u013c\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5X"+
		"\3\2\2\2\7_\3\2\2\2\te\3\2\2\2\13n\3\2\2\2\rp\3\2\2\2\17r\3\2\2\2\21t"+
		"\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31|\3\2\2\2\33~\3\2\2\2\35"+
		"\u0080\3\2\2\2\37\u0083\3\2\2\2!\u0086\3\2\2\2#\u0089\3\2\2\2%\u008b\3"+
		"\2\2\2\'\u0090\3\2\2\2)\u0096\3\2\2\2+\u009b\3\2\2\2-\u00a3\3\2\2\2/\u00b1"+
		"\3\2\2\2\61\u00b9\3\2\2\2\63\u00c0\3\2\2\2\65\u00c5\3\2\2\2\67\u00c9\3"+
		"\2\2\29\u00ce\3\2\2\2;\u00d4\3\2\2\2=\u00d8\3\2\2\2?\u00df\3\2\2\2A\u00f1"+
		"\3\2\2\2C\u00f8\3\2\2\2E\u00fb\3\2\2\2G\u00ff\3\2\2\2I\u0104\3\2\2\2K"+
		"\u010a\3\2\2\2M\u0114\3\2\2\2O\u0120\3\2\2\2Q\u0124\3\2\2\2S\u012b\3\2"+
		"\2\2UV\7?\2\2V\4\3\2\2\2WY\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[\\\3\2\2\2\\]\b\3\2\2]\6\3\2\2\2^`\t\3\2\2_^\3\2\2\2`a\3\2\2\2a_"+
		"\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\b\4\2\2d\b\3\2\2\2ei\7%\2\2fh\n\2\2\2g"+
		"f\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\b\5\2\2"+
		"m\n\3\2\2\2no\7=\2\2o\f\3\2\2\2pq\7*\2\2q\16\3\2\2\2rs\7+\2\2s\20\3\2"+
		"\2\2tu\7]\2\2u\22\3\2\2\2vw\7_\2\2w\24\3\2\2\2xy\7>\2\2y\26\3\2\2\2z{"+
		"\7@\2\2{\30\3\2\2\2|}\7.\2\2}\32\3\2\2\2~\177\7\60\2\2\177\34\3\2\2\2"+
		"\u0080\u0081\7<\2\2\u0081\u0082\7<\2\2\u0082\36\3\2\2\2\u0083\u0084\7"+
		"<\2\2\u0084\u0085\7?\2\2\u0085 \3\2\2\2\u0086\u0087\7>\2\2\u0087\u0088"+
		"\7/\2\2\u0088\"\3\2\2\2\u0089\u008a\t\4\2\2\u008a$\3\2\2\2\u008b\u008c"+
		"\7j\2\2\u008c\u008d\7g\2\2\u008d\u008e\7n\2\2\u008e\u008f\7r\2\2\u008f"+
		"&\3\2\2\2\u0090\u0091\7e\2\2\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7t\2\2\u0095(\3\2\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7z\2\2\u0098\u0099\7k\2\2\u0099\u009a\7v\2\2\u009a*\3\2\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7k\2\2\u009d\u009e\7u\2\2\u009e\u009f\7v\2\2"+
		"\u009f\u00a0\7c\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7n\2\2\u00a2,\3\2\2"+
		"\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7j\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7"+
		"\7y\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7u\2\2\u00aa"+
		"\u00ab\7v\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7h\2\2"+
		"\u00ae\u00af\7q\2\2\u00af\u00b0\7u\2\2\u00b0.\3\2\2\2\u00b1\u00b2\7x\2"+
		"\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6"+
		"\7q\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7g\2\2\u00b8\60\3\2\2\2\u00b9\u00ba"+
		"\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7f\2\2\u00bc\u00bd\7w\2\2\u00bd"+
		"\u00be\7e\2\2\u00be\u00bf\7g\2\2\u00bf\62\3\2\2\2\u00c0\u00c1\7d\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7c\2\2\u00c4\64\3\2\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7c\2\2\u00c8\66\3\2\2\2\u00c9"+
		"\u00ca\7d\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7j\2\2"+
		"\u00cd8\3\2\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7k\2"+
		"\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3:\3\2\2\2\u00d4\u00d5\7"+
		"r\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7g\2\2\u00d7<\3\2\2\2\u00d8\u00d9"+
		"\7k\2\2\u00d9\u00da\7o\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7q\2\2\u00dc"+
		"\u00dd\7t\2\2\u00dd\u00de\7v\2\2\u00de>\3\2\2\2\u00df\u00e0\7f\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00e2\7h\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7w\2\2"+
		"\u00e4\u00e5\7n\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7e\2\2\u00e7\u00e8"+
		"\7q\2\2\u00e8\u00e9\7o\2\2\u00e9\u00ea\7d\2\2\u00ea\u00eb\7k\2\2\u00eb"+
		"\u00ec\7p\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7q\2\2"+
		"\u00ef\u00f0\7t\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7h\2\2\u00f2\u00f3\7k\2"+
		"\2\u00f3\u00f4\7i\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7B\3\2\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7p\2\2\u00faD\3"+
		"\2\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7h\2\2\u00fe"+
		"F\3\2\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7x\2\2\u0101\u0102\7c\2\2\u0102"+
		"\u0103\7n\2\2\u0103H\3\2\2\2\u0104\u0105\7u\2\2\u0105\u0106\7v\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0108\7r\2\2\u0108\u0109\7u\2\2\u0109J\3\2\2\2\u010a"+
		"\u010b\7j\2\2\u010b\u010c\7k\2\2\u010c\u010d\7i\2\2\u010d\u010e\7j\2\2"+
		"\u010e\u010f\7n\2\2\u010f\u0110\7k\2\2\u0110\u0111\7i\2\2\u0111\u0112"+
		"\7j\2\2\u0112\u0113\7v\2\2\u0113L\3\2\2\2\u0114\u0115\7j\2\2\u0115\u0116"+
		"\7q\2\2\u0116\u0117\7t\2\2\u0117\u0118\7k\2\2\u0118\u0119\7|\2\2\u0119"+
		"\u011a\7q\2\2\u011a\u011b\7p\2\2\u011b\u011c\7v\2\2\u011c\u011d\7c\2\2"+
		"\u011d\u011e\7n\2\2\u011eN\3\2\2\2\u011f\u0121\t\5\2\2\u0120\u011f\3\2"+
		"\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"P\3\2\2\2\u0124\u0128\t\6\2\2\u0125\u0127\t\7\2\2\u0126\u0125\3\2\2\2"+
		"\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129R\3"+
		"\2\2\2\u012a\u0128\3\2\2\2\u012b\u0131\7$\2\2\u012c\u0130\n\b\2\2\u012d"+
		"\u012e\7$\2\2\u012e\u0130\7$\2\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2"+
		"\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7$\2\2\u0135T\3\2\2\2\n\2Zai"+
		"\u0122\u0128\u012f\u0131\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}