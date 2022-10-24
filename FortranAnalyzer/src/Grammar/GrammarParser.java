// Generated from C:/Users/Erwin14k/Documents/olc2vj22_202001534/FortranAnalyzer\Grammar.g4 by ANTLR 4.10.1
package Grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, INT=59, DOUBLE=60, 
		IDEN=61, COMMENT=62, STRING=63, STRING2=64, WS=65;
	public static final int
		RULE_start = 0, RULE_listaInstrucciones = 1, RULE_instruction = 2, RULE_declaration = 3, 
		RULE_asignation = 4, RULE_print = 5, RULE_expr = 6, RULE_if_ = 7, RULE_statement = 8, 
		RULE_else_ = 9, RULE_doWhile = 10, RULE_whileStatement = 11, RULE_for_ = 12, 
		RULE_forStatement = 13, RULE_function = 14, RULE_funStatement = 15, RULE_programStatement = 16, 
		RULE_functionCall = 17, RULE_subroutine = 18, RULE_decParameter = 19, 
		RULE_subStatement = 20, RULE_subroutineCall = 21, RULE_arrayDeclaration = 22, 
		RULE_program = 23, RULE_oneDimArrayAsig = 24, RULE_twoDimArrayAsig = 25, 
		RULE_oneArrayListAsig = 26, RULE_arrayDeclaration2 = 27, RULE_continue_ = 28, 
		RULE_break_ = 29, RULE_dynamicArrayDec = 30, RULE_allocate = 31, RULE_deallocate = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "listaInstrucciones", "instruction", "declaration", "asignation", 
			"print", "expr", "if_", "statement", "else_", "doWhile", "whileStatement", 
			"for_", "forStatement", "function", "funStatement", "programStatement", 
			"functionCall", "subroutine", "decParameter", "subStatement", "subroutineCall", 
			"arrayDeclaration", "program", "oneDimArrayAsig", "twoDimArrayAsig", 
			"oneArrayListAsig", "arrayDeclaration2", "continue_", "break_", "dynamicArrayDec", 
			"allocate", "deallocate"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'integer'", "'character'", "'complex'", "'logical'", "'real'", 
			"':'", "'='", "','", "'print'", "'*'", "'-'", "'**'", "'/'", "'+'", "'=='", 
			"'.eq.'", "'/='", "'.ne.'", "'>='", "'.ge.'", "'<='", "'.le.'", "'>'", 
			"'.gt.'", "'<'", "'.lt.'", "'.and.'", "'.or.'", "'.not.'", "'('", "')'", 
			"'.true.'", "'.false.'", "'['", "']'", "'size'", "'if'", "'then'", "'endif'", 
			"'else'", "'do'", "'while'", "'end'", "'function'", "'result'", "'implicit'", 
			"'none'", "'subroutine'", "'intent'", "'in'", "'call'", "'dimension'", 
			"'program'", "'cycle'", "'exit'", "'allocatable'", "'allocate'", "'deallocate'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"DOUBLE", "IDEN", "COMMENT", "STRING", "STRING2", "WS"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ListaInstruccionesContext listaInstrucciones() {
			return getRuleContext(ListaInstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			listaInstrucciones();
			setState(67);
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

	public static class ListaInstruccionesContext extends ParserRuleContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ListaInstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaInstrucciones; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitListaInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaInstruccionesContext listaInstrucciones() throws RecognitionException {
		ListaInstruccionesContext _localctx = new ListaInstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaInstrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(69);
				((ListaInstruccionesContext)_localctx).instruction = instruction();
				((ListaInstruccionesContext)_localctx).e.add(((ListaInstruccionesContext)_localctx).instruction);
				}
				}
				setState(74);
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

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubContext extends InstructionContext {
		public SubroutineContext subroutine() {
			return getRuleContext(SubroutineContext.class,0);
		}
		public SubContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrD2Context extends InstructionContext {
		public ArrayDeclaration2Context arrayDeclaration2() {
			return getRuleContext(ArrayDeclaration2Context.class,0);
		}
		public ArrD2Context(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrD2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlloContext extends InstructionContext {
		public AllocateContext allocate() {
			return getRuleContext(AllocateContext.class,0);
		}
		public AlloContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAllo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TwoArrAsContext extends InstructionContext {
		public TwoDimArrayAsigContext twoDimArrayAsig() {
			return getRuleContext(TwoDimArrayAsigContext.class,0);
		}
		public TwoArrAsContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTwoArrAs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FoContext extends InstructionContext {
		public For_Context for_() {
			return getRuleContext(For_Context.class,0);
		}
		public FoContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrDContext extends InstructionContext {
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public ArrDContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrD(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PtrContext extends InstructionContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public PtrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPtr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsIfContext extends InstructionContext {
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public InsIfContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInsIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeallContext extends InstructionContext {
		public DeallocateContext deallocate() {
			return getRuleContext(DeallocateContext.class,0);
		}
		public DeallContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsContext extends InstructionContext {
		public AsignationContext asignation() {
			return getRuleContext(AsignationContext.class,0);
		}
		public AsContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DwContext extends InstructionContext {
		public DoWhileContext doWhile() {
			return getRuleContext(DoWhileContext.class,0);
		}
		public DwContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDw(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneArrListAsContext extends InstructionContext {
		public OneArrayListAsigContext oneArrayListAsig() {
			return getRuleContext(OneArrayListAsigContext.class,0);
		}
		public OneArrListAsContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOneArrListAs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreContext extends InstructionContext {
		public Break_Context break_() {
			return getRuleContext(Break_Context.class,0);
		}
		public BreContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBre(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Dynamic1Context extends InstructionContext {
		public DynamicArrayDecContext dynamicArrayDec() {
			return getRuleContext(DynamicArrayDecContext.class,0);
		}
		public Dynamic1Context(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDynamic1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubCContext extends InstructionContext {
		public SubroutineCallContext subroutineCall() {
			return getRuleContext(SubroutineCallContext.class,0);
		}
		public SubCContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSubC(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarContext extends InstructionContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeclar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComeOnContext extends InstructionContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ComeOnContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitComeOn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContContext extends InstructionContext {
		public Continue_Context continue_() {
			return getRuleContext(Continue_Context.class,0);
		}
		public ContContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCont(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FcContext extends InstructionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FcContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunContext extends InstructionContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneArrAsContext extends InstructionContext {
		public OneDimArrayAsigContext oneDimArrayAsig() {
			return getRuleContext(OneDimArrayAsigContext.class,0);
		}
		public OneArrAsContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOneArrAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DeclarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				declaration();
				}
				break;
			case 2:
				_localctx = new PtrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				print();
				}
				break;
			case 3:
				_localctx = new InsIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				if_();
				}
				break;
			case 4:
				_localctx = new DwContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				doWhile();
				}
				break;
			case 5:
				_localctx = new FoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				for_();
				}
				break;
			case 6:
				_localctx = new AsContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				asignation();
				}
				break;
			case 7:
				_localctx = new FunContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				function();
				}
				break;
			case 8:
				_localctx = new FcContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				functionCall();
				}
				break;
			case 9:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(83);
				subroutine();
				}
				break;
			case 10:
				_localctx = new SubCContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(84);
				subroutineCall();
				}
				break;
			case 11:
				_localctx = new ArrDContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(85);
				arrayDeclaration();
				}
				break;
			case 12:
				_localctx = new ArrD2Context(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(86);
				arrayDeclaration2();
				}
				break;
			case 13:
				_localctx = new ComeOnContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(87);
				program();
				}
				break;
			case 14:
				_localctx = new OneArrAsContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(88);
				oneDimArrayAsig();
				}
				break;
			case 15:
				_localctx = new OneArrListAsContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(89);
				oneArrayListAsig();
				}
				break;
			case 16:
				_localctx = new TwoArrAsContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(90);
				twoDimArrayAsig();
				}
				break;
			case 17:
				_localctx = new ContContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(91);
				continue_();
				}
				break;
			case 18:
				_localctx = new BreContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(92);
				break_();
				}
				break;
			case 19:
				_localctx = new Dynamic1Context(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(93);
				dynamicArrayDec();
				}
				break;
			case 20:
				_localctx = new AlloContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(94);
				allocate();
				}
				break;
			case 21:
				_localctx = new DeallContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(95);
				deallocate();
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingularNullContext extends DeclarationContext {
		public Token t;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public SingularNullContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSingularNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PluralNullContext extends DeclarationContext {
		public Token t;
		public Token IDEN;
		public List<Token> p = new ArrayList<Token>();
		public List<Token> e = new ArrayList<Token>();
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public PluralNullContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPluralNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingularActiveContext extends DeclarationContext {
		public Token t;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SingularActiveContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSingularActive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PluralActiveContext extends DeclarationContext {
		public Token t;
		public Token IDEN;
		public List<Token> p = new ArrayList<Token>();
		public List<Token> e = new ArrayList<Token>();
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public PluralActiveContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPluralActive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SingularNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((SingularNullContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
					((SingularNullContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				match(T__5);
				setState(100);
				match(T__5);
				setState(101);
				match(IDEN);
				}
				break;
			case 2:
				_localctx = new SingularActiveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((SingularActiveContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
					((SingularActiveContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(103);
				match(T__5);
				setState(104);
				match(T__5);
				setState(105);
				match(IDEN);
				setState(106);
				match(T__6);
				setState(107);
				expr(0);
				}
				break;
			case 3:
				_localctx = new PluralNullContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				((PluralNullContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
					((PluralNullContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(109);
				match(T__5);
				setState(110);
				match(T__5);
				setState(111);
				((PluralNullContext)_localctx).IDEN = match(IDEN);
				((PluralNullContext)_localctx).p.add(((PluralNullContext)_localctx).IDEN);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(112);
					match(T__7);
					setState(113);
					((PluralNullContext)_localctx).IDEN = match(IDEN);
					((PluralNullContext)_localctx).e.add(((PluralNullContext)_localctx).IDEN);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				_localctx = new PluralActiveContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				((PluralActiveContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
					((PluralActiveContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(120);
				match(T__5);
				setState(121);
				match(T__5);
				setState(122);
				((PluralActiveContext)_localctx).IDEN = match(IDEN);
				((PluralActiveContext)_localctx).p.add(((PluralActiveContext)_localctx).IDEN);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(123);
					match(T__7);
					setState(124);
					((PluralActiveContext)_localctx).IDEN = match(IDEN);
					((PluralActiveContext)_localctx).e.add(((PluralActiveContext)_localctx).IDEN);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(T__6);
				setState(131);
				expr(0);
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

	public static class AsignationContext extends ParserRuleContext {
		public AsignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignation; }
	 
		public AsignationContext() { }
		public void copyFrom(AsignationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsigContext extends AsignationContext {
		public Token o;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public AsigContext(AsignationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignationContext asignation() throws RecognitionException {
		AsignationContext _localctx = new AsignationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignation);
		try {
			_localctx = new AsigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((AsigContext)_localctx).o = match(IDEN);
			setState(135);
			match(T__6);
			setState(136);
			expr(0);
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

	public static class PrintContext extends ParserRuleContext {
		public Token ins;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((PrintContext)_localctx).ins = match(T__8);
			setState(139);
			match(T__9);
			setState(140);
			match(T__7);
			setState(141);
			((PrintContext)_localctx).expr = expr(0);
			((PrintContext)_localctx).p.add(((PrintContext)_localctx).expr);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(142);
				match(T__7);
				setState(143);
				((PrintContext)_localctx).expr = expr(0);
				((PrintContext)_localctx).e.add(((PrintContext)_localctx).expr);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrExprContext extends ExprContext {
		public Token str;
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public StrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFunctionReturnContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExprFunctionReturnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExprFunctionReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MayorExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MayorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMayorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public Token atom;
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneArrayAccessContext extends ExprContext {
		public Token id;
		public ExprContext ind;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OneArrayAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOneArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrExpr2Context extends ExprContext {
		public Token str2;
		public TerminalNode STRING2() { return getToken(GrammarParser.STRING2, 0); }
		public StrExpr2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStrExpr2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgualExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IgualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIgualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TwoArrayAccessContext extends ExprContext {
		public Token id;
		public ExprContext ind1;
		public ExprContext ind2;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TwoArrayAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTwoArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NgativeContext extends ExprContext {
		public Token op;
		public ExprContext u;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NgativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNgative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public Token op;
		public ExprContext left;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DouExprContext extends ExprContext {
		public Token dou;
		public TerminalNode DOUBLE() { return getToken(GrammarParser.DOUBLE, 0); }
		public DouExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDouExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenorExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MenorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMenorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MayorIgualExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MayorIgualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMayorIgualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiferenteExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DiferenteExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDiferenteExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public Token bool;
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenorIgualExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MenorIgualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMenorIgualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizeArrContext extends ExprContext {
		public Token t;
		public ExprContext id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SizeArrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSizeArr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NgativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(150);
				((NgativeContext)_localctx).op = match(T__10);
				setState(151);
				((NgativeContext)_localctx).u = expr(24);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				((NotExprContext)_localctx).op = match(T__28);
				setState(153);
				((NotExprContext)_localctx).left = expr(12);
				}
				break;
			case 3:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__29);
				setState(155);
				expr(0);
				setState(156);
				match(T__30);
				}
				break;
			case 4:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				((AtomExprContext)_localctx).atom = match(INT);
				}
				break;
			case 5:
				{
				_localctx = new DouExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				((DouExprContext)_localctx).dou = match(DOUBLE);
				}
				break;
			case 6:
				{
				_localctx = new StrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				((StrExprContext)_localctx).str = match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new StrExpr2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				((StrExpr2Context)_localctx).str2 = match(STRING2);
				}
				break;
			case 8:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				((BoolExprContext)_localctx).bool = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
					((BoolExprContext)_localctx).bool = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				((IdExprContext)_localctx).id = match(IDEN);
				}
				break;
			case 10:
				{
				_localctx = new OneArrayAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				((OneArrayAccessContext)_localctx).id = match(IDEN);
				setState(165);
				match(T__33);
				setState(166);
				((OneArrayAccessContext)_localctx).ind = expr(0);
				setState(167);
				match(T__34);
				}
				break;
			case 11:
				{
				_localctx = new TwoArrayAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				((TwoArrayAccessContext)_localctx).id = match(IDEN);
				setState(170);
				match(T__33);
				setState(171);
				((TwoArrayAccessContext)_localctx).ind1 = expr(0);
				setState(172);
				match(T__7);
				setState(173);
				((TwoArrayAccessContext)_localctx).ind2 = expr(0);
				setState(174);
				match(T__34);
				}
				break;
			case 12:
				{
				_localctx = new SizeArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				((SizeArrContext)_localctx).t = match(T__35);
				setState(177);
				match(T__29);
				setState(178);
				((SizeArrContext)_localctx).id = expr(0);
				setState(179);
				match(T__30);
				}
				break;
			case 13:
				{
				_localctx = new ExprFunctionReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(185);
						((OpExprContext)_localctx).op = match(T__11);
						setState(186);
						((OpExprContext)_localctx).right = expr(24);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(188);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__12) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(189);
						((OpExprContext)_localctx).right = expr(23);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(191);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__13) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(192);
						((OpExprContext)_localctx).right = expr(22);
						}
						break;
					case 4:
						{
						_localctx = new IgualExprContext(new ExprContext(_parentctx, _parentState));
						((IgualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(194);
						((IgualExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__15) ) {
							((IgualExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						((IgualExprContext)_localctx).right = expr(21);
						}
						break;
					case 5:
						{
						_localctx = new DiferenteExprContext(new ExprContext(_parentctx, _parentState));
						((DiferenteExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(197);
						((DiferenteExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((DiferenteExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						((DiferenteExprContext)_localctx).right = expr(20);
						}
						break;
					case 6:
						{
						_localctx = new MayorIgualExprContext(new ExprContext(_parentctx, _parentState));
						((MayorIgualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(200);
						((MayorIgualExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((MayorIgualExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(201);
						((MayorIgualExprContext)_localctx).right = expr(19);
						}
						break;
					case 7:
						{
						_localctx = new MenorIgualExprContext(new ExprContext(_parentctx, _parentState));
						((MenorIgualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(203);
						((MenorIgualExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((MenorIgualExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(204);
						((MenorIgualExprContext)_localctx).right = expr(18);
						}
						break;
					case 8:
						{
						_localctx = new MayorExprContext(new ExprContext(_parentctx, _parentState));
						((MayorExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(206);
						((MayorExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((MayorExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(207);
						((MayorExprContext)_localctx).right = expr(17);
						}
						break;
					case 9:
						{
						_localctx = new MenorExprContext(new ExprContext(_parentctx, _parentState));
						((MenorExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(209);
						((MenorExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((MenorExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(210);
						((MenorExprContext)_localctx).right = expr(16);
						}
						break;
					case 10:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(212);
						((AndExprContext)_localctx).op = match(T__26);
						setState(213);
						((AndExprContext)_localctx).right = expr(15);
						}
						break;
					case 11:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(215);
						((OrExprContext)_localctx).op = match(T__27);
						setState(216);
						((OrExprContext)_localctx).right = expr(14);
						}
						break;
					}
					} 
				}
				setState(221);
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

	public static class If_Context extends ParserRuleContext {
		public Token i;
		public Token th;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Else_Context else_() {
			return getRuleContext(Else_Context.class,0);
		}
		public If_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIf_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((If_Context)_localctx).i = match(T__36);
			setState(223);
			match(T__29);
			setState(224);
			expr(0);
			setState(225);
			match(T__30);
			setState(226);
			((If_Context)_localctx).th = match(T__37);
			setState(227);
			statement();
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(228);
				else_();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(231);
				match(T__38);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalIfStatementContext extends StatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public NormalIfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNormalIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			int _alt;
			_localctx = new NormalIfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(234);
					((NormalIfStatementContext)_localctx).instruction = instruction();
					((NormalIfStatementContext)_localctx).e.add(((NormalIfStatementContext)_localctx).instruction);
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Else_Context extends ParserRuleContext {
		public Else_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_; }
	 
		public Else_Context() { }
		public void copyFrom(Else_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ElseNormalContext extends Else_Context {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseNormalContext(Else_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitElseNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ElseIfNormalContext extends Else_Context {
		public Token i;
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public ElseIfNormalContext(Else_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitElseIfNormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_else_);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ElseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__39);
				setState(241);
				statement();
				}
				break;
			case 2:
				_localctx = new ElseIfNormalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				((ElseIfNormalContext)_localctx).i = match(T__39);
				setState(243);
				if_();
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

	public static class DoWhileContext extends ParserRuleContext {
		public Token i;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public DoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileContext doWhile() throws RecognitionException {
		DoWhileContext _localctx = new DoWhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_doWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDEN) {
				{
				setState(246);
				match(IDEN);
				}
			}

			setState(249);
			((DoWhileContext)_localctx).i = match(T__40);
			setState(250);
			match(T__41);
			setState(251);
			match(T__29);
			setState(252);
			expr(0);
			setState(253);
			match(T__30);
			setState(254);
			whileStatement();
			setState(255);
			match(T__42);
			setState(256);
			match(T__40);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	 
		public WhileStatementContext() { }
		public void copyFrom(WhileStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalWhileStatementContext extends WhileStatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public NormalWhileStatementContext(WhileStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNormalWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		int _la;
		try {
			_localctx = new NormalWhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(258);
				((NormalWhileStatementContext)_localctx).instruction = instruction();
				((NormalWhileStatementContext)_localctx).e.add(((NormalWhileStatementContext)_localctx).instruction);
				}
				}
				setState(263);
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

	public static class For_Context extends ParserRuleContext {
		public For_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_; }
	 
		public For_Context() { }
		public void copyFrom(For_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MediumForContext extends For_Context {
		public Token i;
		public ExprContext lim;
		public ExprContext sped;
		public AsignationContext asignation() {
			return getRuleContext(AsignationContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MediumForContext(For_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMediumFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EasyForContext extends For_Context {
		public Token i;
		public ExprContext ini;
		public ExprContext lim;
		public ExprContext sped;
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public EasyForContext(For_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitEasyFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_Context for_() throws RecognitionException {
		For_Context _localctx = new For_Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new EasyForContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDEN) {
					{
					setState(264);
					match(IDEN);
					}
				}

				setState(267);
				((EasyForContext)_localctx).i = match(T__40);
				setState(268);
				((EasyForContext)_localctx).ini = expr(0);
				setState(269);
				match(T__7);
				setState(270);
				((EasyForContext)_localctx).lim = expr(0);
				setState(271);
				match(T__7);
				setState(272);
				((EasyForContext)_localctx).sped = expr(0);
				setState(273);
				forStatement();
				setState(274);
				match(T__42);
				setState(275);
				match(T__40);
				}
				break;
			case 2:
				_localctx = new MediumForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				((MediumForContext)_localctx).i = match(T__40);
				setState(278);
				asignation();
				setState(279);
				match(T__7);
				setState(280);
				((MediumForContext)_localctx).lim = expr(0);
				setState(281);
				match(T__7);
				setState(282);
				((MediumForContext)_localctx).sped = expr(0);
				setState(283);
				forStatement();
				setState(284);
				match(T__42);
				setState(285);
				match(T__40);
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

	public static class ForStatementContext extends ParserRuleContext {
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	 
		public ForStatementContext() { }
		public void copyFrom(ForStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalForStatementContext extends ForStatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public NormalForStatementContext(ForStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNormalForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		int _la;
		try {
			_localctx = new NormalForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(289);
				((NormalForStatementContext)_localctx).instruction = instruction();
				((NormalForStatementContext)_localctx).e.add(((NormalForStatementContext)_localctx).instruction);
				}
				}
				setState(294);
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

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WithParamsFuncContext extends FunctionContext {
		public Token u;
		public Token name;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public Token res;
		public DecParameterContext decParameter;
		public List<DecParameterContext> l = new ArrayList<DecParameterContext>();
		public Token name2;
		public FunStatementContext funStatement() {
			return getRuleContext(FunStatementContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<DecParameterContext> decParameter() {
			return getRuleContexts(DecParameterContext.class);
		}
		public DecParameterContext decParameter(int i) {
			return getRuleContext(DecParameterContext.class,i);
		}
		public WithParamsFuncContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWithParamsFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithoutParamsFuncContext extends FunctionContext {
		public Token u;
		public Token name;
		public Token res;
		public DecParameterContext decParameter;
		public List<DecParameterContext> l = new ArrayList<DecParameterContext>();
		public Token name2;
		public FunStatementContext funStatement() {
			return getRuleContext(FunStatementContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public List<DecParameterContext> decParameter() {
			return getRuleContexts(DecParameterContext.class);
		}
		public DecParameterContext decParameter(int i) {
			return getRuleContext(DecParameterContext.class,i);
		}
		public WithoutParamsFuncContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWithoutParamsFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function);
		int _la;
		try {
			int _alt;
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new WithoutParamsFuncContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				((WithoutParamsFuncContext)_localctx).u = match(T__43);
				setState(296);
				((WithoutParamsFuncContext)_localctx).name = match(IDEN);
				setState(297);
				match(T__29);
				setState(298);
				match(T__30);
				setState(299);
				match(T__44);
				setState(300);
				match(T__29);
				setState(301);
				((WithoutParamsFuncContext)_localctx).res = match(IDEN);
				setState(302);
				match(T__30);
				setState(303);
				match(T__45);
				setState(304);
				match(T__46);
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(305);
						((WithoutParamsFuncContext)_localctx).decParameter = decParameter();
						((WithoutParamsFuncContext)_localctx).l.add(((WithoutParamsFuncContext)_localctx).decParameter);
						}
						} 
					}
					setState(310);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(311);
				funStatement();
				setState(312);
				match(T__42);
				setState(313);
				match(T__43);
				setState(314);
				((WithoutParamsFuncContext)_localctx).name2 = match(IDEN);
				}
				break;
			case 2:
				_localctx = new WithParamsFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				((WithParamsFuncContext)_localctx).u = match(T__43);
				setState(317);
				((WithParamsFuncContext)_localctx).name = match(IDEN);
				setState(318);
				match(T__29);
				setState(319);
				((WithParamsFuncContext)_localctx).expr = expr(0);
				((WithParamsFuncContext)_localctx).p.add(((WithParamsFuncContext)_localctx).expr);
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(320);
					match(T__7);
					setState(321);
					((WithParamsFuncContext)_localctx).expr = expr(0);
					((WithParamsFuncContext)_localctx).e.add(((WithParamsFuncContext)_localctx).expr);
					}
					}
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(327);
				match(T__30);
				setState(328);
				match(T__44);
				setState(329);
				match(T__29);
				setState(330);
				((WithParamsFuncContext)_localctx).res = match(IDEN);
				setState(331);
				match(T__30);
				setState(332);
				match(T__45);
				setState(333);
				match(T__46);
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(334);
						((WithParamsFuncContext)_localctx).decParameter = decParameter();
						((WithParamsFuncContext)_localctx).l.add(((WithParamsFuncContext)_localctx).decParameter);
						}
						} 
					}
					setState(339);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(340);
				funStatement();
				setState(341);
				match(T__42);
				setState(342);
				match(T__43);
				setState(343);
				((WithParamsFuncContext)_localctx).name2 = match(IDEN);
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

	public static class FunStatementContext extends ParserRuleContext {
		public FunStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funStatement; }
	 
		public FunStatementContext() { }
		public void copyFrom(FunStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalFuncStatementContext extends FunStatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public NormalFuncStatementContext(FunStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNormalFuncStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunStatementContext funStatement() throws RecognitionException {
		FunStatementContext _localctx = new FunStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_funStatement);
		int _la;
		try {
			_localctx = new NormalFuncStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(347);
				((NormalFuncStatementContext)_localctx).instruction = instruction();
				((NormalFuncStatementContext)_localctx).e.add(((NormalFuncStatementContext)_localctx).instruction);
				}
				}
				setState(352);
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

	public static class ProgramStatementContext extends ParserRuleContext {
		public ProgramStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programStatement; }
	 
		public ProgramStatementContext() { }
		public void copyFrom(ProgramStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainStatementContext extends ProgramStatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public MainStatementContext(ProgramStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMainStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramStatementContext programStatement() throws RecognitionException {
		ProgramStatementContext _localctx = new ProgramStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_programStatement);
		int _la;
		try {
			_localctx = new MainStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(353);
				((MainStatementContext)_localctx).instruction = instruction();
				((MainStatementContext)_localctx).e.add(((MainStatementContext)_localctx).instruction);
				}
				}
				setState(358);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncCallWithoutContext extends FunctionCallContext {
		public Token y;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public FuncCallWithoutContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncCallWithout(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallWithContext extends FunctionCallContext {
		public Token y;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallWithContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncCallWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionCall);
		int _la;
		try {
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new FuncCallWithContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				((FuncCallWithContext)_localctx).y = match(IDEN);
				setState(360);
				match(T__29);
				setState(361);
				((FuncCallWithContext)_localctx).expr = expr(0);
				((FuncCallWithContext)_localctx).p.add(((FuncCallWithContext)_localctx).expr);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(362);
					match(T__7);
					setState(363);
					((FuncCallWithContext)_localctx).expr = expr(0);
					((FuncCallWithContext)_localctx).e.add(((FuncCallWithContext)_localctx).expr);
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new FuncCallWithoutContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				((FuncCallWithoutContext)_localctx).y = match(IDEN);
				setState(372);
				match(T__29);
				setState(373);
				match(T__30);
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

	public static class SubroutineContext extends ParserRuleContext {
		public SubroutineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutine; }
	 
		public SubroutineContext() { }
		public void copyFrom(SubroutineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WithoutParamsSubContext extends SubroutineContext {
		public Token u;
		public Token name;
		public DecParameterContext decParameter;
		public List<DecParameterContext> l = new ArrayList<DecParameterContext>();
		public Token name2;
		public SubStatementContext subStatement() {
			return getRuleContext(SubStatementContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public List<DecParameterContext> decParameter() {
			return getRuleContexts(DecParameterContext.class);
		}
		public DecParameterContext decParameter(int i) {
			return getRuleContext(DecParameterContext.class,i);
		}
		public WithoutParamsSubContext(SubroutineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWithoutParamsSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithParamsSubContext extends SubroutineContext {
		public Token u;
		public Token name;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public DecParameterContext decParameter;
		public List<DecParameterContext> l = new ArrayList<DecParameterContext>();
		public Token name2;
		public SubStatementContext subStatement() {
			return getRuleContext(SubStatementContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<DecParameterContext> decParameter() {
			return getRuleContexts(DecParameterContext.class);
		}
		public DecParameterContext decParameter(int i) {
			return getRuleContext(DecParameterContext.class,i);
		}
		public WithParamsSubContext(SubroutineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWithParamsSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineContext subroutine() throws RecognitionException {
		SubroutineContext _localctx = new SubroutineContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subroutine);
		int _la;
		try {
			int _alt;
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new WithoutParamsSubContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				((WithoutParamsSubContext)_localctx).u = match(T__47);
				setState(377);
				((WithoutParamsSubContext)_localctx).name = match(IDEN);
				setState(378);
				match(T__29);
				setState(379);
				match(T__30);
				setState(380);
				match(T__45);
				setState(381);
				match(T__46);
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(382);
						((WithoutParamsSubContext)_localctx).decParameter = decParameter();
						((WithoutParamsSubContext)_localctx).l.add(((WithoutParamsSubContext)_localctx).decParameter);
						}
						} 
					}
					setState(387);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(388);
				subStatement();
				setState(389);
				match(T__42);
				setState(390);
				match(T__47);
				setState(391);
				((WithoutParamsSubContext)_localctx).name2 = match(IDEN);
				}
				break;
			case 2:
				_localctx = new WithParamsSubContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				((WithParamsSubContext)_localctx).u = match(T__47);
				setState(394);
				((WithParamsSubContext)_localctx).name = match(IDEN);
				setState(395);
				match(T__29);
				setState(396);
				((WithParamsSubContext)_localctx).expr = expr(0);
				((WithParamsSubContext)_localctx).p.add(((WithParamsSubContext)_localctx).expr);
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(397);
					match(T__7);
					setState(398);
					((WithParamsSubContext)_localctx).expr = expr(0);
					((WithParamsSubContext)_localctx).e.add(((WithParamsSubContext)_localctx).expr);
					}
					}
					setState(403);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(404);
				match(T__30);
				setState(405);
				match(T__45);
				setState(406);
				match(T__46);
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(407);
						((WithParamsSubContext)_localctx).decParameter = decParameter();
						((WithParamsSubContext)_localctx).l.add(((WithParamsSubContext)_localctx).decParameter);
						}
						} 
					}
					setState(412);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				setState(413);
				subStatement();
				setState(414);
				match(T__42);
				setState(415);
				match(T__47);
				setState(416);
				((WithParamsSubContext)_localctx).name2 = match(IDEN);
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

	public static class DecParameterContext extends ParserRuleContext {
		public DecParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decParameter; }
	 
		public DecParameterContext() { }
		public void copyFrom(DecParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecParContext extends DecParameterContext {
		public Token t;
		public Token k;
		public ExprContext u;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DecParContext(DecParameterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDecPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecParameterContext decParameter() throws RecognitionException {
		DecParameterContext _localctx = new DecParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_decParameter);
		int _la;
		try {
			_localctx = new DecParContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			((DecParContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
				((DecParContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(421);
			((DecParContext)_localctx).k = match(T__7);
			setState(422);
			match(T__48);
			setState(423);
			match(T__29);
			setState(424);
			match(T__49);
			setState(425);
			match(T__30);
			setState(426);
			match(T__5);
			setState(427);
			match(T__5);
			setState(428);
			((DecParContext)_localctx).u = expr(0);
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

	public static class SubStatementContext extends ParserRuleContext {
		public SubStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subStatement; }
	 
		public SubStatementContext() { }
		public void copyFrom(SubStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalSubStatementContext extends SubStatementContext {
		public InstructionContext instruction;
		public List<InstructionContext> e = new ArrayList<InstructionContext>();
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public NormalSubStatementContext(SubStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNormalSubStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubStatementContext subStatement() throws RecognitionException {
		SubStatementContext _localctx = new SubStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_subStatement);
		int _la;
		try {
			_localctx = new NormalSubStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__36) | (1L << T__40) | (1L << T__43) | (1L << T__47) | (1L << T__50) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__56) | (1L << T__57) | (1L << IDEN))) != 0)) {
				{
				{
				setState(430);
				((NormalSubStatementContext)_localctx).instruction = instruction();
				((NormalSubStatementContext)_localctx).e.add(((NormalSubStatementContext)_localctx).instruction);
				}
				}
				setState(435);
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

	public static class SubroutineCallContext extends ParserRuleContext {
		public SubroutineCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineCall; }
	 
		public SubroutineCallContext() { }
		public void copyFrom(SubroutineCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubCallWithContext extends SubroutineCallContext {
		public Token t;
		public Token y;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubCallWithContext(SubroutineCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSubCallWith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubCallWithoutContext extends SubroutineCallContext {
		public Token t;
		public Token y;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public SubCallWithoutContext(SubroutineCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSubCallWithout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineCallContext subroutineCall() throws RecognitionException {
		SubroutineCallContext _localctx = new SubroutineCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_subroutineCall);
		int _la;
		try {
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new SubCallWithContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				((SubCallWithContext)_localctx).t = match(T__50);
				setState(437);
				((SubCallWithContext)_localctx).y = match(IDEN);
				setState(438);
				match(T__29);
				setState(439);
				((SubCallWithContext)_localctx).expr = expr(0);
				((SubCallWithContext)_localctx).p.add(((SubCallWithContext)_localctx).expr);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(440);
					match(T__7);
					setState(441);
					((SubCallWithContext)_localctx).expr = expr(0);
					((SubCallWithContext)_localctx).e.add(((SubCallWithContext)_localctx).expr);
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(447);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new SubCallWithoutContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				((SubCallWithoutContext)_localctx).t = match(T__50);
				setState(450);
				((SubCallWithoutContext)_localctx).y = match(IDEN);
				setState(451);
				match(T__29);
				setState(452);
				match(T__30);
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

	public static class ArrayDeclarationContext extends ParserRuleContext {
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
	 
		public ArrayDeclarationContext() { }
		public void copyFrom(ArrayDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SecondArraySingularContext extends ArrayDeclarationContext {
		public Token t;
		public ExprContext id;
		public ExprContext left;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SecondArraySingularContext(ArrayDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSecondArraySingular(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FirstArraySingularContext extends ArrayDeclarationContext {
		public Token t;
		public ExprContext left;
		public ExprContext id;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FirstArraySingularContext(ArrayDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFirstArraySingular(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayDeclaration);
		int _la;
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new FirstArraySingularContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				((FirstArraySingularContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((FirstArraySingularContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(456);
				match(T__7);
				setState(457);
				match(T__51);
				setState(458);
				match(T__29);
				setState(459);
				((FirstArraySingularContext)_localctx).left = expr(0);
				setState(460);
				match(T__30);
				setState(461);
				match(T__5);
				setState(462);
				match(T__5);
				setState(463);
				((FirstArraySingularContext)_localctx).id = expr(0);
				}
				break;
			case 2:
				_localctx = new SecondArraySingularContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				((SecondArraySingularContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((SecondArraySingularContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(466);
				match(T__5);
				setState(467);
				match(T__5);
				setState(468);
				((SecondArraySingularContext)_localctx).id = expr(0);
				setState(469);
				match(T__29);
				setState(470);
				((SecondArraySingularContext)_localctx).left = expr(0);
				setState(471);
				match(T__30);
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

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainProgramContext extends ProgramContext {
		public Token y;
		public Token u1;
		public Token f;
		public ProgramStatementContext programStatement() {
			return getRuleContext(ProgramStatementContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GrammarParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GrammarParser.IDEN, i);
		}
		public MainProgramContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMainProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_program);
		try {
			_localctx = new MainProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			((MainProgramContext)_localctx).y = match(T__52);
			setState(476);
			((MainProgramContext)_localctx).u1 = match(IDEN);
			setState(477);
			match(T__45);
			setState(478);
			match(T__46);
			setState(479);
			programStatement();
			setState(480);
			match(T__42);
			setState(481);
			match(T__52);
			setState(482);
			((MainProgramContext)_localctx).f = match(IDEN);
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

	public static class OneDimArrayAsigContext extends ParserRuleContext {
		public OneDimArrayAsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneDimArrayAsig; }
	 
		public OneDimArrayAsigContext() { }
		public void copyFrom(OneDimArrayAsigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OdaContext extends OneDimArrayAsigContext {
		public Token o;
		public ExprContext e;
		public ExprContext f;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OdaContext(OneDimArrayAsigContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneDimArrayAsigContext oneDimArrayAsig() throws RecognitionException {
		OneDimArrayAsigContext _localctx = new OneDimArrayAsigContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_oneDimArrayAsig);
		try {
			_localctx = new OdaContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			((OdaContext)_localctx).o = match(IDEN);
			setState(485);
			match(T__33);
			setState(486);
			((OdaContext)_localctx).e = expr(0);
			setState(487);
			match(T__34);
			setState(488);
			match(T__6);
			setState(489);
			((OdaContext)_localctx).f = expr(0);
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

	public static class TwoDimArrayAsigContext extends ParserRuleContext {
		public TwoDimArrayAsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_twoDimArrayAsig; }
	 
		public TwoDimArrayAsigContext() { }
		public void copyFrom(TwoDimArrayAsigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TdaContext extends TwoDimArrayAsigContext {
		public Token o;
		public ExprContext a;
		public ExprContext b;
		public ExprContext f;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TdaContext(TwoDimArrayAsigContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TwoDimArrayAsigContext twoDimArrayAsig() throws RecognitionException {
		TwoDimArrayAsigContext _localctx = new TwoDimArrayAsigContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_twoDimArrayAsig);
		try {
			_localctx = new TdaContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			((TdaContext)_localctx).o = match(IDEN);
			setState(492);
			match(T__33);
			setState(493);
			((TdaContext)_localctx).a = expr(0);
			setState(494);
			match(T__7);
			setState(495);
			((TdaContext)_localctx).b = expr(0);
			setState(496);
			match(T__34);
			setState(497);
			match(T__6);
			setState(498);
			((TdaContext)_localctx).f = expr(0);
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

	public static class OneArrayListAsigContext extends ParserRuleContext {
		public OneArrayListAsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneArrayListAsig; }
	 
		public OneArrayListAsigContext() { }
		public void copyFrom(OneArrayListAsigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListAsigOneArrayContext extends OneArrayListAsigContext {
		public Token o;
		public ExprContext expr;
		public List<ExprContext> p = new ArrayList<ExprContext>();
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListAsigOneArrayContext(OneArrayListAsigContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitListAsigOneArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneArrayListAsigContext oneArrayListAsig() throws RecognitionException {
		OneArrayListAsigContext _localctx = new OneArrayListAsigContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_oneArrayListAsig);
		int _la;
		try {
			_localctx = new ListAsigOneArrayContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			((ListAsigOneArrayContext)_localctx).o = match(IDEN);
			setState(501);
			match(T__6);
			setState(502);
			match(T__29);
			setState(503);
			match(T__12);
			setState(504);
			((ListAsigOneArrayContext)_localctx).expr = expr(0);
			((ListAsigOneArrayContext)_localctx).p.add(((ListAsigOneArrayContext)_localctx).expr);
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(505);
				match(T__7);
				setState(506);
				((ListAsigOneArrayContext)_localctx).expr = expr(0);
				((ListAsigOneArrayContext)_localctx).e.add(((ListAsigOneArrayContext)_localctx).expr);
				}
				}
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(512);
			match(T__12);
			setState(513);
			match(T__30);
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

	public static class ArrayDeclaration2Context extends ParserRuleContext {
		public ArrayDeclaration2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration2; }
	 
		public ArrayDeclaration2Context() { }
		public void copyFrom(ArrayDeclaration2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FirstArrayPluralContext extends ArrayDeclaration2Context {
		public Token t;
		public ExprContext left;
		public ExprContext right;
		public ExprContext id;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FirstArrayPluralContext(ArrayDeclaration2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFirstArrayPlural(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SecondArrayPluralContext extends ArrayDeclaration2Context {
		public Token t;
		public ExprContext id;
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SecondArrayPluralContext(ArrayDeclaration2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSecondArrayPlural(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclaration2Context arrayDeclaration2() throws RecognitionException {
		ArrayDeclaration2Context _localctx = new ArrayDeclaration2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayDeclaration2);
		int _la;
		try {
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new FirstArrayPluralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				((FirstArrayPluralContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((FirstArrayPluralContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(516);
				match(T__7);
				setState(517);
				match(T__51);
				setState(518);
				match(T__29);
				setState(519);
				((FirstArrayPluralContext)_localctx).left = expr(0);
				setState(520);
				match(T__7);
				setState(521);
				((FirstArrayPluralContext)_localctx).right = expr(0);
				setState(522);
				match(T__30);
				setState(523);
				match(T__5);
				setState(524);
				match(T__5);
				setState(525);
				((FirstArrayPluralContext)_localctx).id = expr(0);
				}
				break;
			case 2:
				_localctx = new SecondArrayPluralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(527);
				((SecondArrayPluralContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((SecondArrayPluralContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(528);
				match(T__5);
				setState(529);
				match(T__5);
				setState(530);
				((SecondArrayPluralContext)_localctx).id = expr(0);
				setState(531);
				match(T__29);
				setState(532);
				((SecondArrayPluralContext)_localctx).left = expr(0);
				setState(533);
				match(T__7);
				setState(534);
				((SecondArrayPluralContext)_localctx).right = expr(0);
				setState(535);
				match(T__30);
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

	public static class Continue_Context extends ParserRuleContext {
		public Token i;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public Continue_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitContinue_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_Context continue_() throws RecognitionException {
		Continue_Context _localctx = new Continue_Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_continue_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			((Continue_Context)_localctx).i = match(T__53);
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(540);
				match(IDEN);
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

	public static class Break_Context extends ParserRuleContext {
		public Token i;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public Break_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBreak_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_Context break_() throws RecognitionException {
		Break_Context _localctx = new Break_Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_break_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			((Break_Context)_localctx).i = match(T__54);
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(544);
				match(IDEN);
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

	public static class DynamicArrayDecContext extends ParserRuleContext {
		public DynamicArrayDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicArrayDec; }
	 
		public DynamicArrayDecContext() { }
		public void copyFrom(DynamicArrayDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TwoDynamicContext extends DynamicArrayDecContext {
		public Token t;
		public ExprContext id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TwoDynamicContext(DynamicArrayDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTwoDynamic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneDynamicContext extends DynamicArrayDecContext {
		public Token t;
		public ExprContext id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OneDynamicContext(DynamicArrayDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOneDynamic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DynamicArrayDecContext dynamicArrayDec() throws RecognitionException {
		DynamicArrayDecContext _localctx = new DynamicArrayDecContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dynamicArrayDec);
		int _la;
		try {
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new OneDynamicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				((OneDynamicContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((OneDynamicContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(548);
				match(T__7);
				setState(549);
				match(T__55);
				setState(550);
				match(T__5);
				setState(551);
				match(T__5);
				setState(552);
				((OneDynamicContext)_localctx).id = expr(0);
				setState(553);
				match(T__29);
				setState(554);
				match(T__5);
				setState(555);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new TwoDynamicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				((TwoDynamicContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0)) ) {
					((TwoDynamicContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(558);
				match(T__7);
				setState(559);
				match(T__55);
				setState(560);
				match(T__5);
				setState(561);
				match(T__5);
				setState(562);
				((TwoDynamicContext)_localctx).id = expr(0);
				setState(563);
				match(T__29);
				setState(564);
				match(T__5);
				setState(565);
				match(T__7);
				setState(566);
				match(T__5);
				setState(567);
				match(T__30);
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

	public static class AllocateContext extends ParserRuleContext {
		public AllocateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocate; }
	 
		public AllocateContext() { }
		public void copyFrom(AllocateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OneAllocateContext extends AllocateContext {
		public Token a;
		public Token i;
		public ExprContext g;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OneAllocateContext(AllocateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOneAllocate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TwoAllocateContext extends AllocateContext {
		public Token a;
		public Token i;
		public ExprContext g1;
		public ExprContext g2;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TwoAllocateContext(AllocateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTwoAllocate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllocateContext allocate() throws RecognitionException {
		AllocateContext _localctx = new AllocateContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_allocate);
		try {
			setState(589);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new OneAllocateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				((OneAllocateContext)_localctx).a = match(T__56);
				setState(572);
				match(T__29);
				setState(573);
				((OneAllocateContext)_localctx).i = match(IDEN);
				setState(574);
				match(T__29);
				setState(575);
				((OneAllocateContext)_localctx).g = expr(0);
				setState(576);
				match(T__30);
				setState(577);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new TwoAllocateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				((TwoAllocateContext)_localctx).a = match(T__56);
				setState(580);
				match(T__29);
				setState(581);
				((TwoAllocateContext)_localctx).i = match(IDEN);
				setState(582);
				match(T__29);
				setState(583);
				((TwoAllocateContext)_localctx).g1 = expr(0);
				setState(584);
				match(T__7);
				setState(585);
				((TwoAllocateContext)_localctx).g2 = expr(0);
				setState(586);
				match(T__30);
				setState(587);
				match(T__30);
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

	public static class DeallocateContext extends ParserRuleContext {
		public Token o;
		public Token i;
		public TerminalNode IDEN() { return getToken(GrammarParser.IDEN, 0); }
		public DeallocateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deallocate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeallocate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeallocateContext deallocate() throws RecognitionException {
		DeallocateContext _localctx = new DeallocateContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_deallocate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			((DeallocateContext)_localctx).o = match(T__57);
			setState(592);
			match(T__29);
			setState(593);
			((DeallocateContext)_localctx).i = match(IDEN);
			setState(594);
			match(T__30);
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 23);
		case 1:
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 14);
		case 10:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001A\u0255\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0005\u0001G\b\u0001\n\u0001\f\u0001J\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002a\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003s\b\u0003\n\u0003\f\u0003v\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003~\b\u0003\n\u0003\f\u0003\u0081\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u0085\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u0091\b\u0005\n\u0005\f\u0005\u0094\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00b7\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00da\b\u0006\n\u0006\f\u0006\u00dd\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00e6\b\u0007\u0001\u0007\u0003\u0007\u00e9\b\u0007"+
		"\u0001\b\u0005\b\u00ec\b\b\n\b\f\b\u00ef\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00f5\b\t\u0001\n\u0003\n\u00f8\b\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0005\u000b"+
		"\u0104\b\u000b\n\u000b\f\u000b\u0107\t\u000b\u0001\f\u0003\f\u010a\b\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0120\b\f\u0001\r\u0005\r\u0123\b\r\n\r\f\r"+
		"\u0126\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0133\b\u000e\n\u000e\f\u000e\u0136\t\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0143\b\u000e\n"+
		"\u000e\f\u000e\u0146\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0150"+
		"\b\u000e\n\u000e\f\u000e\u0153\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u015a\b\u000e\u0001\u000f\u0005\u000f"+
		"\u015d\b\u000f\n\u000f\f\u000f\u0160\t\u000f\u0001\u0010\u0005\u0010\u0163"+
		"\b\u0010\n\u0010\f\u0010\u0166\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u016d\b\u0011\n\u0011\f\u0011\u0170"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0177\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0180\b\u0012\n\u0012\f\u0012"+
		"\u0183\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0190\b\u0012\n\u0012\f\u0012\u0193\t\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0199\b\u0012\n\u0012\f\u0012"+
		"\u019c\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u01a3\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0005\u0014\u01b0\b\u0014\n\u0014\f\u0014\u01b3\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u01bb\b\u0015\n\u0015\f\u0015\u01be\t\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01c6\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u01da\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01fc\b\u001a"+
		"\n\u001a\f\u001a\u01ff\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u021a\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u021e\b\u001c\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u0222\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u023a\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u024e\b\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0000\u0001\f!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000\u000b"+
		"\u0001\u0000\u0001\u0005\u0001\u0000 !\u0002\u0000\n\n\r\r\u0002\u0000"+
		"\u000b\u000b\u000e\u000e\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012"+
		"\u0001\u0000\u0013\u0014\u0001\u0000\u0015\u0016\u0001\u0000\u0017\u0018"+
		"\u0001\u0000\u0019\u001a\u0002\u0000\u0001\u0002\u0005\u0005\u0284\u0000"+
		"B\u0001\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004`\u0001"+
		"\u0000\u0000\u0000\u0006\u0084\u0001\u0000\u0000\u0000\b\u0086\u0001\u0000"+
		"\u0000\u0000\n\u008a\u0001\u0000\u0000\u0000\f\u00b6\u0001\u0000\u0000"+
		"\u0000\u000e\u00de\u0001\u0000\u0000\u0000\u0010\u00ed\u0001\u0000\u0000"+
		"\u0000\u0012\u00f4\u0001\u0000\u0000\u0000\u0014\u00f7\u0001\u0000\u0000"+
		"\u0000\u0016\u0105\u0001\u0000\u0000\u0000\u0018\u011f\u0001\u0000\u0000"+
		"\u0000\u001a\u0124\u0001\u0000\u0000\u0000\u001c\u0159\u0001\u0000\u0000"+
		"\u0000\u001e\u015e\u0001\u0000\u0000\u0000 \u0164\u0001\u0000\u0000\u0000"+
		"\"\u0176\u0001\u0000\u0000\u0000$\u01a2\u0001\u0000\u0000\u0000&\u01a4"+
		"\u0001\u0000\u0000\u0000(\u01b1\u0001\u0000\u0000\u0000*\u01c5\u0001\u0000"+
		"\u0000\u0000,\u01d9\u0001\u0000\u0000\u0000.\u01db\u0001\u0000\u0000\u0000"+
		"0\u01e4\u0001\u0000\u0000\u00002\u01eb\u0001\u0000\u0000\u00004\u01f4"+
		"\u0001\u0000\u0000\u00006\u0219\u0001\u0000\u0000\u00008\u021b\u0001\u0000"+
		"\u0000\u0000:\u021f\u0001\u0000\u0000\u0000<\u0239\u0001\u0000\u0000\u0000"+
		">\u024d\u0001\u0000\u0000\u0000@\u024f\u0001\u0000\u0000\u0000BC\u0003"+
		"\u0002\u0001\u0000CD\u0005\u0000\u0000\u0001D\u0001\u0001\u0000\u0000"+
		"\u0000EG\u0003\u0004\u0002\u0000FE\u0001\u0000\u0000\u0000GJ\u0001\u0000"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\u0003"+
		"\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000Ka\u0003\u0006\u0003"+
		"\u0000La\u0003\n\u0005\u0000Ma\u0003\u000e\u0007\u0000Na\u0003\u0014\n"+
		"\u0000Oa\u0003\u0018\f\u0000Pa\u0003\b\u0004\u0000Qa\u0003\u001c\u000e"+
		"\u0000Ra\u0003\"\u0011\u0000Sa\u0003$\u0012\u0000Ta\u0003*\u0015\u0000"+
		"Ua\u0003,\u0016\u0000Va\u00036\u001b\u0000Wa\u0003.\u0017\u0000Xa\u0003"+
		"0\u0018\u0000Ya\u00034\u001a\u0000Za\u00032\u0019\u0000[a\u00038\u001c"+
		"\u0000\\a\u0003:\u001d\u0000]a\u0003<\u001e\u0000^a\u0003>\u001f\u0000"+
		"_a\u0003@ \u0000`K\u0001\u0000\u0000\u0000`L\u0001\u0000\u0000\u0000`"+
		"M\u0001\u0000\u0000\u0000`N\u0001\u0000\u0000\u0000`O\u0001\u0000\u0000"+
		"\u0000`P\u0001\u0000\u0000\u0000`Q\u0001\u0000\u0000\u0000`R\u0001\u0000"+
		"\u0000\u0000`S\u0001\u0000\u0000\u0000`T\u0001\u0000\u0000\u0000`U\u0001"+
		"\u0000\u0000\u0000`V\u0001\u0000\u0000\u0000`W\u0001\u0000\u0000\u0000"+
		"`X\u0001\u0000\u0000\u0000`Y\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000"+
		"\u0000`[\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000`]\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000a\u0005"+
		"\u0001\u0000\u0000\u0000bc\u0007\u0000\u0000\u0000cd\u0005\u0006\u0000"+
		"\u0000de\u0005\u0006\u0000\u0000e\u0085\u0005=\u0000\u0000fg\u0007\u0000"+
		"\u0000\u0000gh\u0005\u0006\u0000\u0000hi\u0005\u0006\u0000\u0000ij\u0005"+
		"=\u0000\u0000jk\u0005\u0007\u0000\u0000k\u0085\u0003\f\u0006\u0000lm\u0007"+
		"\u0000\u0000\u0000mn\u0005\u0006\u0000\u0000no\u0005\u0006\u0000\u0000"+
		"ot\u0005=\u0000\u0000pq\u0005\b\u0000\u0000qs\u0005=\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u0085\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wx\u0007\u0000\u0000\u0000xy\u0005\u0006\u0000\u0000yz\u0005"+
		"\u0006\u0000\u0000z\u007f\u0005=\u0000\u0000{|\u0005\b\u0000\u0000|~\u0005"+
		"=\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0007\u0000\u0000\u0083\u0085\u0003\f\u0006\u0000\u0084b"+
		"\u0001\u0000\u0000\u0000\u0084f\u0001\u0000\u0000\u0000\u0084l\u0001\u0000"+
		"\u0000\u0000\u0084w\u0001\u0000\u0000\u0000\u0085\u0007\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005=\u0000\u0000\u0087\u0088\u0005\u0007\u0000\u0000"+
		"\u0088\u0089\u0003\f\u0006\u0000\u0089\t\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005\t\u0000\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c\u008d"+
		"\u0005\b\u0000\u0000\u008d\u0092\u0003\f\u0006\u0000\u008e\u008f\u0005"+
		"\b\u0000\u0000\u008f\u0091\u0003\f\u0006\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u000b\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u0006"+
		"\uffff\uffff\u0000\u0096\u0097\u0005\u000b\u0000\u0000\u0097\u00b7\u0003"+
		"\f\u0006\u0018\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u00b7\u0003\f"+
		"\u0006\f\u009a\u009b\u0005\u001e\u0000\u0000\u009b\u009c\u0003\f\u0006"+
		"\u0000\u009c\u009d\u0005\u001f\u0000\u0000\u009d\u00b7\u0001\u0000\u0000"+
		"\u0000\u009e\u00b7\u0005;\u0000\u0000\u009f\u00b7\u0005<\u0000\u0000\u00a0"+
		"\u00b7\u0005?\u0000\u0000\u00a1\u00b7\u0005@\u0000\u0000\u00a2\u00b7\u0007"+
		"\u0001\u0000\u0000\u00a3\u00b7\u0005=\u0000\u0000\u00a4\u00a5\u0005=\u0000"+
		"\u0000\u00a5\u00a6\u0005\"\u0000\u0000\u00a6\u00a7\u0003\f\u0006\u0000"+
		"\u00a7\u00a8\u0005#\u0000\u0000\u00a8\u00b7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005=\u0000\u0000\u00aa\u00ab\u0005\"\u0000\u0000\u00ab\u00ac"+
		"\u0003\f\u0006\u0000\u00ac\u00ad\u0005\b\u0000\u0000\u00ad\u00ae\u0003"+
		"\f\u0006\u0000\u00ae\u00af\u0005#\u0000\u0000\u00af\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005$\u0000\u0000\u00b1\u00b2\u0005\u001e\u0000"+
		"\u0000\u00b2\u00b3\u0003\f\u0006\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000"+
		"\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003\"\u0011\u0000\u00b6"+
		"\u0095\u0001\u0000\u0000\u0000\u00b6\u0098\u0001\u0000\u0000\u0000\u00b6"+
		"\u009a\u0001\u0000\u0000\u0000\u00b6\u009e\u0001\u0000\u0000\u0000\u00b6"+
		"\u009f\u0001\u0000\u0000\u0000\u00b6\u00a0\u0001\u0000\u0000\u0000\u00b6"+
		"\u00a1\u0001\u0000\u0000\u0000\u00b6\u00a2\u0001\u0000\u0000\u0000\u00b6"+
		"\u00a3\u0001\u0000\u0000\u0000\u00b6\u00a4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00a9\u0001\u0000\u0000\u0000\u00b6\u00b0\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00db\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\n\u0017\u0000\u0000\u00b9\u00ba\u0005\f\u0000\u0000\u00ba\u00da"+
		"\u0003\f\u0006\u0018\u00bb\u00bc\n\u0016\u0000\u0000\u00bc\u00bd\u0007"+
		"\u0002\u0000\u0000\u00bd\u00da\u0003\f\u0006\u0017\u00be\u00bf\n\u0015"+
		"\u0000\u0000\u00bf\u00c0\u0007\u0003\u0000\u0000\u00c0\u00da\u0003\f\u0006"+
		"\u0016\u00c1\u00c2\n\u0014\u0000\u0000\u00c2\u00c3\u0007\u0004\u0000\u0000"+
		"\u00c3\u00da\u0003\f\u0006\u0015\u00c4\u00c5\n\u0013\u0000\u0000\u00c5"+
		"\u00c6\u0007\u0005\u0000\u0000\u00c6\u00da\u0003\f\u0006\u0014\u00c7\u00c8"+
		"\n\u0012\u0000\u0000\u00c8\u00c9\u0007\u0006\u0000\u0000\u00c9\u00da\u0003"+
		"\f\u0006\u0013\u00ca\u00cb\n\u0011\u0000\u0000\u00cb\u00cc\u0007\u0007"+
		"\u0000\u0000\u00cc\u00da\u0003\f\u0006\u0012\u00cd\u00ce\n\u0010\u0000"+
		"\u0000\u00ce\u00cf\u0007\b\u0000\u0000\u00cf\u00da\u0003\f\u0006\u0011"+
		"\u00d0\u00d1\n\u000f\u0000\u0000\u00d1\u00d2\u0007\t\u0000\u0000\u00d2"+
		"\u00da\u0003\f\u0006\u0010\u00d3\u00d4\n\u000e\u0000\u0000\u00d4\u00d5"+
		"\u0005\u001b\u0000\u0000\u00d5\u00da\u0003\f\u0006\u000f\u00d6\u00d7\n"+
		"\r\u0000\u0000\u00d7\u00d8\u0005\u001c\u0000\u0000\u00d8\u00da\u0003\f"+
		"\u0006\u000e\u00d9\u00b8\u0001\u0000\u0000\u0000\u00d9\u00bb\u0001\u0000"+
		"\u0000\u0000\u00d9\u00be\u0001\u0000\u0000\u0000\u00d9\u00c1\u0001\u0000"+
		"\u0000\u0000\u00d9\u00c4\u0001\u0000\u0000\u0000\u00d9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00ca\u0001\u0000\u0000\u0000\u00d9\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d0\u0001\u0000\u0000\u0000\u00d9\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d6\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000"+
		"\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc\r\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005%\u0000\u0000\u00df\u00e0\u0005\u001e\u0000\u0000"+
		"\u00e0\u00e1\u0003\f\u0006\u0000\u00e1\u00e2\u0005\u001f\u0000\u0000\u00e2"+
		"\u00e3\u0005&\u0000\u0000\u00e3\u00e5\u0003\u0010\b\u0000\u00e4\u00e6"+
		"\u0003\u0012\t\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e9\u0005"+
		"\'\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u000f\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003\u0004"+
		"\u0002\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ee\u0011\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0005(\u0000\u0000\u00f1\u00f5\u0003\u0010\b"+
		"\u0000\u00f2\u00f3\u0005(\u0000\u0000\u00f3\u00f5\u0003\u000e\u0007\u0000"+
		"\u00f4\u00f0\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f5\u0013\u0001\u0000\u0000\u0000\u00f6\u00f8\u0005=\u0000\u0000\u00f7"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005)\u0000\u0000\u00fa\u00fb"+
		"\u0005*\u0000\u0000\u00fb\u00fc\u0005\u001e\u0000\u0000\u00fc\u00fd\u0003"+
		"\f\u0006\u0000\u00fd\u00fe\u0005\u001f\u0000\u0000\u00fe\u00ff\u0003\u0016"+
		"\u000b\u0000\u00ff\u0100\u0005+\u0000\u0000\u0100\u0101\u0005)\u0000\u0000"+
		"\u0101\u0015\u0001\u0000\u0000\u0000\u0102\u0104\u0003\u0004\u0002\u0000"+
		"\u0103\u0102\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000"+
		"\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000"+
		"\u0106\u0017\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000"+
		"\u0108\u010a\u0005=\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0005)\u0000\u0000\u010c\u010d\u0003\f\u0006\u0000\u010d\u010e"+
		"\u0005\b\u0000\u0000\u010e\u010f\u0003\f\u0006\u0000\u010f\u0110\u0005"+
		"\b\u0000\u0000\u0110\u0111\u0003\f\u0006\u0000\u0111\u0112\u0003\u001a"+
		"\r\u0000\u0112\u0113\u0005+\u0000\u0000\u0113\u0114\u0005)\u0000\u0000"+
		"\u0114\u0120\u0001\u0000\u0000\u0000\u0115\u0116\u0005)\u0000\u0000\u0116"+
		"\u0117\u0003\b\u0004\u0000\u0117\u0118\u0005\b\u0000\u0000\u0118\u0119"+
		"\u0003\f\u0006\u0000\u0119\u011a\u0005\b\u0000\u0000\u011a\u011b\u0003"+
		"\f\u0006\u0000\u011b\u011c\u0003\u001a\r\u0000\u011c\u011d\u0005+\u0000"+
		"\u0000\u011d\u011e\u0005)\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000"+
		"\u011f\u0109\u0001\u0000\u0000\u0000\u011f\u0115\u0001\u0000\u0000\u0000"+
		"\u0120\u0019\u0001\u0000\u0000\u0000\u0121\u0123\u0003\u0004\u0002\u0000"+
		"\u0122\u0121\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000"+
		"\u0125\u001b\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0005,\u0000\u0000\u0128\u0129\u0005=\u0000\u0000\u0129\u012a"+
		"\u0005\u001e\u0000\u0000\u012a\u012b\u0005\u001f\u0000\u0000\u012b\u012c"+
		"\u0005-\u0000\u0000\u012c\u012d\u0005\u001e\u0000\u0000\u012d\u012e\u0005"+
		"=\u0000\u0000\u012e\u012f\u0005\u001f\u0000\u0000\u012f\u0130\u0005.\u0000"+
		"\u0000\u0130\u0134\u0005/\u0000\u0000\u0131\u0133\u0003&\u0013\u0000\u0132"+
		"\u0131\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0137\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137"+
		"\u0138\u0003\u001e\u000f\u0000\u0138\u0139\u0005+\u0000\u0000\u0139\u013a"+
		"\u0005,\u0000\u0000\u013a\u013b\u0005=\u0000\u0000\u013b\u015a\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0005,\u0000\u0000\u013d\u013e\u0005=\u0000\u0000"+
		"\u013e\u013f\u0005\u001e\u0000\u0000\u013f\u0144\u0003\f\u0006\u0000\u0140"+
		"\u0141\u0005\b\u0000\u0000\u0141\u0143\u0003\f\u0006\u0000\u0142\u0140"+
		"\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000\u0144\u0142"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0147"+
		"\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0005\u001f\u0000\u0000\u0148\u0149\u0005-\u0000\u0000\u0149\u014a\u0005"+
		"\u001e\u0000\u0000\u014a\u014b\u0005=\u0000\u0000\u014b\u014c\u0005\u001f"+
		"\u0000\u0000\u014c\u014d\u0005.\u0000\u0000\u014d\u0151\u0005/\u0000\u0000"+
		"\u014e\u0150\u0003&\u0013\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u0150"+
		"\u0153\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0001\u0000\u0000\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153"+
		"\u0151\u0001\u0000\u0000\u0000\u0154\u0155\u0003\u001e\u000f\u0000\u0155"+
		"\u0156\u0005+\u0000\u0000\u0156\u0157\u0005,\u0000\u0000\u0157\u0158\u0005"+
		"=\u0000\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159\u0127\u0001\u0000"+
		"\u0000\u0000\u0159\u013c\u0001\u0000\u0000\u0000\u015a\u001d\u0001\u0000"+
		"\u0000\u0000\u015b\u015d\u0003\u0004\u0002\u0000\u015c\u015b\u0001\u0000"+
		"\u0000\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000"+
		"\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u001f\u0001\u0000"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0163\u0003\u0004"+
		"\u0002\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0163\u0166\u0001\u0000"+
		"\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000"+
		"\u0000\u0000\u0165!\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0005=\u0000\u0000\u0168\u0169\u0005\u001e\u0000\u0000"+
		"\u0169\u016e\u0003\f\u0006\u0000\u016a\u016b\u0005\b\u0000\u0000\u016b"+
		"\u016d\u0003\f\u0006\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170"+
		"\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f"+
		"\u0001\u0000\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016e"+
		"\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u001f\u0000\u0000\u0172\u0177"+
		"\u0001\u0000\u0000\u0000\u0173\u0174\u0005=\u0000\u0000\u0174\u0175\u0005"+
		"\u001e\u0000\u0000\u0175\u0177\u0005\u001f\u0000\u0000\u0176\u0167\u0001"+
		"\u0000\u0000\u0000\u0176\u0173\u0001\u0000\u0000\u0000\u0177#\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u00050\u0000\u0000\u0179\u017a\u0005=\u0000\u0000"+
		"\u017a\u017b\u0005\u001e\u0000\u0000\u017b\u017c\u0005\u001f\u0000\u0000"+
		"\u017c\u017d\u0005.\u0000\u0000\u017d\u0181\u0005/\u0000\u0000\u017e\u0180"+
		"\u0003&\u0013\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180\u0183\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0003(\u0014\u0000\u0185\u0186\u0005+\u0000"+
		"\u0000\u0186\u0187\u00050\u0000\u0000\u0187\u0188\u0005=\u0000\u0000\u0188"+
		"\u01a3\u0001\u0000\u0000\u0000\u0189\u018a\u00050\u0000\u0000\u018a\u018b"+
		"\u0005=\u0000\u0000\u018b\u018c\u0005\u001e\u0000\u0000\u018c\u0191\u0003"+
		"\f\u0006\u0000\u018d\u018e\u0005\b\u0000\u0000\u018e\u0190\u0003\f\u0006"+
		"\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0193\u0001\u0000\u0000"+
		"\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000"+
		"\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000"+
		"\u0000\u0194\u0195\u0005\u001f\u0000\u0000\u0195\u0196\u0005.\u0000\u0000"+
		"\u0196\u019a\u0005/\u0000\u0000\u0197\u0199\u0003&\u0013\u0000\u0198\u0197"+
		"\u0001\u0000\u0000\u0000\u0199\u019c\u0001\u0000\u0000\u0000\u019a\u0198"+
		"\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u019d"+
		"\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\u0003(\u0014\u0000\u019e\u019f\u0005+\u0000\u0000\u019f\u01a0\u00050"+
		"\u0000\u0000\u01a0\u01a1\u0005=\u0000\u0000\u01a1\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a2\u0178\u0001\u0000\u0000\u0000\u01a2\u0189\u0001\u0000\u0000"+
		"\u0000\u01a3%\u0001\u0000\u0000\u0000\u01a4\u01a5\u0007\u0000\u0000\u0000"+
		"\u01a5\u01a6\u0005\b\u0000\u0000\u01a6\u01a7\u00051\u0000\u0000\u01a7"+
		"\u01a8\u0005\u001e\u0000\u0000\u01a8\u01a9\u00052\u0000\u0000\u01a9\u01aa"+
		"\u0005\u001f\u0000\u0000\u01aa\u01ab\u0005\u0006\u0000\u0000\u01ab\u01ac"+
		"\u0005\u0006\u0000\u0000\u01ac\u01ad\u0003\f\u0006\u0000\u01ad\'\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b0\u0003\u0004\u0002\u0000\u01af\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2)\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b5\u00053\u0000"+
		"\u0000\u01b5\u01b6\u0005=\u0000\u0000\u01b6\u01b7\u0005\u001e\u0000\u0000"+
		"\u01b7\u01bc\u0003\f\u0006\u0000\u01b8\u01b9\u0005\b\u0000\u0000\u01b9"+
		"\u01bb\u0003\f\u0006\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01be"+
		"\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bd"+
		"\u0001\u0000\u0000\u0000\u01bd\u01bf\u0001\u0000\u0000\u0000\u01be\u01bc"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u001f\u0000\u0000\u01c0\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c1\u01c2\u00053\u0000\u0000\u01c2\u01c3\u0005"+
		"=\u0000\u0000\u01c3\u01c4\u0005\u001e\u0000\u0000\u01c4\u01c6\u0005\u001f"+
		"\u0000\u0000\u01c5\u01b4\u0001\u0000\u0000\u0000\u01c5\u01c1\u0001\u0000"+
		"\u0000\u0000\u01c6+\u0001\u0000\u0000\u0000\u01c7\u01c8\u0007\n\u0000"+
		"\u0000\u01c8\u01c9\u0005\b\u0000\u0000\u01c9\u01ca\u00054\u0000\u0000"+
		"\u01ca\u01cb\u0005\u001e\u0000\u0000\u01cb\u01cc\u0003\f\u0006\u0000\u01cc"+
		"\u01cd\u0005\u001f\u0000\u0000\u01cd\u01ce\u0005\u0006\u0000\u0000\u01ce"+
		"\u01cf\u0005\u0006\u0000\u0000\u01cf\u01d0\u0003\f\u0006\u0000\u01d0\u01da"+
		"\u0001\u0000\u0000\u0000\u01d1\u01d2\u0007\n\u0000\u0000\u01d2\u01d3\u0005"+
		"\u0006\u0000\u0000\u01d3\u01d4\u0005\u0006\u0000\u0000\u01d4\u01d5\u0003"+
		"\f\u0006\u0000\u01d5\u01d6\u0005\u001e\u0000\u0000\u01d6\u01d7\u0003\f"+
		"\u0006\u0000\u01d7\u01d8\u0005\u001f\u0000\u0000\u01d8\u01da\u0001\u0000"+
		"\u0000\u0000\u01d9\u01c7\u0001\u0000\u0000\u0000\u01d9\u01d1\u0001\u0000"+
		"\u0000\u0000\u01da-\u0001\u0000\u0000\u0000\u01db\u01dc\u00055\u0000\u0000"+
		"\u01dc\u01dd\u0005=\u0000\u0000\u01dd\u01de\u0005.\u0000\u0000\u01de\u01df"+
		"\u0005/\u0000\u0000\u01df\u01e0\u0003 \u0010\u0000\u01e0\u01e1\u0005+"+
		"\u0000\u0000\u01e1\u01e2\u00055\u0000\u0000\u01e2\u01e3\u0005=\u0000\u0000"+
		"\u01e3/\u0001\u0000\u0000\u0000\u01e4\u01e5\u0005=\u0000\u0000\u01e5\u01e6"+
		"\u0005\"\u0000\u0000\u01e6\u01e7\u0003\f\u0006\u0000\u01e7\u01e8\u0005"+
		"#\u0000\u0000\u01e8\u01e9\u0005\u0007\u0000\u0000\u01e9\u01ea\u0003\f"+
		"\u0006\u0000\u01ea1\u0001\u0000\u0000\u0000\u01eb\u01ec\u0005=\u0000\u0000"+
		"\u01ec\u01ed\u0005\"\u0000\u0000\u01ed\u01ee\u0003\f\u0006\u0000\u01ee"+
		"\u01ef\u0005\b\u0000\u0000\u01ef\u01f0\u0003\f\u0006\u0000\u01f0\u01f1"+
		"\u0005#\u0000\u0000\u01f1\u01f2\u0005\u0007\u0000\u0000\u01f2\u01f3\u0003"+
		"\f\u0006\u0000\u01f33\u0001\u0000\u0000\u0000\u01f4\u01f5\u0005=\u0000"+
		"\u0000\u01f5\u01f6\u0005\u0007\u0000\u0000\u01f6\u01f7\u0005\u001e\u0000"+
		"\u0000\u01f7\u01f8\u0005\r\u0000\u0000\u01f8\u01fd\u0003\f\u0006\u0000"+
		"\u01f9\u01fa\u0005\b\u0000\u0000\u01fa\u01fc\u0003\f\u0006\u0000\u01fb"+
		"\u01f9\u0001\u0000\u0000\u0000\u01fc\u01ff\u0001\u0000\u0000\u0000\u01fd"+
		"\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe"+
		"\u0200\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000\u0000\u0200"+
		"\u0201\u0005\r\u0000\u0000\u0201\u0202\u0005\u001f\u0000\u0000\u02025"+
		"\u0001\u0000\u0000\u0000\u0203\u0204\u0007\n\u0000\u0000\u0204\u0205\u0005"+
		"\b\u0000\u0000\u0205\u0206\u00054\u0000\u0000\u0206\u0207\u0005\u001e"+
		"\u0000\u0000\u0207\u0208\u0003\f\u0006\u0000\u0208\u0209\u0005\b\u0000"+
		"\u0000\u0209\u020a\u0003\f\u0006\u0000\u020a\u020b\u0005\u001f\u0000\u0000"+
		"\u020b\u020c\u0005\u0006\u0000\u0000\u020c\u020d\u0005\u0006\u0000\u0000"+
		"\u020d\u020e\u0003\f\u0006\u0000\u020e\u021a\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0007\n\u0000\u0000\u0210\u0211\u0005\u0006\u0000\u0000\u0211\u0212"+
		"\u0005\u0006\u0000\u0000\u0212\u0213\u0003\f\u0006\u0000\u0213\u0214\u0005"+
		"\u001e\u0000\u0000\u0214\u0215\u0003\f\u0006\u0000\u0215\u0216\u0005\b"+
		"\u0000\u0000\u0216\u0217\u0003\f\u0006\u0000\u0217\u0218\u0005\u001f\u0000"+
		"\u0000\u0218\u021a\u0001\u0000\u0000\u0000\u0219\u0203\u0001\u0000\u0000"+
		"\u0000\u0219\u020f\u0001\u0000\u0000\u0000\u021a7\u0001\u0000\u0000\u0000"+
		"\u021b\u021d\u00056\u0000\u0000\u021c\u021e\u0005=\u0000\u0000\u021d\u021c"+
		"\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e9\u0001"+
		"\u0000\u0000\u0000\u021f\u0221\u00057\u0000\u0000\u0220\u0222\u0005=\u0000"+
		"\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000"+
		"\u0000\u0222;\u0001\u0000\u0000\u0000\u0223\u0224\u0007\n\u0000\u0000"+
		"\u0224\u0225\u0005\b\u0000\u0000\u0225\u0226\u00058\u0000\u0000\u0226"+
		"\u0227\u0005\u0006\u0000\u0000\u0227\u0228\u0005\u0006\u0000\u0000\u0228"+
		"\u0229\u0003\f\u0006\u0000\u0229\u022a\u0005\u001e\u0000\u0000\u022a\u022b"+
		"\u0005\u0006\u0000\u0000\u022b\u022c\u0005\u001f\u0000\u0000\u022c\u023a"+
		"\u0001\u0000\u0000\u0000\u022d\u022e\u0007\n\u0000\u0000\u022e\u022f\u0005"+
		"\b\u0000\u0000\u022f\u0230\u00058\u0000\u0000\u0230\u0231\u0005\u0006"+
		"\u0000\u0000\u0231\u0232\u0005\u0006\u0000\u0000\u0232\u0233\u0003\f\u0006"+
		"\u0000\u0233\u0234\u0005\u001e\u0000\u0000\u0234\u0235\u0005\u0006\u0000"+
		"\u0000\u0235\u0236\u0005\b\u0000\u0000\u0236\u0237\u0005\u0006\u0000\u0000"+
		"\u0237\u0238\u0005\u001f\u0000\u0000\u0238\u023a\u0001\u0000\u0000\u0000"+
		"\u0239\u0223\u0001\u0000\u0000\u0000\u0239\u022d\u0001\u0000\u0000\u0000"+
		"\u023a=\u0001\u0000\u0000\u0000\u023b\u023c\u00059\u0000\u0000\u023c\u023d"+
		"\u0005\u001e\u0000\u0000\u023d\u023e\u0005=\u0000\u0000\u023e\u023f\u0005"+
		"\u001e\u0000\u0000\u023f\u0240\u0003\f\u0006\u0000\u0240\u0241\u0005\u001f"+
		"\u0000\u0000\u0241\u0242\u0005\u001f\u0000\u0000\u0242\u024e\u0001\u0000"+
		"\u0000\u0000\u0243\u0244\u00059\u0000\u0000\u0244\u0245\u0005\u001e\u0000"+
		"\u0000\u0245\u0246\u0005=\u0000\u0000\u0246\u0247\u0005\u001e\u0000\u0000"+
		"\u0247\u0248\u0003\f\u0006\u0000\u0248\u0249\u0005\b\u0000\u0000\u0249"+
		"\u024a\u0003\f\u0006\u0000\u024a\u024b\u0005\u001f\u0000\u0000\u024b\u024c"+
		"\u0005\u001f\u0000\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d\u023b"+
		"\u0001\u0000\u0000\u0000\u024d\u0243\u0001\u0000\u0000\u0000\u024e?\u0001"+
		"\u0000\u0000\u0000\u024f\u0250\u0005:\u0000\u0000\u0250\u0251\u0005\u001e"+
		"\u0000\u0000\u0251\u0252\u0005=\u0000\u0000\u0252\u0253\u0005\u001f\u0000"+
		"\u0000\u0253A\u0001\u0000\u0000\u0000(H`t\u007f\u0084\u0092\u00b6\u00d9"+
		"\u00db\u00e5\u00e8\u00ed\u00f4\u00f7\u0105\u0109\u011f\u0124\u0134\u0144"+
		"\u0151\u0159\u015e\u0164\u016e\u0176\u0181\u0191\u019a\u01a2\u01b1\u01bc"+
		"\u01c5\u01d9\u01fd\u0219\u021d\u0221\u0239\u024d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}