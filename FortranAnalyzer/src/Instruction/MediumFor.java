package Instruction;

import Ambit.*;
import Expression.*;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;


public class MediumFor extends Instruction {

    private Instruction body;
    private Instruction assignBody;
    public Object initial;
    public Expression limit;
    public Expression speed;
    public String line;
    public String column;

    public MediumFor(Object initial, Object limit, Object speed, Object assignBody,Object body, String line, String column) {
        super(line, column);
        this.initial = initial;
        this.speed = (Expression)speed;
        this.limit = (Expression)limit;
        this.body = (Instruction) body;
        this.assignBody = (Instruction) assignBody;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {

        this.assignBody.execute(ambit);
        //System.out.println(this.initial);
        Returnal limitVal=this.limit.execute(ambit);
        Returnal speedVal=this.speed.execute(ambit);
        String limitt=limitVal.value.toString();
        String speed=speedVal.value.toString();
        Symbol s=ambit.getVal(this.initial.toString().toUpperCase(),String.valueOf(this.line) ,String.valueOf(this.column));
        String inii = s.value.toString();
        //System.out.println(s.value.toString()+"/////"+s.type);
        //System.out.println(Integer.parseInt(inii)+"(((((");
        for (int i = Integer.parseInt(inii); i <= Integer.parseInt(limitt); i +=0) {

            Object theFinal=this.body.execute(ambit);


            if(theFinal instanceof  Break)break;
            ambit.update(this.initial.toString().toUpperCase(),i += Integer.parseInt(speed),this.line,this.column);
            if(theFinal instanceof  Continue)continue;
        }
        return true;
    }

    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        this.assignBody.c3d(ambit);
        Returnal limitVal=this.limit.c3d(ambit);
        Returnal speedVal=this.speed.c3d(ambit);
        String limitt=limitVal.value.toString();
        String speed=speedVal.value.toString();
        Symbol s=ambit.getVal(this.initial.toString().toUpperCase(),String.valueOf(this.line) ,String.valueOf(this.column));
        Object a=threeWayCodeHandler.getVariableData(s.getId().toUpperCase());
        ArrayList data=(ArrayList)a;
        String firstLabel=threeWayCodeHandler.generateLabel();
        String secondLabel=threeWayCodeHandler.generateLabel();
        String thirdLabel=threeWayCodeHandler.generateLabel();
        String fourthLabel=threeWayCodeHandler.generateLabel();



        threeWayCodeHandler.mainCode+=firstLabel+":\n";
        String speedTemp=threeWayCodeHandler.generateTemporal();
        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=STACK[(int)"+data.get(0).toString()+"];\n";
        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+limitt+";\n";
        String limitTemp=threeWayCodeHandler.lastTemporal();
        threeWayCodeHandler.mainCode+=speedTemp+"="+speed+";\n";

        threeWayCodeHandler.mainCode+="if("+threeWayCodeHandler.previousTemporal()+"<="+limitTemp+") goto "+secondLabel+";\n";
        threeWayCodeHandler.mainCode+="goto "+thirdLabel+";\n";

        threeWayCodeHandler.mainCode+=secondLabel+":\n";
        this.body.c3d(ambit);

        //Se reasigna el valor del temporal de la condicional
        threeWayCodeHandler.mainCode+=fourthLabel+":\n";
        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=STACK[(int)"+data.get(0).toString()+"];\n";
        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+speedTemp+";\n";
        threeWayCodeHandler.mainCode+="STACK[(int)"+data.get(0).toString()+"]="+threeWayCodeHandler.lastTemporal()+";\n";
        threeWayCodeHandler.mainCode+="goto "+firstLabel+";\n";
        threeWayCodeHandler.mainCode+=thirdLabel+":\n";



        return true;
    }
}
