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
		RULE_readStmnt = 8, RULE_writeStmnt = 9, RULE_lexpr = 10, RULE_recFst = 11, 
		RULE_recSnd = 12, RULE_varIdentifier = 13, RULE_arrayIndexId = 14, RULE_number = 15, 
		RULE_rexpr = 16, RULE_array = 17, RULE_bexpr = 18, RULE_decl = 19, RULE_varDecl = 20, 
		RULE_arrayDecl = 21, RULE_recordDecl = 22, RULE_opa = 23, RULE_opr = 24, 
		RULE_opb = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "blockStmnt", "statement", "ifElse", "elseStmnt", "lAssign", 
			"recordAssign", "whileStmnt", "readStmnt", "writeStmnt", "lexpr", "recFst", 
			"recSnd", "varIdentifier", "arrayIndexId", "number", "rexpr", "array", 
			"bexpr", "decl", "varDecl", "arrayDecl", "recordDecl", "opa", "opr", 
			"opb"
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
			setState(52);
			match(LBRACE);
			setState(53);
			decl();
			setState(54);
			statement();
			setState(55);
			match(RBRACE);
			setState(56);
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
			setState(58);
			match(LBRACE);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case RBRACE:
			case INT:
				{
				setState(59);
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
				setState(60);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63);
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
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(65);
					ifElse();
					}
					break;
				case 2:
					{
					setState(66);
					lAssign();
					}
					break;
				case 3:
					{
					setState(67);
					recordAssign();
					}
					break;
				case 4:
					{
					setState(68);
					whileStmnt();
					}
					break;
				case 5:
					{
					setState(69);
					readStmnt();
					}
					break;
				case 6:
					{
					setState(70);
					writeStmnt();
					}
					break;
				}
				}
				setState(73); 
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
			setState(75);
			match(IF);
			setState(76);
			match(LPAREN);
			setState(77);
			bexpr(0);
			setState(78);
			match(RPAREN);
			setState(79);
			blockStmnt();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(80);
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
			setState(83);
			match(ELSE);
			setState(84);
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
			setState(86);
			lexpr();
			setState(87);
			match(EQUAL);
			setState(88);
			rexpr(0);
			setState(89);
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
			setState(91);
			match(R);
			setState(92);
			match(EQUAL);
			setState(93);
			match(LPAREN);
			setState(94);
			rexpr(0);
			setState(95);
			match(COMMA);
			setState(96);
			rexpr(0);
			setState(97);
			match(RPAREN);
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
			setState(100);
			match(WHILE);
			setState(101);
			match(LPAREN);
			setState(102);
			bexpr(0);
			setState(103);
			match(RPAREN);
			setState(104);
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
			setState(106);
			match(READ);
			setState(107);
			lexpr();
			setState(108);
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
			setState(110);
			match(WRITE);
			setState(111);
			rexpr(0);
			setState(112);
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
		public ArrayIndexIdContext arrayIndexId() {
			return getRuleContext(ArrayIndexIdContext.class,0);
		}
		public VarIdentifierContext varIdentifier() {
			return getRuleContext(VarIdentifierContext.class,0);
		}
		public RecFstContext recFst() {
			return getRuleContext(RecFstContext.class,0);
		}
		public RecSndContext recSnd() {
			return getRuleContext(RecSndContext.class,0);
		}
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				arrayIndexId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				varIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				recFst();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				recSnd();
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

	public static class RecFstContext extends ParserRuleContext {
		public TerminalNode FST() { return getToken(MicroCParser.FST, 0); }
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public RecFstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recFst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitRecFst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecFstContext recFst() throws RecognitionException {
		RecFstContext _localctx = new RecFstContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_recFst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(120);
			match(R);
			}
			setState(121);
			match(FST);
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

	public static class RecSndContext extends ParserRuleContext {
		public TerminalNode SND() { return getToken(MicroCParser.SND, 0); }
		public TerminalNode R() { return getToken(MicroCParser.R, 0); }
		public RecSndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recSnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitRecSnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecSndContext recSnd() throws RecognitionException {
		RecSndContext _localctx = new RecSndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_recSnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(123);
			match(R);
			}
			setState(124);
			match(SND);
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

	public static class VarIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public VarIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varIdentifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitVarIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarIdentifierContext varIdentifier() throws RecognitionException {
		VarIdentifierContext _localctx = new VarIdentifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IDENTIFIER);
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

	public static class ArrayIndexIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayIndexIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayIndexId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitArrayIndexId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayIndexIdContext arrayIndexId() throws RecognitionException {
		ArrayIndexIdContext _localctx = new ArrayIndexIdContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayIndexId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(IDENTIFIER);
			setState(129);
			array();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(INTEGER);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ArrayIndexIdContext arrayIndexId() {
			return getRuleContext(ArrayIndexIdContext.class,0);
		}
		public VarIdentifierContext varIdentifier() {
			return getRuleContext(VarIdentifierContext.class,0);
		}
		public RecFstContext recFst() {
			return getRuleContext(RecFstContext.class,0);
		}
		public RecSndContext recSnd() {
			return getRuleContext(RecSndContext.class,0);
		}
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_rexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(134);
				number();
				}
				break;
			case 2:
				{
				setState(135);
				arrayIndexId();
				}
				break;
			case 3:
				{
				setState(136);
				varIdentifier();
				}
				break;
			case 4:
				{
				setState(137);
				recFst();
				}
				break;
			case 5:
				{
				setState(138);
				recSnd();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
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
					setState(141);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(142);
					opa();
					setState(143);
					rexpr(7);
					}
					} 
				}
				setState(149);
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
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(LBRACKET);
			setState(151);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(152);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(155);
				rexpr(0);
				setState(156);
				opr();
				setState(157);
				rexpr(0);
				}
				break;
			case TRUE:
				{
				setState(159);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(160);
				match(FALSE);
				}
				break;
			case NOT:
				{
				setState(161);
				match(NOT);
				setState(162);
				bexpr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
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
					setState(165);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(166);
					opb();
					setState(167);
					bexpr(5);
					}
					} 
				}
				setState(173);
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
		enterRule(_localctx, 38, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE || _la==INT) {
				{
				setState(177);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(174);
					varDecl();
					}
					break;
				case 2:
					{
					setState(175);
					arrayDecl();
					}
					break;
				case 3:
					{
					setState(176);
					recordDecl();
					}
					break;
				}
				}
				setState(181);
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
		public TerminalNode EQUAL() { return getToken(MicroCParser.EQUAL, 0); }
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
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
		enterRule(_localctx, 40, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(INT);
			setState(183);
			match(IDENTIFIER);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(184);
				match(EQUAL);
				setState(185);
				match(INTEGER);
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(188);
				match(SEMI);
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
		enterRule(_localctx, 42, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(INT);
			setState(192);
			match(LBRACKET);
			setState(193);
			match(INTEGER);
			setState(194);
			match(RBRACKET);
			setState(195);
			match(IDENTIFIER);
			setState(196);
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
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
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
		enterRule(_localctx, 44, RULE_recordDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(LBRACE);
			setState(199);
			varDecl();
			setState(200);
			varDecl();
			setState(201);
			match(RBRACE);
			setState(202);
			match(R);
			setState(203);
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
		enterRule(_localctx, 46, RULE_opa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		enterRule(_localctx, 48, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		enterRule(_localctx, 50, RULE_opb);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		case 16:
			return rexpr_sempred((RexprContext)_localctx, predIndex);
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3@\n\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4J\n\4\r\4\16\4K\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5T\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\5\fy\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u008e\n\22\3\22"+
		"\3\22\3\22\3\22\7\22\u0094\n\22\f\22\16\22\u0097\13\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a6\n\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00ac\n\24\f\24\16\24\u00af\13\24\3\25\3\25\3\25"+
		"\7\25\u00b4\n\25\f\25\16\25\u00b7\13\25\3\26\3\26\3\26\3\26\5\26\u00bd"+
		"\n\26\3\26\5\26\u00c0\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\2\4\"&\34"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\6\3\2%&\3"+
		"\2\n\16\3\2\17\24\3\2\26\27\2\u00d4\2\66\3\2\2\2\4<\3\2\2\2\6I\3\2\2\2"+
		"\bM\3\2\2\2\nU\3\2\2\2\fX\3\2\2\2\16]\3\2\2\2\20f\3\2\2\2\22l\3\2\2\2"+
		"\24p\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32}\3\2\2\2\34\u0080\3\2\2\2\36\u0082"+
		"\3\2\2\2 \u0085\3\2\2\2\"\u008d\3\2\2\2$\u0098\3\2\2\2&\u00a5\3\2\2\2"+
		"(\u00b5\3\2\2\2*\u00b8\3\2\2\2,\u00c1\3\2\2\2.\u00c8\3\2\2\2\60\u00cf"+
		"\3\2\2\2\62\u00d1\3\2\2\2\64\u00d3\3\2\2\2\66\67\7\5\2\2\678\5(\25\28"+
		"9\5\6\4\29:\7\6\2\2:;\7\2\2\3;\3\3\2\2\2<?\7\5\2\2=@\5(\25\2>@\5\6\4\2"+
		"?=\3\2\2\2?>\3\2\2\2@A\3\2\2\2AB\7\6\2\2B\5\3\2\2\2CJ\5\b\5\2DJ\5\f\7"+
		"\2EJ\5\16\b\2FJ\5\20\t\2GJ\5\22\n\2HJ\5\24\13\2IC\3\2\2\2ID\3\2\2\2IE"+
		"\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L"+
		"\7\3\2\2\2MN\7 \2\2NO\7\3\2\2OP\5&\24\2PQ\7\4\2\2QS\5\4\3\2RT\5\n\6\2"+
		"SR\3\2\2\2ST\3\2\2\2T\t\3\2\2\2UV\7\31\2\2VW\5\4\3\2W\13\3\2\2\2XY\5\26"+
		"\f\2YZ\7\35\2\2Z[\5\"\22\2[\\\7\7\2\2\\\r\3\2\2\2]^\7\"\2\2^_\7\35\2\2"+
		"_`\7\3\2\2`a\5\"\22\2ab\7\30\2\2bc\5\"\22\2cd\7\4\2\2de\7\7\2\2e\17\3"+
		"\2\2\2fg\7!\2\2gh\7\3\2\2hi\5&\24\2ij\7\4\2\2jk\5\4\3\2k\21\3\2\2\2lm"+
		"\7\36\2\2mn\5\26\f\2no\7\7\2\2o\23\3\2\2\2pq\7\37\2\2qr\5\"\22\2rs\7\7"+
		"\2\2s\25\3\2\2\2ty\5\36\20\2uy\5\34\17\2vy\5\30\r\2wy\5\32\16\2xt\3\2"+
		"\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\27\3\2\2\2z{\7\"\2\2{|\7\32\2\2|\31"+
		"\3\2\2\2}~\7\"\2\2~\177\7\33\2\2\177\33\3\2\2\2\u0080\u0081\7&\2\2\u0081"+
		"\35\3\2\2\2\u0082\u0083\7&\2\2\u0083\u0084\5$\23\2\u0084\37\3\2\2\2\u0085"+
		"\u0086\7%\2\2\u0086!\3\2\2\2\u0087\u0088\b\22\1\2\u0088\u008e\5 \21\2"+
		"\u0089\u008e\5\36\20\2\u008a\u008e\5\34\17\2\u008b\u008e\5\30\r\2\u008c"+
		"\u008e\5\32\16\2\u008d\u0087\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0095\3\2\2\2\u008f"+
		"\u0090\f\b\2\2\u0090\u0091\5\60\31\2\u0091\u0092\5\"\22\t\u0092\u0094"+
		"\3\2\2\2\u0093\u008f\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096#\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\b\2\2"+
		"\u0099\u009a\t\2\2\2\u009a\u009b\7\t\2\2\u009b%\3\2\2\2\u009c\u009d\b"+
		"\24\1\2\u009d\u009e\5\"\22\2\u009e\u009f\5\62\32\2\u009f\u00a0\5\"\22"+
		"\2\u00a0\u00a6\3\2\2\2\u00a1\u00a6\7#\2\2\u00a2\u00a6\7$\2\2\u00a3\u00a4"+
		"\7\25\2\2\u00a4\u00a6\5&\24\3\u00a5\u009c\3\2\2\2\u00a5\u00a1\3\2\2\2"+
		"\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00ad\3\2\2\2\u00a7\u00a8"+
		"\f\6\2\2\u00a8\u00a9\5\64\33\2\u00a9\u00aa\5&\24\7\u00aa\u00ac\3\2\2\2"+
		"\u00ab\u00a7\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\'\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b4\5*\26\2\u00b1"+
		"\u00b4\5,\27\2\u00b2\u00b4\5.\30\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6)\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\34\2\2"+
		"\u00b9\u00bc\7&\2\2\u00ba\u00bb\7\35\2\2\u00bb\u00bd\7%\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00c0\7\7\2\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0+\3\2\2\2\u00c1\u00c2\7\34\2\2"+
		"\u00c2\u00c3\7\b\2\2\u00c3\u00c4\7%\2\2\u00c4\u00c5\7\t\2\2\u00c5\u00c6"+
		"\7&\2\2\u00c6\u00c7\7\7\2\2\u00c7-\3\2\2\2\u00c8\u00c9\7\5\2\2\u00c9\u00ca"+
		"\5*\26\2\u00ca\u00cb\5*\26\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\7\"\2\2\u00cd"+
		"\u00ce\7\7\2\2\u00ce/\3\2\2\2\u00cf\u00d0\t\3\2\2\u00d0\61\3\2\2\2\u00d1"+
		"\u00d2\t\4\2\2\u00d2\63\3\2\2\2\u00d3\u00d4\t\5\2\2\u00d4\65\3\2\2\2\17"+
		"?IKSx\u008d\u0095\u00a5\u00ad\u00b3\u00b5\u00bc\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}