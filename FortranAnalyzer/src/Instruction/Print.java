package Instruction;

import Ambit.Ambit;
import Expression.*;
import Extra.ErrorCollector;
import Interpreter.Interpreter;
import ThreeWayCode.*;

import java.util.ArrayList;
import java.util.Objects;

public class Print extends Instruction{
    private ArrayList<Object> values;
    public Print(ArrayList<Object> values,String line, String column){
        super(line,column);
        this.values=values;
    }


    public Object  execute(Ambit ambit){
        Interpreter interpreterHandler=Interpreter.getInstance();
        for (Object value : this.values) {

            Expression temp = (Expression) value;
            Returnal val = temp.execute(ambit);
            if(val!=null){

                interpreterHandler.console += val.value;

            }
        }
        interpreterHandler.console+="\n";
        return true;
    }

    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        for (Object value : this.values) {

            Expression temp = (Expression) value;
            //System.out.println(temp);
            //System.out.println(temp);
            Returnal val = temp.c3d(ambit);

            if(val!=null){
                if(Objects.equals(val.type.toString(), "INTEGER")){
                    threeWayCodeHandler.mainCode+="/*======Impresion De Integer======*/\n\n";
                    if(temp instanceof Literal){
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+val.value.toString()+");\n";
                        threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        threeWayCodeHandler.isActive=false;

                    }else{
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+threeWayCodeHandler.lastTemporal()+");\n";
                        threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        threeWayCodeHandler.isActive=false;
                    }

                }else if(Objects.equals(val.type.toString(), "REAL")){
                    threeWayCodeHandler.mainCode+="/*======Impresion De Real======*/\n\n";
                    if(temp instanceof Literal){
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+val.value.toString()+");\n";
                        threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        threeWayCodeHandler.isActive=false;

                    }else{
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+threeWayCodeHandler.lastTemporal()+");\n";
                        threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        threeWayCodeHandler.isActive=false;
                    }


                }else if(Objects.equals(val.type.toString(), "CHARACTER")){
                    //System.out.println(val.value.toString());
                    if(val.value.toString().length()>1 && !(temp instanceof TwoDimArrayAccess)){
                        System.out.println(temp+"--");
                        //System.out.println("mayor"+val.value.toString());
                        String principal="";
                        String aux=threeWayCodeHandler.generateTemporal();
                        principal+=aux+"="+"H;\n";
                        for (char i : val.value.toString().toCharArray()) {
                            principal+="HEAP[(int)H] = " + (int)i + ";\n";
                            principal+="H=H+1;\n";
                        }
                        threeWayCodeHandler.mainCode+="/*======Impresion De String======*/\n\n";
                        threeWayCodeHandler.mainCode+=principal;
                        threeWayCodeHandler.mainCode+="HEAP[(int)H]=-1;\n";
                        threeWayCodeHandler.mainCode+="H=H+1;\n";
                        threeWayCodeHandler.mainCode+="P="+threeWayCodeHandler.lastTemporal()+";\n";
                        threeWayCodeHandler.mainCode+="printString();\n";
                        threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                    }else{
                        System.out.println(temp+"::");
                        if(temp instanceof Literal){
                            threeWayCodeHandler.mainCode+="/*======Impresion De Character======*/\n\n";
                            char c= val.value.toString().charAt(0);
                            threeWayCodeHandler.mainCode+="printChar"+threeWayCodeHandler.charCounter+"();\n";
                            //System.out.println(c.get(1).toString()+"____");
                            threeWayCodeHandler.printChar(String.valueOf((int)c));
                            threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";

                        }else if(temp instanceof Access){
                            threeWayCodeHandler.mainCode+="/*======Impresion De Character======*/\n\n";
                            ArrayList c=(ArrayList)threeWayCodeHandler.getVariableData(threeWayCodeHandler.tempCharId);
                            threeWayCodeHandler.mainCode+="printChar"+threeWayCodeHandler.charCounter+"();\n";
                            //System.out.println(c.get(1).toString()+"____");
                            threeWayCodeHandler.printChar(c.get(1).toString());
                            threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        }else{
                            System.out.println("gggg");
                            threeWayCodeHandler.mainCode+="/*======Impresion De Characterss======*/\n\n";
                            ArrayList obj = (ArrayList) val.value;
                            //printf(\"%c\", (char)"+theChar+");
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+obj.get(0).toString()+"["+obj.get(1)+"];\n";
                            threeWayCodeHandler.mainCode+="printf(\"%c\", (char)"+threeWayCodeHandler.lastTemporal()+");\n";
                            //threeWayCodeHandler.mainCode+="printChar"+threeWayCodeHandler.charCounter+"();\n";
                            threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";
                        }


                    }



                }else if(Objects.equals(val.type.toString(), "LOGICAL")){

                    if(temp instanceof Relational){
                        Relational r= (Relational)temp;
                        if(r.type==RelationalType.AND || r.type==RelationalType.OR  || r.type==RelationalType.NOT){
                            threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+threeWayCodeHandler.resultOfLogical+");\n";
                            continue;
                        }

                    }

                    threeWayCodeHandler.mainCode+="/*======Impresion De Logical======*/\n\n";
                    if(Objects.equals(val.value.toString(), "T")){
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+threeWayCodeHandler.lastTemporal()+");\n";
                    }else{
                        threeWayCodeHandler.mainCode+="printf(\"%f\", (float)"+threeWayCodeHandler.lastTemporal()+");\n";
                    }
                    threeWayCodeHandler.mainCode+="/*===========================*/\n\n\n";

                }


            }
        }
        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

        return true;
    }


}


