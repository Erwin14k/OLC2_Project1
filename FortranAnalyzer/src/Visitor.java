import Extra.ErrorCollector;
import Extra.Errors;
import Grammar.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;
import Instruction.*;
import Expression.*;
import Expression.Arithmetic.*;
import Ambit.*;

public class Visitor extends GrammarBaseVisitor<Object>  {
    @Override
    public Object visitStart(GrammarParser.StartContext ctx) {
        return visit(ctx.listaInstrucciones());
    }

    @Override
    public Object visitComeOn(GrammarParser.ComeOnContext ctx) {
        return visit(ctx.program());
    }
    @Override
    public Object visitListaInstrucciones(GrammarParser.ListaInstruccionesContext ctx) {

        ArrayList<Object> instructions = new ArrayList<>();

        for (ParseTree item: ctx.e){
            instructions.add(visit(item));
        }
        return instructions;
    }



    @Override
    public Object visitDeclar(GrammarParser.DeclarContext ctx) {

        return visit(ctx.declaration());
    }

    @Override
    public Object visitPtr(GrammarParser.PtrContext ctx) {
        return visit(ctx.print());
    }


    @Override
    public Object visitSingularNull(GrammarParser.SingularNullContext ctx) {

        Object num= 0;
        Object compl="9.192517926E-43,0.00000000";
        Object rea=0.00000000;
        Object cha="";
        Object logi="F";
        String type = ctx.t.getText();
        Literal num2=new Literal(num,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal compl2=new Literal(compl,LiteralType.COMPLEX,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal cha2=new Literal(cha,LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal logi2=new Literal(logi,LiteralType.LOGICAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal rea2=new Literal(rea,LiteralType.REAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        return switch (type) {
            case "integer" ->
                 new Declaration(ctx.IDEN().getText(),num2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" ->
                    new Declaration(ctx.IDEN().getText(), cha2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "complex" ->
                    new Declaration(ctx.IDEN().getText(), compl2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" ->
                    new Declaration(ctx.IDEN().getText(), rea2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "logical" ->
                    new Declaration(ctx.IDEN().getText(), logi2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default ->
                throw new IllegalArgumentException("Operación no válida");
        };
    }

    @Override
    public Object visitPluralNull(GrammarParser.PluralNullContext ctx) {
        ArrayList<String> ids = new ArrayList<>();
        ids.add(ctx.p.get(0).getText());

        for (Token item: ctx.e){
            ids.add(item.getText());
        }
        Object num= 0;
        Object compl="9.192517926E-43,0.00000000";
        Object rea=0.00000000;
        Object cha="";
        Object logi="F";
        String type = ctx.t.getText();
        Literal num2=new Literal(num,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal compl2=new Literal(compl,LiteralType.COMPLEX,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal cha2=new Literal(cha,LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal logi2=new Literal(logi,LiteralType.LOGICAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        Literal rea2=new Literal(rea,LiteralType.REAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
        return switch (type) {
            case "integer" ->
                    new MultipleDeclaration(ids,num2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" ->
                    new MultipleDeclaration(ids, cha2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "complex" ->
                    new MultipleDeclaration(ids, compl2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" ->
                    new MultipleDeclaration(ids, rea2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "logical" ->
                    new MultipleDeclaration(ids, logi2,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default ->
                    throw new IllegalArgumentException("Operación no válida");
        };
    }

    @Override
    public Object visitPluralActive(GrammarParser.PluralActiveContext ctx) {
        ArrayList<String> ids = new ArrayList<>();
        ids.add(ctx.p.get(0).getText());

        for (Token item: ctx.e){
            ids.add(item.getText());
        }
        return new MultipleDeclaration2(ids,visit(ctx.expr()),ctx.t.getText(),String.valueOf(ctx.t.getLine()), String.valueOf(ctx.t.getCharPositionInLine()));
    }

    @Override
    public Object visitSingularActive(GrammarParser.SingularActiveContext ctx) {
        return new Declaration2(ctx.IDEN().getText(), visit(ctx.expr()), ctx.t.getText(),String.valueOf(ctx.t.getLine()), String.valueOf(ctx.t.getCharPositionInLine()));
    }


    @Override
    public Object visitPrint(GrammarParser.PrintContext ctx) {
        ArrayList<Object> exprToPrint = new ArrayList<>();
        for (ParseTree item: ctx.p){
            exprToPrint.add(visit(item));
        }
        for (ParseTree item: ctx.e){
            exprToPrint.add(visit(item));
        }
        return new Print(exprToPrint, String.valueOf(ctx.ins.getLine()), String.valueOf(ctx.ins.getCharPositionInLine()));
    }




    @Override
    public Object visitOpExpr(GrammarParser.OpExprContext ctx) {
        String operation = ctx.op.getText();

        return switch (operation) {
            case "**" ->
                    new Arithmetic(visit(ctx.left), visit(ctx.right), ArithmeticType.POTENCIA, ctx.op.getLine(), ctx.op.getCharPositionInLine());
            case "*" ->
                    new Arithmetic(visit(ctx.left), visit(ctx.right), ArithmeticType.MULTIPLICACION, ctx.op.getLine(), ctx.op.getCharPositionInLine());
            case "/" ->
                    new Arithmetic(visit(ctx.left), visit(ctx.right), ArithmeticType.DIVISION, ctx.op.getLine(), ctx.op.getCharPositionInLine());
            case "+" ->
                    new Arithmetic(visit(ctx.left), visit(ctx.right), ArithmeticType.SUMA, ctx.op.getLine(), ctx.op.getCharPositionInLine());
            case "-" ->
                    new Arithmetic(visit(ctx.left), visit(ctx.right), ArithmeticType.RESTA, ctx.op.getLine(), ctx.op.getCharPositionInLine());
            default -> throw new IllegalArgumentException("Operación no válida");
        };
    }


    @Override
    public Object visitNgative(GrammarParser.NgativeContext ctx) {
        return new Arithmetic(visit(ctx.u),visit(ctx.u),ArithmeticType.NEGATIVE,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitParenExpr(GrammarParser.ParenExprContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public Object visitAtomExpr(GrammarParser.AtomExprContext ctx) {
        //return new Primitive("int", ctx.getText(), ctx.atom.getLine(), ctx.atom.getCharPositionInLine());
        return new Literal(ctx.getText(),LiteralType.INTEGER,ctx.atom.getLine(), ctx.atom.getCharPositionInLine());
    }

    @Override
    public Object visitStrExpr(GrammarParser.StrExprContext ctx) {
        return new Literal(ctx.getText().substring(1, ctx.getText().length() - 1),LiteralType.STRING,  ctx.str.getLine(), ctx.str.getCharPositionInLine());
    }

    @Override
    public Object visitStrExpr2(GrammarParser.StrExpr2Context ctx) {
        //System.out.println(ctx.getText());
        return new Literal(ctx.getText().substring(1, ctx.getText().length() - 1),LiteralType.STRING,  ctx.str2.getLine(), ctx.str2.getCharPositionInLine());
    }

    @Override
    public Object visitDouExpr(GrammarParser.DouExprContext ctx) {
        return new Literal(ctx.dou.getText(),LiteralType.REAL,ctx.dou.getLine(), ctx.dou.getCharPositionInLine());
    }

    @Override
    public Object visitBoolExpr(GrammarParser.BoolExprContext ctx){
        String operation = ctx.bool.getText();
        //System.out.println(ctx.bool.getText());
        return switch (operation) {
            case ".false." ->
                    new Literal("F",LiteralType.LOGICAL,  ctx.bool.getLine(), ctx.bool.getCharPositionInLine());
            case ".true."->
                    new Literal("T",LiteralType.LOGICAL,  ctx.bool.getLine(), ctx.bool.getCharPositionInLine());
            default ->
                    throw new IllegalArgumentException("Operación no válida");

        };
    }

    @Override
    public Object visitIdExpr(GrammarParser.IdExprContext ctx) {
        return new Access(ctx.id.getText().toUpperCase(),ctx.id.getLine(),ctx.id.getCharPositionInLine());
    }



    @Override
    public Object visitIgualExpr(GrammarParser.IgualExprContext ctx) {
        //new Relacional($1,$3,TipoRelacional.IGUALIGUAL, @1.first_line, @1.first_column)}
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.IGUALIGUAL,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitDiferenteExpr(GrammarParser.DiferenteExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.DIFERENTE,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitMayorIgualExpr(GrammarParser.MayorIgualExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.MAYOR_IGUAL,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitMenorIgualExpr(GrammarParser.MenorIgualExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.MENOR_IGUAL,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitMayorExpr(GrammarParser.MayorExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.MAYOR,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitAndExpr(GrammarParser.AndExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.AND,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitOrExpr(GrammarParser.OrExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.OR,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitNotExpr(GrammarParser.NotExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.left),RelationalType.NOT,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitMenorExpr(GrammarParser.MenorExprContext ctx) {
        return new Relational(visit(ctx.left),visit(ctx.right),RelationalType.MENOR,ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }

    @Override
    public Object visitInsIf(GrammarParser.InsIfContext ctx) {
        return visit(ctx.if_());
    }
    @Override
    public Object visitIf_(GrammarParser.If_Context ctx) {
        if(ctx.else_()==null){
            return new If(visit(ctx.expr()),visit(ctx.statement()),null,String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
        }else{
            return new If(visit(ctx.expr()),visit(ctx.statement()),visit(ctx.else_()),String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
        }

    }

    @Override
    public Object visitNormalIfStatement(GrammarParser.NormalIfStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            //System.out.println(visit(item));
            instructions.add(visit(item));
        }
        //System.out.println(instructions.size()+"  uyt");
        return new Statement(instructions,String.valueOf(0),String.valueOf(0));
    }

    @Override
    public Object visitElseNormal(GrammarParser.ElseNormalContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public Object visitElseIfNormal(GrammarParser.ElseIfNormalContext ctx) {
        return visit(ctx.if_());
    }



    @Override
    public Object visitDw(GrammarParser.DwContext ctx) {
        return visit(ctx.doWhile());
    }

    @Override
    public Object visitNormalWhileStatement(GrammarParser.NormalWhileStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            //System.out.println(visit(item));
            instructions.add(visit(item));
        }
        //System.out.println(instructions.size()+"  uyt");
        return new Statement(instructions,String.valueOf(0),String.valueOf(0));
    }

    @Override
    public Object visitDoWhile(GrammarParser.DoWhileContext ctx) {
        return new DoWhile(visit(ctx.expr()),visit(ctx.whileStatement()),String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
    }

    @Override
    public Object visitAs(GrammarParser.AsContext ctx) {
        return visit(ctx.asignation());
    }

    @Override
    public Object visitAsig(GrammarParser.AsigContext ctx) {
        return new Asignation(ctx.IDEN().getText(),visit(ctx.expr()),String.valueOf(ctx.o.getLine()),String.valueOf(ctx.o.getCharPositionInLine()));
    }

    @Override
    public Object visitFo(GrammarParser.FoContext ctx) {
        return visit(ctx.for_());
    }

    @Override
    public Object visitEasyFor(GrammarParser.EasyForContext ctx) {
        return new For(ctx.ini.getText(),ctx.lim.getText(),ctx.sped.getText(),visit(ctx.forStatement()),String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
    }

    @Override
    public Object visitMediumFor(GrammarParser.MediumForContext ctx) {
        String name=ctx.asignation().getText();
        String [] temp=name.split("=");
        return new MediumFor(temp[0],visit(ctx.lim),visit(ctx.sped),visit(ctx.asignation()),visit(ctx.forStatement()),String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
    }

    @Override
    public Object visitNormalForStatement(GrammarParser.NormalForStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            instructions.add(visit(item));
        }
        return new Statement(instructions,String.valueOf(0),String.valueOf(0));
    }


    @Override
    public Object visitNormalFuncStatement(GrammarParser.NormalFuncStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            instructions.add(visit(item));
        }
        return new Statement(instructions,String.valueOf(0),String.valueOf(0));
    }

    @Override
    public Object visitFun(GrammarParser.FunContext ctx) {
        return visit(ctx.function());
    }

    @Override
    public Object visitWithParamsFunc(GrammarParser.WithParamsFuncContext ctx) {
        if(Objects.equals(ctx.name.getText(), ctx.name2.getText())){
            ArrayList<String> parameters = new ArrayList<>();
            for (ParseTree item: ctx.p){
                parameters.add(item.getText());
            }
            for (ParseTree item: ctx.e){
                parameters.add(item.getText());
            }
            ArrayList<String> decTypes = new ArrayList<>();
            for (ParseTree item: ctx.l){
                decTypes.add(item.getChild(0).getText());
            }
            return new Function(ctx.name.getText(),visit(ctx.funStatement()),parameters,ctx.res.getText(),decTypes,String.valueOf(ctx.u.getLine()),String.valueOf(ctx.u.getCharPositionInLine()));
        }else{
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Declaracion de funcion invalida, el identificador '"+ctx.name.getText()+"' no coincide con el identificador '"+ctx.name2.getText()+"'",String.valueOf(ctx.u.getLine()),String.valueOf(ctx.u.getCharPositionInLine())));
            return null;
        }
    }

    @Override
    public Object visitWithoutParamsFunc(GrammarParser.WithoutParamsFuncContext ctx) {
        if(Objects.equals(ctx.name.getText(), ctx.name2.getText())) {
            ArrayList<String> parameters = new ArrayList<>();
            ArrayList<String> decTypes = new ArrayList<>();
            for (ParseTree item: ctx.l){
                decTypes.add(item.getChild(0).getText());
            }
            return new Function(ctx.name.getText(), visit(ctx.funStatement()), parameters, ctx.res.getText(), decTypes, String.valueOf(ctx.u.getLine()), String.valueOf(ctx.u.getCharPositionInLine()));
        }else{
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Declaracion de funcion invalida, el identificador '"+ctx.name.getText()+"' no coincide con el identificador '"+ctx.name2.getText()+"'",String.valueOf(ctx.u.getLine()),String.valueOf(ctx.u.getCharPositionInLine())));
            return null;
        }
    }

    @Override
    public Object visitFuncCallWith(GrammarParser.FuncCallWithContext ctx) {
        ArrayList<Expression> parameters = new ArrayList<>();
        for (ParseTree item: ctx.p){
            Expression temp=(Expression)visit(item);
            parameters.add(temp);
        }
        for (ParseTree item: ctx.e){
            Expression temp=(Expression)visit(item);
            parameters.add(temp);
        }
        return new FunctionCallExpr(ctx.y.getText(),parameters,ctx.y.getLine() ,ctx.y.getCharPositionInLine());
    }

    @Override
    public Object visitFuncCallWithout(GrammarParser.FuncCallWithoutContext ctx) {
        ArrayList<Expression> parameters = new ArrayList<>();
        return new FunctionCallExpr(ctx.y.getText(),parameters,ctx.y.getLine() ,ctx.y.getCharPositionInLine());
    }

    @Override
    public Object visitSub(GrammarParser.SubContext ctx) {
        return visit(ctx.subroutine());
    }

    @Override
    public Object visitNormalSubStatement(GrammarParser.NormalSubStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            instructions.add(visit(item));
        }
        return new Statement(instructions,String.valueOf(0),String.valueOf(0));
    }
    @Override
    public Object visitWithParamsSub(GrammarParser.WithParamsSubContext ctx) {
        if (Objects.equals(ctx.name.getText(), ctx.name2.getText())) {
            ArrayList<String> parameters = new ArrayList<>();
            for (ParseTree item : ctx.p) {
                Object i = visit(item);
                //System.out.println(item.getText()+"%%%");
                parameters.add(item.getText());
            }
            for (ParseTree item : ctx.e) {
                parameters.add(item.getText());
            }

            ArrayList<String> decTypes = new ArrayList<>();
            for (ParseTree item : ctx.l) {
                decTypes.add(item.getChild(0).getText());
            }
            return new Subroutine(ctx.name.getText(), visit(ctx.subStatement()), parameters, decTypes, String.valueOf(ctx.u.getLine()), String.valueOf(ctx.u.getCharPositionInLine()));
        } else {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Declaracion de Subrutina invalida, el identificador '"+ctx.name.getText()+"' no coincide con el identificador '"+ctx.name2.getText()+"'",String.valueOf(ctx.u.getLine()),String.valueOf(ctx.u.getCharPositionInLine())));
            return null;

        }
    }

    @Override
    public Object visitWithoutParamsSub(GrammarParser.WithoutParamsSubContext ctx) {
        if (Objects.equals(ctx.name.getText(), ctx.name2.getText())) {
            ArrayList<String> parameters = new ArrayList<>();
            ArrayList<String> decTypes = new ArrayList<>();
            return new Subroutine(ctx.name.getText(), visit(ctx.subStatement()), parameters, decTypes, String.valueOf(ctx.u.getLine()), String.valueOf(ctx.u.getCharPositionInLine()));

        }else{
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Declaracion de Subrutina invalida, el identificador '"+ctx.name.getText()+"' no coincide con el identificador '"+ctx.name2.getText()+"'",String.valueOf(ctx.u.getLine()),String.valueOf(ctx.u.getCharPositionInLine())));
            return null;
        }
    }

    @Override
    public Object visitSubCallWith(GrammarParser.SubCallWithContext ctx) {
        ArrayList<Expression> parameters = new ArrayList<>();
        for (ParseTree item: ctx.p){
            Expression temp=(Expression)visit(item);
            parameters.add(temp);
        }
        for (ParseTree item: ctx.e){
            Expression temp=(Expression)visit(item);
            parameters.add(temp);
        }
        return new SubroutineCall(ctx.y.getText(),parameters,String.valueOf(ctx.t.getLine()) ,String.valueOf(ctx.t.getCharPositionInLine()));
    }

    @Override
    public Object visitSubCallWithout(GrammarParser.SubCallWithoutContext ctx) {
        ArrayList<Expression> parameters = new ArrayList<>();
        return new SubroutineCall(ctx.y.getText(),parameters,String.valueOf(ctx.t.getLine()) ,String.valueOf(ctx.t.getCharPositionInLine()));
    }

    @Override
    public Object visitArrD(GrammarParser.ArrDContext ctx){
        return(visit(ctx.arrayDeclaration()));
    }

    @Override
    public Object visitFirstArraySingular(GrammarParser.FirstArraySingularContext ctx) {

        String type = ctx.t.getText();
        ArrayList<Object> values=new ArrayList<>();
        switch (type) {
            case "integer" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal(0,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal("",LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal(0.00000000,LiteralType.REAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                    throw new IllegalArgumentException("Operación no válida");

        }
    }


    @Override
    public Object visitSecondArraySingular(GrammarParser.SecondArraySingularContext ctx) {
        String type2 = ctx.t.getText();
        ArrayList<Object> values=new ArrayList<>();
        switch (type2) {
            case "integer" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal(0,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal("",LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    Literal num2=new Literal(0.00000000,LiteralType.REAL,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                    values.add(num2);
                }
                return new ArrayDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                throw new IllegalArgumentException("Operación no válida");

        }
    }


    @Override
    public Object visitOneArrayAccess(GrammarParser.OneArrayAccessContext ctx) {
        return new OneDimArrayAccess(ctx.id.getText(),visit(ctx.ind),ctx.id.getLine(),ctx.id.getCharPositionInLine());
    }

    @Override
    public Object visitTwoArrayAccess(GrammarParser.TwoArrayAccessContext ctx){
        return new TwoDimArrayAccess(ctx.id.getText(),visit(ctx.ind1),visit(ctx.ind2),ctx.id.getLine(),ctx.id.getCharPositionInLine());
    }
    @Override
    public Object visitOneArrAs(GrammarParser.OneArrAsContext ctx) {
        return visit(ctx.oneDimArrayAsig());
    }

    @Override
    public Object visitOda(GrammarParser.OdaContext ctx) {
        return new OneDimArrayAssig(ctx.IDEN().getText(),visit(ctx.f),visit(ctx.e),String.valueOf(ctx.o.getLine()),String.valueOf(ctx.o.getCharPositionInLine()));

    }

    @Override
    public Object visitTda(GrammarParser.TdaContext ctx) {
        return new TwoDimArrayAssig(ctx.IDEN().getText(),visit(ctx.f),visit(ctx.a),visit(ctx.b),String.valueOf(ctx.o.getLine()),String.valueOf(ctx.o.getCharPositionInLine()));
    }

    @Override
    public Object visitOneArrListAs(GrammarParser.OneArrListAsContext ctx) {
        return visit(ctx.oneArrayListAsig());
    }

    @Override
    public Object visitListAsigOneArray(GrammarParser.ListAsigOneArrayContext ctx) {
        ArrayList<Expression> values = new ArrayList<>();
        for (ParseTree item: ctx.p){
            Expression temp1=(Expression)visit(item);
            values.add(temp1);
        }
        for (ParseTree item: ctx.e){
            Expression temp2=(Expression)visit(item);
            values.add(temp2);
        }
        return new OneDimArrayListAssig(ctx.o.getText(),values,String.valueOf(ctx.o.getLine()) ,String.valueOf(ctx.o.getCharPositionInLine()));
    }

    @Override
    public Object visitSizeArr(GrammarParser.SizeArrContext ctx) {
        return new SizeOneDimArray(ctx.id.getText(),ctx.t.getLine(),ctx.t.getCharPositionInLine());
    }

    @Override
    public Object visitFirstArrayPlural(GrammarParser.FirstArrayPluralContext ctx) {
        String type = ctx.t.getText();
        ArrayList<Object> values=new ArrayList<>();
        switch (type) {
            case "integer" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal(0,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal("",LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal(0.00000000,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                throw new IllegalArgumentException("Operación no válida");

        }
    }

    @Override
    public Object visitSecondArrayPlural(GrammarParser.SecondArrayPluralContext ctx) {
        String type = ctx.t.getText();
        ArrayList<Object> values=new ArrayList<>();
        switch (type) {
            case "integer" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal(0,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal("",LiteralType.STRING,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :
                for(int i=0;i<Integer.parseInt(ctx.left.getText());i++){
                    ArrayList<Object> tempList=new ArrayList<>();
                    for(int j=0;j<Integer.parseInt(ctx.right.getText());j++){
                        Literal num2=new Literal(0.00000000,LiteralType.INTEGER,ctx.t.getLine(),ctx.t.getCharPositionInLine());
                        tempList.add(num2);
                    }
                    values.add(tempList);
                }
                return new ArrayTwoDeclaration(ctx.id.getText(),values,Integer.parseInt(ctx.left.getText()),Integer.parseInt(ctx.right.getText()),ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                throw new IllegalArgumentException("Operación no válida");

        }

    }

     @Override
     public Object visitArrD2(GrammarParser.ArrD2Context ctx){
        return visit(ctx.arrayDeclaration2());
     }


    @Override
    public Object visitExprFunctionReturn(GrammarParser.ExprFunctionReturnContext ctx) {
        return(visit(ctx.functionCall()));
    }


    @Override
    public Object visitCont(GrammarParser.ContContext ctx) {
        return visit(ctx.continue_());
    }

    @Override
    public Object visitBre(GrammarParser.BreContext ctx) {
        return visit(ctx.break_());
    }

    @Override
    public Object visitContinue_(GrammarParser.Continue_Context ctx) {
        return new Continue(String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
    }


    @Override
    public Object visitBreak_(GrammarParser.Break_Context ctx) {
        return new Break(String.valueOf(ctx.i.getLine()),String.valueOf(ctx.i.getCharPositionInLine()));
    }

    @Override
    public Object visitMainProgram(GrammarParser.MainProgramContext ctx) {
        //System.out.println(ctx.u1);
        //System.out.println(ctx.f);
        if(!Objects.equals(ctx.u1.getText(), ctx.f.getText())){
            //System.out.println("no entra");
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","El id: '"+ctx.u1.getText()+"' no coincide con el id: '"+ctx.f.getText()+"' , Al declarar el main program",String.valueOf(ctx.y.getLine()),String.valueOf(ctx.y.getCharPositionInLine())));
            return null;
        }else{
        return new Program(ctx.u1.getText(),visit(ctx.programStatement()),String.valueOf(ctx.y.getLine()),String.valueOf(ctx.y.getCharPositionInLine()));
        }
    }

    @Override
    public Object visitMainStatement(GrammarParser.MainStatementContext ctx) {
        ArrayList<Object> instructions = new ArrayList<>();
        for (ParseTree item: ctx.e){
            instructions.add(visit(item));
        }
        return new MainStatement(instructions,String.valueOf(0),String.valueOf(0));
    }

    @Override
    public Object visitDynamic1(GrammarParser.Dynamic1Context ctx) {
        return visit(ctx.dynamicArrayDec());
    }

    @Override
    public Object visitOneDynamic(GrammarParser.OneDynamicContext ctx) {
        String type = ctx.t.getText();
        //System.out.println("una visita");
        ArrayList<Object> values=new ArrayList<>();
        switch (type) {
            case "integer" :

                return new DynamicOneDeclaration(ctx.id.getText(),values,-1,ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :
                return new DynamicOneDeclaration(ctx.id.getText(),values,-1,ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :

                return new DynamicOneDeclaration(ctx.id.getText(),values,-1,ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                throw new IllegalArgumentException("Operación no válida");

        }
    }

    @Override
    public Object visitTwoDynamic(GrammarParser.TwoDynamicContext ctx) {
        String type = ctx.t.getText();
        ArrayList<Object> values=new ArrayList<>();
        switch (type) {
            case "integer" :
                return new DynamicTwoDeclaration(ctx.id.getText(),values,-1,1,ReturnType.INTEGER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "character" :

                return new DynamicTwoDeclaration(ctx.id.getText(),values,-1,1,ReturnType.CHARACTER,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            case "real" :
                 return new DynamicTwoDeclaration(ctx.id.getText(),values,-1,1,ReturnType.REAL,String.valueOf(ctx.t.getLine()),String.valueOf(ctx.t.getCharPositionInLine()));
            default :
                throw new IllegalArgumentException("Operación no válida");

        }
    }

    @Override
    public Object visitAllo(GrammarParser.AlloContext ctx) {
        return visit(ctx.allocate());
    }

    @Override
    public Object visitDeall(GrammarParser.DeallContext ctx) {
        return visit(ctx.deallocate());
    }

    @Override
    public Object visitOneAllocate(GrammarParser.OneAllocateContext ctx) {
        return new AllocateOne(ctx.i.getText(),visit(ctx.g),String.valueOf(ctx.a.getLine()),String.valueOf(ctx.a.getCharPositionInLine()));
    }

    @Override
    public Object visitTwoAllocate(GrammarParser.TwoAllocateContext ctx) {
        return new AllocateTwo(ctx.i.getText(),visit(ctx.g1),visit(ctx.g2),String.valueOf(ctx.a.getLine()),String.valueOf(ctx.a.getCharPositionInLine()));
    }

    @Override
    public Object visitDeallocate(GrammarParser.DeallocateContext ctx) {
        return new DeallocateOne(ctx.i.getText(),String.valueOf(ctx.o.getLine()) ,String.valueOf(ctx.o.getCharPositionInLine()));
    }
}
