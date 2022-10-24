package Instruction;
import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Objects;

public class If extends  Instruction{
    private Object condition;
    private Instruction body;
    private Object _else_;
    public int line;
    public int column;

    public If(Object condition, Object body, Object _else_, String line, String column){
        super(line,column);
        this.condition=condition;
        this.body=(Instruction) body;
        this._else_=_else_;
    }

    public Object  execute(Ambit ambit) {
        Relational temp = (Relational) this.condition;
        //System.out.println(temp+"____");
        Returnal value = temp.execute(ambit);

        if (value.type != ReturnType.LOGICAL) {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","La expresión a evaluar en el 'If' no es de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
        }
        if (Objects.equals(value.value.toString(), "true")) {
            Object theFinal=this.body.execute(ambit);
            //System.out.println(theFinal+"???????????");
            if(theFinal instanceof  Break){
                //System.out.println("hay un breakkkkkkkkkkkk");
                return theFinal;
            }else if(theFinal instanceof  Continue){
                return theFinal;

            } else{
                return true;
            }


        } else {
            if (this._else_ != null) {
                Instruction ins=(Instruction)this._else_;
                Object theFinal= ins.execute(ambit);
                if(theFinal instanceof  Break){
                    //System.out.println("siuuuu");
                    return theFinal;
                }else if(theFinal instanceof  Continue){
                    return theFinal;

                } else{
                    return true;
                }
            }
        }
        return null;
    }

    public Object c3d(Ambit ambit){
        System.out.println("11111111111111111111");
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Relational temp = (Relational) this.condition;
        Returnal value = temp.c3d(ambit);


        threeWayCodeHandler.mainCode+="\n\n\n";
        threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.lastTemporal()+"==1"+") goto "+threeWayCodeHandler.generateLabel()+";\n";
        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
        if (Objects.equals(value.value.toString(), "true")) {
            System.out.println("22222222222222222");
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
            //System.out.println(this.body);
            this.body.c3d(ambit);
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

        } else {
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
            if (this._else_ != null) {
                Statement list = (Statement) this._else_;
                //System.out.println(ins);
                boolean existAnotherIf=false;
                for (Object elseS : list.code) {
                    Instruction verify = (Instruction) elseS;
                    if(verify instanceof If) {
                        existAnotherIf=true;
                        break;
                    }
                }

                if(existAnotherIf){
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                    Instruction ins=(Instruction)this._else_;
                    Object theFinal= ins.c3d(ambit);

                }else{
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                    threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                    Instruction ins=(Instruction)this._else_;

                    Object theFinal= ins.c3d(ambit);
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                }


            }
        }
        return null;
    }



}
