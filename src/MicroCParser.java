// Generated from C:/Users/musta/OneDrive/Project-folder DTU/7 semester/Program Analysis/Program-Analysis-DTU-Fall-21\MicroC.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACE=3, RBRACE=4, SEMI=5, LBRACKET=6, RBRACKET=7, 
		PLUS=8, MINUS=9, MULT=10, DIV=11, MOD=12, GT=13, GE=14, LT=15, LE=16, 
		EQ=17, NEQ=18, NOT=19, AND=20, OR=21, COMMA=22, ELSE=23, FST=24, SND=25, 
		INT=26, EQUAL=27, READ=28, WRITE=29, IF=30, WHILE=31, R=32, INTEGER=33, 
		IDENTIFIER=34, COMMENT=35, WS=36, TRUE=37, FALSE=38;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_lexpr = 2, RULE_rexpr = 3, 
		RULE_array = 4, RULE_bexpr = 5, RULE_decl = 6, RULE_opa = 7, RULE_opr = 8, 
		RULE_opb = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "lexpr", "rexpr", "array", "bexpr", "decl", "opa", 
			"opr", "opb"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "';'", "'['", "']'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", 
			"'&'", "'|'", "','", "'else'", "'.fst'", "'.snd'", "'int'", "':='", "'read'", 
			"'write'", "'if'", "'while'", "'R'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "LBRACKET", "RBRACKET", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "GT", "GE", "LT", "LE", "EQ", 
			"NEQ", "NOT", "AND", "OR", "COMMA", "ELSE", "FST", "SND", "INT", "EQUAL", 
			"READ", "WRITE", "IF", "WHILE", "R", "INTEGER", "IDENTIFIER", "COMMENT", 
			"WS", "TRUE", "FALSE"
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
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MicroCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(LBRACE);
			setState(21);
			decl();
			setState(22);
			statement();
			setState(23);
			match(RBRACE);
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

	public static class StatementContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(MicroCParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(MicroCParser.IF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(MicroCParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(MicroCParser.LPAREN, i);
		}
		public List<BexprContext> bexpr() {
			return getRuleContexts(BexprContext.class);
		}
		public BexprContext bexpr(int i) {
			return getRuleContext(BexprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(MicroCParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(MicroCParser.RPAREN, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(MicroCParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MicroCParser.LBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MicroCParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MicroCParser.RBRACE, i);
		}
		public List<LexprContext> lexpr() {
			return getRuleContexts(LexprContext.class);
		}
		public LexprContext lexpr(int i) {
			return getRuleContext(LexprContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(MicroCParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(MicroCParser.EQUAL, i);
		}
		public List<RexprContext> rexpr() {
			return getRuleContexts(RexprContext.class);
		}
		public RexprContext rexpr(int i) {
			return getRuleContext(RexprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MicroCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MicroCParser.SEMI, i);
		}
		public List<TerminalNode> R() { return getTokens(MicroCParser.R); }
		public TerminalNode R(int i) {
			return getToken(MicroCParser.R, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MicroCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MicroCParser.COMMA, i);
		}
		public List<TerminalNode> WHILE() { return getTokens(MicroCParser.WHILE); }
		public TerminalNode WHILE(int i) {
			return getToken(MicroCParser.WHILE, i);
		}
		public List<TerminalNode> READ() { return getTokens(MicroCParser.READ); }
		public TerminalNode READ(int i) {
			return getToken(MicroCParser.READ, i);
		}
		public List<TerminalNode> WRITE() { return getTokens(MicroCParser.WRITE); }
		public TerminalNode WRITE(int i) {
			return getToken(MicroCParser.WRITE, i);
		}
		public List<TerminalNode> ELSE() { return getTokens(MicroCParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(MicroCParser.ELSE, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(25);
					match(IF);
					setState(26);
					match(LPAREN);
					setState(27);
					bexpr(0);
					setState(28);
					match(RPAREN);
					setState(29);
					match(LBRACE);
					setState(30);
					statement();
					setState(31);
					match(RBRACE);
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ELSE) {
						{
						setState(32);
						match(ELSE);
						setState(33);
						match(LBRACE);
						setState(34);
						statement();
						setState(35);
						match(RBRACE);
						}
					}

					}
					break;
				case 2:
					{
					setState(39);
					lexpr();
					setState(40);
					match(EQUAL);
					setState(41);
					rexpr(0);
					setState(42);
					match(SEMI);
					}
					break;
				case 3:
					{
					setState(44);
					match(R);
					setState(45);
					match(EQUAL);
					setState(46);
					match(LPAREN);
					setState(47);
					rexpr(0);
					setState(48);
					match(COMMA);
					setState(49);
					rexpr(0);
					setState(50);
					match(RPAREN);
					setState(51);
					match(SEMI);
					}
					break;
				case 4:
					{
					setState(53);
					match(WHILE);
					setState(54);
					match(LPAREN);
					setState(55);
					bexpr(0);
					setState(56);
					match(RPAREN);
					setState(57);
					match(LBRACE);
					setState(58);
					statement();
					setState(59);
					match(RBRACE);
					}
					break;
				case 5:
					{
					setState(61);
					match(READ);
					setState(62);
					lexpr();
					setState(63);
					match(SEMI);
					}
					break;
				case 6:
					{
					setState(65);
					match(WRITE);
					setState(66);
					rexpr(0);
					setState(67);
					match(SEMI);
					}
					break;
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << WRITE) | (1L << IF) | (1L << WHILE) | (1L << R) | (1L << IDENTIFIER))) != 0) );
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

	public static class LexprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode FST() { return getToken(MicroCParser.FST, 0); }
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public TerminalNode SND() { return getToken(MicroCParser.SND, 0); }
		public LexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterLexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitLexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitLexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexprContext lexpr() throws RecognitionException {
		LexprContext _localctx = new LexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lexpr);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(IDENTIFIER);
				setState(74);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(76);
				match(R);
				}
				setState(77);
				match(FST);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(78);
				match(R);
				}
				setState(79);
				match(SND);
				}
				break;
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

	public static class RexprContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode FST() { return getToken(MicroCParser.FST, 0); }
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public TerminalNode SND() { return getToken(MicroCParser.SND, 0); }
		public List<RexprContext> rexpr() {
			return getRuleContexts(RexprContext.class);
		}
		public RexprContext rexpr(int i) {
			return getRuleContext(RexprContext.class,i);
		}
		public OpaContext opa() {
			return getRuleContext(OpaContext.class,0);
		}
		public RexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterRexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitRexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitRexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexprContext rexpr() throws RecognitionException {
		return rexpr(0);
	}

	private RexprContext rexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RexprContext _localctx = new RexprContext(_ctx, _parentState);
		RexprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_rexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(83);
				match(INTEGER);
				}
				break;
			case 2:
				{
				setState(84);
				match(IDENTIFIER);
				setState(85);
				array();
				}
				break;
			case 3:
				{
				setState(86);
				match(IDENTIFIER);
				}
				break;
			case 4:
				{
				{
				setState(87);
				match(R);
				}
				setState(88);
				match(FST);
				}
				break;
			case 5:
				{
				{
				setState(89);
				match(R);
				}
				setState(90);
				match(SND);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rexpr);
					setState(93);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(94);
					opa();
					setState(95);
					rexpr(7);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(LBRACKET);
			setState(103);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
			match(RBRACKET);
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

	public static class BexprContext extends ParserRuleContext {
		public List<RexprContext> rexpr() {
			return getRuleContexts(RexprContext.class);
		}
		public RexprContext rexpr(int i) {
			return getRuleContext(RexprContext.class,i);
		}
		public OprContext opr() {
			return getRuleContext(OprContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(MicroCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MicroCParser.FALSE, 0); }
		public TerminalNode NOT() { return getToken(MicroCParser.NOT, 0); }
		public List<BexprContext> bexpr() {
			return getRuleContexts(BexprContext.class);
		}
		public BexprContext bexpr(int i) {
			return getRuleContext(BexprContext.class,i);
		}
		public OpbContext opb() {
			return getRuleContext(OpbContext.class,0);
		}
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitBexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		return bexpr(0);
	}

	private BexprContext bexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BexprContext _localctx = new BexprContext(_ctx, _parentState);
		BexprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(107);
				rexpr(0);
				setState(108);
				opr();
				setState(109);
				rexpr(0);
				}
				break;
			case TRUE:
				{
				setState(111);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(112);
				match(FALSE);
				}
				break;
			case NOT:
				{
				setState(113);
				match(NOT);
				setState(114);
				bexpr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
					setState(117);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(118);
					opb();
					setState(119);
					bexpr(5);
					}
					} 
				}
				setState(125);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(MicroCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MicroCParser.INT, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(MicroCParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MicroCParser.IDENTIFIER, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MicroCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MicroCParser.SEMI, i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(MicroCParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(MicroCParser.LBRACKET, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(MicroCParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(MicroCParser.INTEGER, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(MicroCParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(MicroCParser.RBRACKET, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(MicroCParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MicroCParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MicroCParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MicroCParser.RBRACE, i);
		}
		public List<TerminalNode> R() { return getTokens(MicroCParser.R); }
		public TerminalNode R(int i) {
			return getToken(MicroCParser.R, i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE || _la==INT) {
				{
				setState(144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(126);
					match(INT);
					setState(127);
					match(IDENTIFIER);
					setState(128);
					match(SEMI);
					}
					break;
				case 2:
					{
					setState(129);
					match(INT);
					setState(130);
					match(LBRACKET);
					setState(131);
					match(INTEGER);
					setState(132);
					match(RBRACKET);
					setState(133);
					match(IDENTIFIER);
					setState(134);
					match(SEMI);
					}
					break;
				case 3:
					{
					setState(135);
					match(LBRACE);
					setState(136);
					match(INT);
					setState(137);
					match(IDENTIFIER);
					setState(138);
					match(SEMI);
					setState(139);
					match(INT);
					setState(140);
					match(IDENTIFIER);
					setState(141);
					match(RBRACE);
					setState(142);
					match(R);
					setState(143);
					match(SEMI);
					}
					break;
				}
				}
				setState(148);
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

	public static class OpaContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MicroCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MicroCParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(MicroCParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MicroCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MicroCParser.MOD, 0); }
		public OpaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterOpa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitOpa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpaContext opa() throws RecognitionException {
		OpaContext _localctx = new OpaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
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

	public static class OprContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MicroCParser.GT, 0); }
		public TerminalNode LT() { return getToken(MicroCParser.LT, 0); }
		public TerminalNode GE() { return getToken(MicroCParser.GE, 0); }
		public TerminalNode LE() { return getToken(MicroCParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MicroCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MicroCParser.NEQ, 0); }
		public OprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitOpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
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

	public static class OpbContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MicroCParser.AND, 0); }
		public TerminalNode OR() { return getToken(MicroCParser.OR, 0); }
		public OpbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterOpb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitOpb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpbContext opb() throws RecognitionException {
		OpbContext _localctx = new OpbContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opb);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return rexpr_sempred((RexprContext)_localctx, predIndex);
		case 5:
			return bexpr_sempred((BexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rexpr_sempred(RexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean bexpr_sempred(BexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u009e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3(\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3H\n"+
		"\3\r\3\16\3I\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4S\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\5\3\5\7\5d\n\5\f\5\16\5g\13\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7v\n\7\3\7\3\7\3\7"+
		"\3\7\7\7|\n\7\f\7\16\7\177\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0093\n\b\f\b\16\b\u0096\13\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\2\4\b\f\f\2\4\6\b\n\f\16\20\22\24\2\6\3"+
		"\2#$\3\2\n\16\3\2\17\24\3\2\26\27\2\u00a9\2\26\3\2\2\2\4G\3\2\2\2\6R\3"+
		"\2\2\2\b]\3\2\2\2\nh\3\2\2\2\fu\3\2\2\2\16\u0094\3\2\2\2\20\u0097\3\2"+
		"\2\2\22\u0099\3\2\2\2\24\u009b\3\2\2\2\26\27\7\5\2\2\27\30\5\16\b\2\30"+
		"\31\5\4\3\2\31\32\7\6\2\2\32\3\3\2\2\2\33\34\7 \2\2\34\35\7\3\2\2\35\36"+
		"\5\f\7\2\36\37\7\4\2\2\37 \7\5\2\2 !\5\4\3\2!\'\7\6\2\2\"#\7\31\2\2#$"+
		"\7\5\2\2$%\5\4\3\2%&\7\6\2\2&(\3\2\2\2\'\"\3\2\2\2\'(\3\2\2\2(H\3\2\2"+
		"\2)*\5\6\4\2*+\7\35\2\2+,\5\b\5\2,-\7\7\2\2-H\3\2\2\2./\7\"\2\2/\60\7"+
		"\35\2\2\60\61\7\3\2\2\61\62\5\b\5\2\62\63\7\30\2\2\63\64\5\b\5\2\64\65"+
		"\7\4\2\2\65\66\7\7\2\2\66H\3\2\2\2\678\7!\2\289\7\3\2\29:\5\f\7\2:;\7"+
		"\4\2\2;<\7\5\2\2<=\5\4\3\2=>\7\6\2\2>H\3\2\2\2?@\7\36\2\2@A\5\6\4\2AB"+
		"\7\7\2\2BH\3\2\2\2CD\7\37\2\2DE\5\b\5\2EF\7\7\2\2FH\3\2\2\2G\33\3\2\2"+
		"\2G)\3\2\2\2G.\3\2\2\2G\67\3\2\2\2G?\3\2\2\2GC\3\2\2\2HI\3\2\2\2IG\3\2"+
		"\2\2IJ\3\2\2\2J\5\3\2\2\2KL\7$\2\2LS\5\n\6\2MS\7$\2\2NO\7\"\2\2OS\7\32"+
		"\2\2PQ\7\"\2\2QS\7\33\2\2RK\3\2\2\2RM\3\2\2\2RN\3\2\2\2RP\3\2\2\2S\7\3"+
		"\2\2\2TU\b\5\1\2U^\7#\2\2VW\7$\2\2W^\5\n\6\2X^\7$\2\2YZ\7\"\2\2Z^\7\32"+
		"\2\2[\\\7\"\2\2\\^\7\33\2\2]T\3\2\2\2]V\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]["+
		"\3\2\2\2^e\3\2\2\2_`\f\b\2\2`a\5\20\t\2ab\5\b\5\tbd\3\2\2\2c_\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\t\3\2\2\2ge\3\2\2\2hi\7\b\2\2ij\t\2\2"+
		"\2jk\7\t\2\2k\13\3\2\2\2lm\b\7\1\2mn\5\b\5\2no\5\22\n\2op\5\b\5\2pv\3"+
		"\2\2\2qv\7\'\2\2rv\7(\2\2st\7\25\2\2tv\5\f\7\3ul\3\2\2\2uq\3\2\2\2ur\3"+
		"\2\2\2us\3\2\2\2v}\3\2\2\2wx\f\6\2\2xy\5\24\13\2yz\5\f\7\7z|\3\2\2\2{"+
		"w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\r\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0081\7\34\2\2\u0081\u0082\7$\2\2\u0082\u0093\7\7\2\2\u0083\u0084\7\34"+
		"\2\2\u0084\u0085\7\b\2\2\u0085\u0086\7#\2\2\u0086\u0087\7\t\2\2\u0087"+
		"\u0088\7$\2\2\u0088\u0093\7\7\2\2\u0089\u008a\7\5\2\2\u008a\u008b\7\34"+
		"\2\2\u008b\u008c\7$\2\2\u008c\u008d\7\7\2\2\u008d\u008e\7\34\2\2\u008e"+
		"\u008f\7$\2\2\u008f\u0090\7\6\2\2\u0090\u0091\7\"\2\2\u0091\u0093\7\7"+
		"\2\2\u0092\u0080\3\2\2\2\u0092\u0083\3\2\2\2\u0092\u0089\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\17\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\t\3\2\2\u0098\21\3\2\2\2\u0099\u009a"+
		"\t\4\2\2\u009a\23\3\2\2\2\u009b\u009c\t\5\2\2\u009c\25\3\2\2\2\f\'GIR"+
		"]eu}\u0092\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}