// Generated from C:/Users/Erwin14k/Documents/olc2vj22_202001534/FortranAnalyzer\Grammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#listaInstrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaInstrucciones(GrammarParser.ListaInstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declar}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclar(GrammarParser.DeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ptr}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtr(GrammarParser.PtrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insIf}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsIf(GrammarParser.InsIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dw}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDw(GrammarParser.DwContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fo}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFo(GrammarParser.FoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code as}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs(GrammarParser.AsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(GrammarParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fc}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFc(GrammarParser.FcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(GrammarParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subC}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubC(GrammarParser.SubCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrD}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrD(GrammarParser.ArrDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrD2}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrD2(GrammarParser.ArrD2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code comeOn}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComeOn(GrammarParser.ComeOnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneArrAs(GrammarParser.OneArrAsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneArrListAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneArrListAs(GrammarParser.OneArrListAsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code twoArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoArrAs(GrammarParser.TwoArrAsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singularNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingularNull(GrammarParser.SingularNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singularActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingularActive(GrammarParser.SingularActiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pluralNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluralNull(GrammarParser.PluralNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pluralActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluralActive(GrammarParser.PluralActiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link GrammarParser#asignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsig(GrammarParser.AsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExpr(GrammarParser.StrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(GrammarParser.OpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorExpr(GrammarParser.MayorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GrammarParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(GrammarParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneArrayAccess(GrammarParser.OneArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strExpr2}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExpr2(GrammarParser.StrExpr2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code igualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualExpr(GrammarParser.IgualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code twoArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoArrayAccess(GrammarParser.TwoArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(GrammarParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(GrammarParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code douExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouExpr(GrammarParser.DouExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorExpr(GrammarParser.MenorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorIgualExpr(GrammarParser.MayorIgualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code diferenteExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiferenteExpr(GrammarParser.DiferenteExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(GrammarParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorIgualExpr(GrammarParser.MenorIgualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizeArr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeArr(GrammarParser.SizeArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(GrammarParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_(GrammarParser.If_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIfStatement}
	 * labeled alternative in {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIfStatement(GrammarParser.NormalIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseNormal(GrammarParser.ElseNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseIfNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfNormal(GrammarParser.ElseIfNormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#doWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(GrammarParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalWhileStatement}
	 * labeled alternative in {@link GrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalWhileStatement(GrammarParser.NormalWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code easyFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEasyFor(GrammarParser.EasyForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumFor(GrammarParser.MediumForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalForStatement}
	 * labeled alternative in {@link GrammarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalForStatement(GrammarParser.NormalForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutParamsFunc(GrammarParser.WithoutParamsFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithParamsFunc(GrammarParser.WithParamsFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalFuncStatement}
	 * labeled alternative in {@link GrammarParser#funStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFuncStatement(GrammarParser.NormalFuncStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallWith}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallWith(GrammarParser.FuncCallWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallWithout}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallWithout(GrammarParser.FuncCallWithoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutParamsSub(GrammarParser.WithoutParamsSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithParamsSub(GrammarParser.WithParamsSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decPar}
	 * labeled alternative in {@link GrammarParser#decParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecPar(GrammarParser.DecParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalSubStatement}
	 * labeled alternative in {@link GrammarParser#subStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalSubStatement(GrammarParser.NormalSubStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subCallWith}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubCallWith(GrammarParser.SubCallWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subCallWithout}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubCallWithout(GrammarParser.SubCallWithoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code firstArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstArraySingular(GrammarParser.FirstArraySingularContext ctx);
	/**
	 * Visit a parse tree produced by the {@code secondArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondArraySingular(GrammarParser.SecondArraySingularContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oda}
	 * labeled alternative in {@link GrammarParser#oneDimArrayAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOda(GrammarParser.OdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tda}
	 * labeled alternative in {@link GrammarParser#twoDimArrayAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTda(GrammarParser.TdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listAsigOneArray}
	 * labeled alternative in {@link GrammarParser#oneArrayListAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAsigOneArray(GrammarParser.ListAsigOneArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code firstArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstArrayPlural(GrammarParser.FirstArrayPluralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code secondArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondArrayPlural(GrammarParser.SecondArrayPluralContext ctx);
}