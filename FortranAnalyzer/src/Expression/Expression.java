package Expression;

import Ambit.Ambit;
import Ambit.Symbol;

public abstract class Expression {
    public int line;
    public int column;

    public Expression(int line, int column) {
        this.line = line;
        this.column = column;
    }
/*
* ctx.getStart().getLine(),
    ctx.getStart().getCharPositionInLine()*/
    public abstract Returnal execute(Ambit ambit) ;

    public abstract Returnal c3d(Ambit ambit) ;


    public int dominantType(ReturnType type1, ReturnType type2){
        //System.out.println(type1.getValue()+"--"+type2.getValue()+"--"+ReturnType.matrix[type1.getValue()][type2.getValue()]);
        return ReturnType.matrix[type1.getValue()][type2.getValue()];

    }
}
