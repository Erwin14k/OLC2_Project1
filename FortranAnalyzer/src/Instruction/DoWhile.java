package Instruction;
import Expression.*;
import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Objects;

public class DoWhile extends Instruction{
    private Expression condition;
    private Instruction body;
    public String line;
    public String column;

    public DoWhile(Object condition, Object body, String line, String column){
        super(line,column);
        this.condition=(Expression)condition;
        this.body=(Instruction) body;
    }


    public Object execute(Ambit ambit) {
        if(this.condition.toString().contains("Expression.Literal")){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","La expresion a evaluar dentro del do-while no es de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        Relational temp = (Relational) this.condition;
        Returnal value = temp.execute(ambit);

        //System.out.println(value.value.toString());
        if (value.type != ReturnType.LOGICAL) {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","La expresion a evaluar dentro del do-while no es de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        while (Objects.equals(value.value.toString(), "true")) {
            Object theFinal=this.body.execute(ambit);

            //System.out.println(theFinal+"------------");
            if(theFinal instanceof  Break)break;
            value = this.condition.execute(ambit);
            if(theFinal instanceof  Continue)continue;
        }

        return true;
    }


    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Relational temp = (Relational) this.condition;
        Returnal a =temp.c3d(ambit);
        //System.out.println(a.value.toString());
        if(Objects.equals(a.value.toString(), "true")){
            threeWayCodeHandler.mainCode+="\n\n\n\n\n";
            String firstLabel=threeWayCodeHandler.generateLabel();
            String secondLabel=threeWayCodeHandler.generateLabel();
            String thirdLabel=threeWayCodeHandler.generateLabel();
            threeWayCodeHandler.mainCode+=firstLabel+":\n";
            Returnal l=temp.left.c3d(ambit);
            Returnal r=temp.right.c3d(ambit);
            if(temp.right instanceof Access){
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.previousTemporal()+threeWayCodeHandler.conditionOfWhile+threeWayCodeHandler.lastTemporal()+") goto "+secondLabel+";\n";
            }else{
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.lastTemporal()+threeWayCodeHandler.conditionOfWhile+r.value.toString()+") goto "+secondLabel+";\n";
            }

            threeWayCodeHandler.mainCode+="goto "+thirdLabel+";\n";
            threeWayCodeHandler.mainCode+=secondLabel+":\n";
            Object theFinal=this.body.c3d(ambit);
            threeWayCodeHandler.mainCode+="goto "+firstLabel+";\n";
            threeWayCodeHandler.mainCode+=thirdLabel+":\n";

        }

        return true;
    }

}
