// Generated from C:/Users/Erwin14k/Documents/olc2vj22_202001534/FortranAnalyzer\Grammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listaInstrucciones}.
	 * @param ctx the parse tree
	 */
	void enterListaInstrucciones(GrammarParser.ListaInstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listaInstrucciones}.
	 * @param ctx the parse tree
	 */
	void exitListaInstrucciones(GrammarParser.ListaInstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declar}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDeclar(GrammarParser.DeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declar}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDeclar(GrammarParser.DeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ptr}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterPtr(GrammarParser.PtrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ptr}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitPtr(GrammarParser.PtrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insIf}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInsIf(GrammarParser.InsIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insIf}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInsIf(GrammarParser.InsIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dw}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDw(GrammarParser.DwContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dw}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDw(GrammarParser.DwContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fo}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFo(GrammarParser.FoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fo}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFo(GrammarParser.FoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code as}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterAs(GrammarParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code as}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitAs(GrammarParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fun}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFun(GrammarParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fun}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFun(GrammarParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fc}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFc(GrammarParser.FcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fc}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFc(GrammarParser.FcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSub(GrammarParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSub(GrammarParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subC}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSubC(GrammarParser.SubCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subC}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSubC(GrammarParser.SubCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrD}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterArrD(GrammarParser.ArrDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrD}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitArrD(GrammarParser.ArrDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrD2}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterArrD2(GrammarParser.ArrD2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arrD2}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitArrD2(GrammarParser.ArrD2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code comeOn}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterComeOn(GrammarParser.ComeOnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comeOn}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitComeOn(GrammarParser.ComeOnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterOneArrAs(GrammarParser.OneArrAsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitOneArrAs(GrammarParser.OneArrAsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneArrListAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterOneArrListAs(GrammarParser.OneArrListAsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneArrListAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitOneArrListAs(GrammarParser.OneArrListAsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code twoArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTwoArrAs(GrammarParser.TwoArrAsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code twoArrAs}
	 * labeled alternative in {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTwoArrAs(GrammarParser.TwoArrAsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singularNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterSingularNull(GrammarParser.SingularNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singularNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitSingularNull(GrammarParser.SingularNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singularActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterSingularActive(GrammarParser.SingularActiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singularActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitSingularActive(GrammarParser.SingularActiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pluralNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterPluralNull(GrammarParser.PluralNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pluralNull}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitPluralNull(GrammarParser.PluralNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pluralActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterPluralActive(GrammarParser.PluralActiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pluralActive}
	 * labeled alternative in {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitPluralActive(GrammarParser.PluralActiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asig}
	 * labeled alternative in {@link GrammarParser#asignation}.
	 * @param ctx the parse tree
	 */
	void enterAsig(GrammarParser.AsigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link GrammarParser#asignation}.
	 * @param ctx the parse tree
	 */
	void exitAsig(GrammarParser.AsigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(GrammarParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(GrammarParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(GrammarParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(GrammarParser.OpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mayorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMayorExpr(GrammarParser.MayorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mayorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMayorExpr(GrammarParser.MayorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(GrammarParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(GrammarParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(GrammarParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(GrammarParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOneArrayAccess(GrammarParser.OneArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOneArrayAccess(GrammarParser.OneArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr2}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr2(GrammarParser.StrExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr2}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr2(GrammarParser.StrExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code igualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIgualExpr(GrammarParser.IgualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code igualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIgualExpr(GrammarParser.IgualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code twoArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTwoArrayAccess(GrammarParser.TwoArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code twoArrayAccess}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTwoArrayAccess(GrammarParser.TwoArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(GrammarParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(GrammarParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(GrammarParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(GrammarParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code douExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDouExpr(GrammarParser.DouExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code douExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDouExpr(GrammarParser.DouExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code menorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMenorExpr(GrammarParser.MenorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code menorExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMenorExpr(GrammarParser.MenorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mayorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMayorIgualExpr(GrammarParser.MayorIgualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mayorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMayorIgualExpr(GrammarParser.MayorIgualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code diferenteExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDiferenteExpr(GrammarParser.DiferenteExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code diferenteExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDiferenteExpr(GrammarParser.DiferenteExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(GrammarParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(GrammarParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code menorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMenorIgualExpr(GrammarParser.MenorIgualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code menorIgualExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMenorIgualExpr(GrammarParser.MenorIgualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeArr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSizeArr(GrammarParser.SizeArrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeArr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSizeArr(GrammarParser.SizeArrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(GrammarParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(GrammarParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterIf_(GrammarParser.If_Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitIf_(GrammarParser.If_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code normalIfStatement}
	 * labeled alternative in {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterNormalIfStatement(GrammarParser.NormalIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalIfStatement}
	 * labeled alternative in {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitNormalIfStatement(GrammarParser.NormalIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elseNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElseNormal(GrammarParser.ElseNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elseNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElseNormal(GrammarParser.ElseNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elseIfNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElseIfNormal(GrammarParser.ElseIfNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elseIfNormal}
	 * labeled alternative in {@link GrammarParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElseIfNormal(GrammarParser.ElseIfNormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(GrammarParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(GrammarParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalWhileStatement}
	 * labeled alternative in {@link GrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterNormalWhileStatement(GrammarParser.NormalWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalWhileStatement}
	 * labeled alternative in {@link GrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitNormalWhileStatement(GrammarParser.NormalWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code easyFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 */
	void enterEasyFor(GrammarParser.EasyForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code easyFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 */
	void exitEasyFor(GrammarParser.EasyForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mediumFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 */
	void enterMediumFor(GrammarParser.MediumForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mediumFor}
	 * labeled alternative in {@link GrammarParser#for_}.
	 * @param ctx the parse tree
	 */
	void exitMediumFor(GrammarParser.MediumForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalForStatement}
	 * labeled alternative in {@link GrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterNormalForStatement(GrammarParser.NormalForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalForStatement}
	 * labeled alternative in {@link GrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitNormalForStatement(GrammarParser.NormalForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withoutParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterWithoutParamsFunc(GrammarParser.WithoutParamsFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withoutParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitWithoutParamsFunc(GrammarParser.WithoutParamsFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterWithParamsFunc(GrammarParser.WithParamsFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withParamsFunc}
	 * labeled alternative in {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitWithParamsFunc(GrammarParser.WithParamsFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalFuncStatement}
	 * labeled alternative in {@link GrammarParser#funStatement}.
	 * @param ctx the parse tree
	 */
	void enterNormalFuncStatement(GrammarParser.NormalFuncStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalFuncStatement}
	 * labeled alternative in {@link GrammarParser#funStatement}.
	 * @param ctx the parse tree
	 */
	void exitNormalFuncStatement(GrammarParser.NormalFuncStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallWith}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallWith(GrammarParser.FuncCallWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallWith}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallWith(GrammarParser.FuncCallWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallWithout}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallWithout(GrammarParser.FuncCallWithoutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallWithout}
	 * labeled alternative in {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallWithout(GrammarParser.FuncCallWithoutContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withoutParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 */
	void enterWithoutParamsSub(GrammarParser.WithoutParamsSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withoutParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 */
	void exitWithoutParamsSub(GrammarParser.WithoutParamsSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 */
	void enterWithParamsSub(GrammarParser.WithParamsSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withParamsSub}
	 * labeled alternative in {@link GrammarParser#subroutine}.
	 * @param ctx the parse tree
	 */
	void exitWithParamsSub(GrammarParser.WithParamsSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decPar}
	 * labeled alternative in {@link GrammarParser#decParameter}.
	 * @param ctx the parse tree
	 */
	void enterDecPar(GrammarParser.DecParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decPar}
	 * labeled alternative in {@link GrammarParser#decParameter}.
	 * @param ctx the parse tree
	 */
	void exitDecPar(GrammarParser.DecParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalSubStatement}
	 * labeled alternative in {@link GrammarParser#subStatement}.
	 * @param ctx the parse tree
	 */
	void enterNormalSubStatement(GrammarParser.NormalSubStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalSubStatement}
	 * labeled alternative in {@link GrammarParser#subStatement}.
	 * @param ctx the parse tree
	 */
	void exitNormalSubStatement(GrammarParser.NormalSubStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subCallWith}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void enterSubCallWith(GrammarParser.SubCallWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subCallWith}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void exitSubCallWith(GrammarParser.SubCallWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subCallWithout}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void enterSubCallWithout(GrammarParser.SubCallWithoutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subCallWithout}
	 * labeled alternative in {@link GrammarParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void exitSubCallWithout(GrammarParser.SubCallWithoutContext ctx);
	/**
	 * Enter a parse tree produced by the {@code firstArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFirstArraySingular(GrammarParser.FirstArraySingularContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFirstArraySingular(GrammarParser.FirstArraySingularContext ctx);
	/**
	 * Enter a parse tree produced by the {@code secondArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSecondArraySingular(GrammarParser.SecondArraySingularContext ctx);
	/**
	 * Exit a parse tree produced by the {@code secondArraySingular}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSecondArraySingular(GrammarParser.SecondArraySingularContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oda}
	 * labeled alternative in {@link GrammarParser#oneDimArrayAsig}.
	 * @param ctx the parse tree
	 */
	void enterOda(GrammarParser.OdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oda}
	 * labeled alternative in {@link GrammarParser#oneDimArrayAsig}.
	 * @param ctx the parse tree
	 */
	void exitOda(GrammarParser.OdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tda}
	 * labeled alternative in {@link GrammarParser#twoDimArrayAsig}.
	 * @param ctx the parse tree
	 */
	void enterTda(GrammarParser.TdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tda}
	 * labeled alternative in {@link GrammarParser#twoDimArrayAsig}.
	 * @param ctx the parse tree
	 */
	void exitTda(GrammarParser.TdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listAsigOneArray}
	 * labeled alternative in {@link GrammarParser#oneArrayListAsig}.
	 * @param ctx the parse tree
	 */
	void enterListAsigOneArray(GrammarParser.ListAsigOneArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listAsigOneArray}
	 * labeled alternative in {@link GrammarParser#oneArrayListAsig}.
	 * @param ctx the parse tree
	 */
	void exitListAsigOneArray(GrammarParser.ListAsigOneArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code firstArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 */
	void enterFirstArrayPlural(GrammarParser.FirstArrayPluralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 */
	void exitFirstArrayPlural(GrammarParser.FirstArrayPluralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code secondArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 */
	void enterSecondArrayPlural(GrammarParser.SecondArrayPluralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code secondArrayPlural}
	 * labeled alternative in {@link GrammarParser#arrayDeclaration2}.
	 * @param ctx the parse tree
	 */
	void exitSecondArrayPlural(GrammarParser.SecondArrayPluralContext ctx);
}