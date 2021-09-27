// Generated from C:/Users/mkbm/Desktop/School/programanalysis/Program-Analysis-DTU-Fall-21/src/antlr\MicroC.g4 by ANTLR 4.9.1
package antlr;
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
		INT=26, EQUAL=27, READ=28, WRITE=29, IF=30, WHILE=31, R=32, TRUE=33, FALSE=34, 
		INTEGER=35, IDENTIFIER=36, COMMENT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_blockStmnt = 1, RULE_statement = 2, RULE_ifElse = 3, 
		RULE_elseStmnt = 4, RULE_lAssign = 5, RULE_recordAssign = 6, RULE_whileStmnt = 7, 
		RULE_readStmnt = 8, RULE_writeStmnt = 9, RULE_lexpr = 10, RULE_rexpr = 11, 
		RULE_array = 12, RULE_bexpr = 13, RULE_decl = 14, RULE_varDecl = 15, RULE_arrayDecl = 16, 
		RULE_recordDecl = 17, RULE_opa = 18, RULE_opr = 19, RULE_opb = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "blockStmnt", "statement", "ifElse", "elseStmnt", "lAssign", 
			"recordAssign", "whileStmnt", "readStmnt", "writeStmnt", "lexpr", "rexpr", 
			"array", "bexpr", "decl", "varDecl", "arrayDecl", "recordDecl", "opa", 
			"opr", "opb"
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
		public TerminalNode EOF() { return getToken(MicroCParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
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
			setState(42);
			match(LBRACE);
			setState(43);
			decl();
			setState(44);
			statement();
			setState(45);
			match(RBRACE);
			setState(46);
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

	public static class BlockStmntContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmnt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitBlockStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmntContext blockStmnt() throws RecognitionException {
		BlockStmntContext _localctx = new BlockStmntContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_blockStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(LBRACE);
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case RBRACE:
			case INT:
				{
				setState(49);
				decl();
				}
				break;
			case READ:
			case WRITE:
			case IF:
			case WHILE:
			case R:
			case IDENTIFIER:
				{
				setState(50);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53);
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
		public List<IfElseContext> ifElse() {
			return getRuleContexts(IfElseContext.class);
		}
		public IfElseContext ifElse(int i) {
			return getRuleContext(IfElseContext.class,i);
		}
		public List<LAssignContext> lAssign() {
			return getRuleContexts(LAssignContext.class);
		}
		public LAssignContext lAssign(int i) {
			return getRuleContext(LAssignContext.class,i);
		}
		public List<RecordAssignContext> recordAssign() {
			return getRuleContexts(RecordAssignContext.class);
		}
		public RecordAssignContext recordAssign(int i) {
			return getRuleContext(RecordAssignContext.class,i);
		}
		public List<WhileStmntContext> whileStmnt() {
			return getRuleContexts(WhileStmntContext.class);
		}
		public WhileStmntContext whileStmnt(int i) {
			return getRuleContext(WhileStmntContext.class,i);
		}
		public List<ReadStmntContext> readStmnt() {
			return getRuleContexts(ReadStmntContext.class);
		}
		public ReadStmntContext readStmnt(int i) {
			return getRuleContext(ReadStmntContext.class,i);
		}
		public List<WriteStmntContext> writeStmnt() {
			return getRuleContexts(WriteStmntContext.class);
		}
		public WriteStmntContext writeStmnt(int i) {
			return getRuleContext(WriteStmntContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(61);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(55);
					ifElse();
					}
					break;
				case 2:
					{
					setState(56);
					lAssign();
					}
					break;
				case 3:
					{
					setState(57);
					recordAssign();
					}
					break;
				case 4:
					{
					setState(58);
					whileStmnt();
					}
					break;
				case 5:
					{
					setState(59);
					readStmnt();
					}
					break;
				case 6:
					{
					setState(60);
					writeStmnt();
					}
					break;
				}
				}
				setState(63); 
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

	public static class IfElseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MicroCParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public BlockStmntContext blockStmnt() {
			return getRuleContext(BlockStmntContext.class,0);
		}
		public ElseStmntContext elseStmnt() {
			return getRuleContext(ElseStmntContext.class,0);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifElse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(IF);
			setState(66);
			match(LPAREN);
			setState(67);
			bexpr(0);
			setState(68);
			match(RPAREN);
			setState(69);
			blockStmnt();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(70);
				elseStmnt();
				}
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

	public static class ElseStmntContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MicroCParser.ELSE, 0); }
		public BlockStmntContext blockStmnt() {
			return getRuleContext(BlockStmntContext.class,0);
		}
		public ElseStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmnt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitElseStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmntContext elseStmnt() throws RecognitionException {
		ElseStmntContext _localctx = new ElseStmntContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ELSE);
			setState(74);
			blockStmnt();
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

	public static class LAssignContext extends ParserRuleContext {
		public LexprContext lexpr() {
			return getRuleContext(LexprContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(MicroCParser.EQUAL, 0); }
		public RexprContext rexpr() {
			return getRuleContext(RexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public LAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lAssign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitLAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LAssignContext lAssign() throws RecognitionException {
		LAssignContext _localctx = new LAssignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			lexpr();
			setState(77);
			match(EQUAL);
			setState(78);
			rexpr(0);
			setState(79);
			match(SEMI);
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

	public static class RecordAssignContext extends ParserRuleContext {
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public TerminalNode EQUAL() { return getToken(MicroCParser.EQUAL, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public List<RexprContext> rexpr() {
			return getRuleContexts(RexprContext.class);
		}
		public RexprContext rexpr(int i) {
			return getRuleContext(RexprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MicroCParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public RecordAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordAssign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitRecordAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordAssignContext recordAssign() throws RecognitionException {
		RecordAssignContext _localctx = new RecordAssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_recordAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(R);
			setState(82);
			match(EQUAL);
			setState(83);
			match(LPAREN);
			setState(84);
			rexpr(0);
			setState(85);
			match(COMMA);
			setState(86);
			rexpr(0);
			setState(87);
			match(RPAREN);
			setState(88);
			match(SEMI);
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

	public static class WhileStmntContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MicroCParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public BlockStmntContext blockStmnt() {
			return getRuleContext(BlockStmntContext.class,0);
		}
		public WhileStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmnt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitWhileStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmntContext whileStmnt() throws RecognitionException {
		WhileStmntContext _localctx = new WhileStmntContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(WHILE);
			setState(91);
			match(LPAREN);
			setState(92);
			bexpr(0);
			setState(93);
			match(RPAREN);
			setState(94);
			blockStmnt();
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

	public static class ReadStmntContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MicroCParser.READ, 0); }
		public LexprContext lexpr() {
			return getRuleContext(LexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public ReadStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmnt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitReadStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStmntContext readStmnt() throws RecognitionException {
		ReadStmntContext _localctx = new ReadStmntContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_readStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(READ);
			setState(97);
			lexpr();
			setState(98);
			match(SEMI);
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

	public static class WriteStmntContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MicroCParser.WRITE, 0); }
		public RexprContext rexpr() {
			return getRuleContext(RexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public WriteStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmnt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitWriteStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStmntContext writeStmnt() throws RecognitionException {
		WriteStmntContext _localctx = new WriteStmntContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_writeStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(WRITE);
			setState(101);
			rexpr(0);
			setState(102);
			match(SEMI);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitLexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexprContext lexpr() throws RecognitionException {
		LexprContext _localctx = new LexprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lexpr);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(IDENTIFIER);
				setState(105);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(107);
				match(R);
				}
				setState(108);
				match(FST);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(109);
				match(R);
				}
				setState(110);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_rexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(114);
				match(INTEGER);
				}
				break;
			case 2:
				{
				setState(115);
				match(IDENTIFIER);
				setState(116);
				array();
				}
				break;
			case 3:
				{
				setState(117);
				match(IDENTIFIER);
				}
				break;
			case 4:
				{
				{
				setState(118);
				match(R);
				}
				setState(119);
				match(FST);
				}
				break;
			case 5:
				{
				{
				setState(120);
				match(R);
				}
				setState(121);
				match(SND);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rexpr);
					setState(124);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(125);
					opa();
					setState(126);
					rexpr(7);
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LBRACKET);
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(135);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(138);
				rexpr(0);
				setState(139);
				opr();
				setState(140);
				rexpr(0);
				}
				break;
			case TRUE:
				{
				setState(142);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(143);
				match(FALSE);
				}
				break;
			case NOT:
				{
				setState(144);
				match(NOT);
				setState(145);
				bexpr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
					setState(148);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(149);
					opb();
					setState(150);
					bexpr(5);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<RecordDeclContext> recordDecl() {
			return getRuleContexts(RecordDeclContext.class);
		}
		public RecordDeclContext recordDecl(int i) {
			return getRuleContext(RecordDeclContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE || _la==INT) {
				{
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(157);
					varDecl();
					}
					break;
				case 2:
					{
					setState(158);
					arrayDecl();
					}
					break;
				case 3:
					{
					setState(159);
					recordDecl();
					}
					break;
				}
				}
				setState(164);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MicroCParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public TerminalNode EQUAL() { return getToken(MicroCParser.EQUAL, 0); }
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(INT);
			setState(166);
			match(IDENTIFIER);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(167);
				match(EQUAL);
				setState(168);
				match(INTEGER);
				}
			}

			setState(171);
			match(SEMI);
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MicroCParser.INT, 0); }
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(INT);
			setState(174);
			match(LBRACKET);
			setState(175);
			match(INTEGER);
			setState(176);
			match(RBRACKET);
			setState(177);
			match(IDENTIFIER);
			setState(178);
			match(SEMI);
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

	public static class RecordDeclContext extends ParserRuleContext {
		public BlockStmntContext blockStmnt() {
			return getRuleContext(BlockStmntContext.class,0);
		}
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public RecordDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitRecordDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordDeclContext recordDecl() throws RecognitionException {
		RecordDeclContext _localctx = new RecordDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_recordDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			blockStmnt();
			setState(181);
			match(R);
			setState(182);
			match(SEMI);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpaContext opa() throws RecognitionException {
		OpaContext _localctx = new OpaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_opa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpbContext opb() throws RecognitionException {
		OpbContext _localctx = new OpbContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_opb);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		case 11:
			return rexpr_sempred((RexprContext)_localctx, predIndex);
		case 13:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00c1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\5\3\66\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4@\n\4\r\4\16\4A\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fr\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r}\n\r\3\r\3\r\3\r\3\r\7\r\u0083\n\r\f\r\16"+
		"\r\u0086\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u0095\n\17\3\17\3\17\3\17\3\17\7\17\u009b\n\17\f\17\16\17"+
		"\u009e\13\17\3\20\3\20\3\20\7\20\u00a3\n\20\f\20\16\20\u00a6\13\20\3\21"+
		"\3\21\3\21\3\21\5\21\u00ac\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\4\30\34"+
		"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\6\3\2%&\3\2\n\16\3"+
		"\2\17\24\3\2\26\27\2\u00c3\2,\3\2\2\2\4\62\3\2\2\2\6?\3\2\2\2\bC\3\2\2"+
		"\2\nK\3\2\2\2\fN\3\2\2\2\16S\3\2\2\2\20\\\3\2\2\2\22b\3\2\2\2\24f\3\2"+
		"\2\2\26q\3\2\2\2\30|\3\2\2\2\32\u0087\3\2\2\2\34\u0094\3\2\2\2\36\u00a4"+
		"\3\2\2\2 \u00a7\3\2\2\2\"\u00af\3\2\2\2$\u00b6\3\2\2\2&\u00ba\3\2\2\2"+
		"(\u00bc\3\2\2\2*\u00be\3\2\2\2,-\7\5\2\2-.\5\36\20\2./\5\6\4\2/\60\7\6"+
		"\2\2\60\61\7\2\2\3\61\3\3\2\2\2\62\65\7\5\2\2\63\66\5\36\20\2\64\66\5"+
		"\6\4\2\65\63\3\2\2\2\65\64\3\2\2\2\66\67\3\2\2\2\678\7\6\2\28\5\3\2\2"+
		"\29@\5\b\5\2:@\5\f\7\2;@\5\16\b\2<@\5\20\t\2=@\5\22\n\2>@\5\24\13\2?9"+
		"\3\2\2\2?:\3\2\2\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@A\3\2\2\2A"+
		"?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2CD\7 \2\2DE\7\3\2\2EF\5\34\17\2FG\7\4\2"+
		"\2GI\5\4\3\2HJ\5\n\6\2IH\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KL\7\31\2\2LM\5\4"+
		"\3\2M\13\3\2\2\2NO\5\26\f\2OP\7\35\2\2PQ\5\30\r\2QR\7\7\2\2R\r\3\2\2\2"+
		"ST\7\"\2\2TU\7\35\2\2UV\7\3\2\2VW\5\30\r\2WX\7\30\2\2XY\5\30\r\2YZ\7\4"+
		"\2\2Z[\7\7\2\2[\17\3\2\2\2\\]\7!\2\2]^\7\3\2\2^_\5\34\17\2_`\7\4\2\2`"+
		"a\5\4\3\2a\21\3\2\2\2bc\7\36\2\2cd\5\26\f\2de\7\7\2\2e\23\3\2\2\2fg\7"+
		"\37\2\2gh\5\30\r\2hi\7\7\2\2i\25\3\2\2\2jk\7&\2\2kr\5\32\16\2lr\7&\2\2"+
		"mn\7\"\2\2nr\7\32\2\2op\7\"\2\2pr\7\33\2\2qj\3\2\2\2ql\3\2\2\2qm\3\2\2"+
		"\2qo\3\2\2\2r\27\3\2\2\2st\b\r\1\2t}\7%\2\2uv\7&\2\2v}\5\32\16\2w}\7&"+
		"\2\2xy\7\"\2\2y}\7\32\2\2z{\7\"\2\2{}\7\33\2\2|s\3\2\2\2|u\3\2\2\2|w\3"+
		"\2\2\2|x\3\2\2\2|z\3\2\2\2}\u0084\3\2\2\2~\177\f\b\2\2\177\u0080\5&\24"+
		"\2\u0080\u0081\5\30\r\t\u0081\u0083\3\2\2\2\u0082~\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\31\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0088\7\b\2\2\u0088\u0089\t\2\2\2\u0089\u008a\7\t"+
		"\2\2\u008a\33\3\2\2\2\u008b\u008c\b\17\1\2\u008c\u008d\5\30\r\2\u008d"+
		"\u008e\5(\25\2\u008e\u008f\5\30\r\2\u008f\u0095\3\2\2\2\u0090\u0095\7"+
		"#\2\2\u0091\u0095\7$\2\2\u0092\u0093\7\25\2\2\u0093\u0095\5\34\17\3\u0094"+
		"\u008b\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u009c\3\2\2\2\u0096\u0097\f\6\2\2\u0097\u0098\5*\26\2\u0098"+
		"\u0099\5\34\17\7\u0099\u009b\3\2\2\2\u009a\u0096\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\35\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a3\5 \21\2\u00a0\u00a3\5\"\22\2\u00a1\u00a3\5"+
		"$\23\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\37\3\2\2"+
		"\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\34\2\2\u00a8\u00ab\7&\2\2\u00a9\u00aa"+
		"\7\35\2\2\u00aa\u00ac\7%\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\7\7\2\2\u00ae!\3\2\2\2\u00af\u00b0\7\34\2\2"+
		"\u00b0\u00b1\7\b\2\2\u00b1\u00b2\7%\2\2\u00b2\u00b3\7\t\2\2\u00b3\u00b4"+
		"\7&\2\2\u00b4\u00b5\7\7\2\2\u00b5#\3\2\2\2\u00b6\u00b7\5\4\3\2\u00b7\u00b8"+
		"\7\"\2\2\u00b8\u00b9\7\7\2\2\u00b9%\3\2\2\2\u00ba\u00bb\t\3\2\2\u00bb"+
		"\'\3\2\2\2\u00bc\u00bd\t\4\2\2\u00bd)\3\2\2\2\u00be\u00bf\t\5\2\2\u00bf"+
		"+\3\2\2\2\16\65?AIq|\u0084\u0094\u009c\u00a2\u00a4\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}