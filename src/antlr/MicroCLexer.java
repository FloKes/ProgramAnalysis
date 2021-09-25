// Generated from C:/Users/giaco/IdeaProjects/Program-Analysis/src/antlr\MicroC.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACE=3, RBRACE=4, SEMI=5, LBRACKET=6, RBRACKET=7, 
		PLUS=8, MINUS=9, MULT=10, DIV=11, MOD=12, GT=13, GE=14, LT=15, LE=16, 
		EQ=17, NEQ=18, NOT=19, AND=20, OR=21, COMMA=22, ELSE=23, FST=24, SND=25, 
		INT=26, EQUAL=27, READ=28, WRITE=29, IF=30, WHILE=31, R=32, TRUE=33, FALSE=34, 
		INTEGER=35, IDENTIFIER=36, COMMENT=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "LBRACKET", "RBRACKET", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "GT", "GE", "LT", "LE", "EQ", 
			"NEQ", "NOT", "AND", "OR", "COMMA", "ELSE", "FST", "SND", "INT", "EQUAL", 
			"READ", "WRITE", "IF", "WHILE", "R", "TRUE", "FALSE", "INTEGER", "IDENTIFIER", 
			"LETTER", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "';'", "'['", "']'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", 
			"'&'", "'|'", "','", "'else'", "'.fst'", "'.snd'", "'int'", "':='", "'read'", 
			"'write'", "'if'", "'while'", "'R'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "LBRACKET", "RBRACKET", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "GT", "GE", "LT", "LE", "EQ", 
			"NEQ", "NOT", "AND", "OR", "COMMA", "ELSE", "FST", "SND", "INT", "EQUAL", 
			"READ", "WRITE", "IF", "WHILE", "R", "TRUE", "FALSE", "INTEGER", "IDENTIFIER", 
			"COMMENT", "WS"
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


	public MicroCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MicroC.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00de\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\7$\u00bc\n$\f$\16$\u00bf\13$\5$\u00c1\n"+
		"$\3%\3%\3%\7%\u00c6\n%\f%\16%\u00c9\13%\3&\3&\3\'\3\'\3\'\3\'\7\'\u00d1"+
		"\n\'\f\'\16\'\u00d4\13\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3\u00d2\2)\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\2M\'O(\3\2\4\5\2C\\aac|\5\2\13\f\16\17\"\"\2\u00e1\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3"+
		"\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25c"+
		"\3\2\2\2\27e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37n\3\2\2\2!"+
		"p\3\2\2\2#s\3\2\2\2%v\3\2\2\2\'y\3\2\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2"+
		"\2\2/\u0081\3\2\2\2\61\u0086\3\2\2\2\63\u008b\3\2\2\2\65\u0090\3\2\2\2"+
		"\67\u0094\3\2\2\29\u0097\3\2\2\2;\u009c\3\2\2\2=\u00a2\3\2\2\2?\u00a5"+
		"\3\2\2\2A\u00ab\3\2\2\2C\u00ad\3\2\2\2E\u00b2\3\2\2\2G\u00c0\3\2\2\2I"+
		"\u00c2\3\2\2\2K\u00ca\3\2\2\2M\u00cc\3\2\2\2O\u00da\3\2\2\2QR\7*\2\2R"+
		"\4\3\2\2\2ST\7+\2\2T\6\3\2\2\2UV\7}\2\2V\b\3\2\2\2WX\7\177\2\2X\n\3\2"+
		"\2\2YZ\7=\2\2Z\f\3\2\2\2[\\\7]\2\2\\\16\3\2\2\2]^\7_\2\2^\20\3\2\2\2_"+
		"`\7-\2\2`\22\3\2\2\2ab\7/\2\2b\24\3\2\2\2cd\7,\2\2d\26\3\2\2\2ef\7\61"+
		"\2\2f\30\3\2\2\2gh\7\'\2\2h\32\3\2\2\2ij\7@\2\2j\34\3\2\2\2kl\7@\2\2l"+
		"m\7?\2\2m\36\3\2\2\2no\7>\2\2o \3\2\2\2pq\7>\2\2qr\7?\2\2r\"\3\2\2\2s"+
		"t\7?\2\2tu\7?\2\2u$\3\2\2\2vw\7#\2\2wx\7?\2\2x&\3\2\2\2yz\7#\2\2z(\3\2"+
		"\2\2{|\7(\2\2|*\3\2\2\2}~\7~\2\2~,\3\2\2\2\177\u0080\7.\2\2\u0080.\3\2"+
		"\2\2\u0081\u0082\7g\2\2\u0082\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084\u0085"+
		"\7g\2\2\u0085\60\3\2\2\2\u0086\u0087\7\60\2\2\u0087\u0088\7h\2\2\u0088"+
		"\u0089\7u\2\2\u0089\u008a\7v\2\2\u008a\62\3\2\2\2\u008b\u008c\7\60\2\2"+
		"\u008c\u008d\7u\2\2\u008d\u008e\7p\2\2\u008e\u008f\7f\2\2\u008f\64\3\2"+
		"\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092\u0093\7v\2\2\u0093\66"+
		"\3\2\2\2\u0094\u0095\7<\2\2\u0095\u0096\7?\2\2\u00968\3\2\2\2\u0097\u0098"+
		"\7t\2\2\u0098\u0099\7g\2\2\u0099\u009a\7c\2\2\u009a\u009b\7f\2\2\u009b"+
		":\3\2\2\2\u009c\u009d\7y\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f"+
		"\u00a0\7v\2\2\u00a0\u00a1\7g\2\2\u00a1<\3\2\2\2\u00a2\u00a3\7k\2\2\u00a3"+
		"\u00a4\7h\2\2\u00a4>\3\2\2\2\u00a5\u00a6\7y\2\2\u00a6\u00a7\7j\2\2\u00a7"+
		"\u00a8\7k\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa@\3\2\2\2\u00ab"+
		"\u00ac\7T\2\2\u00acB\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\u00b0\7w\2\2\u00b0\u00b1\7g\2\2\u00b1D\3\2\2\2\u00b2\u00b3\7h\2\2\u00b3"+
		"\u00b4\7c\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7\7g\2\2"+
		"\u00b7F\3\2\2\2\u00b8\u00c1\7\62\2\2\u00b9\u00bd\4\63;\2\u00ba\u00bc\4"+
		"\62;\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2"+
		"\2\2\u00c0\u00b9\3\2\2\2\u00c1H\3\2\2\2\u00c2\u00c7\5K&\2\u00c3\u00c6"+
		"\5K&\2\u00c4\u00c6\4\62;\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8J\3\2\2\2"+
		"\u00c9\u00c7\3\2\2\2\u00ca\u00cb\t\2\2\2\u00cbL\3\2\2\2\u00cc\u00cd\7"+
		"\61\2\2\u00cd\u00ce\7,\2\2\u00ce\u00d2\3\2\2\2\u00cf\u00d1\13\2\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6"+
		"\u00d7\7\61\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b\'\2\2\u00d9N\3\2\2\2"+
		"\u00da\u00db\t\3\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b(\3\2\u00ddP\3\2"+
		"\2\2\b\2\u00bd\u00c0\u00c5\u00c7\u00d2\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}