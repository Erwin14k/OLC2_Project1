package Instruction;

import Ambit.*;
import Expression.*;
import ThreeWayCode.*;
import java.util.ArrayList;
import java.util.Objects;


public class Declaration extends Instruction{
    private String id;
    public String line;
    public String column;
    private Expression value;
    public Declaration(String id, Object value, String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.id=id.toUpperCase();
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Returnal val = this.value.execute(ambit);
        ambit.setVal(this.id, val.value, val.type, this.line, this.column);
        return true;
    }

    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Returnal val = this.value.c3d(ambit);
        if(Objects.equals(val.type.toString(), "INTEGER")){
            String integerDeclaration="";
            integerDeclaration+="/*Declaracion de la variable integer '"+this.id+"', sin asignacion de valor*/\n";
            integerDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=0;\n";
            integerDeclaration+="/*============================================================*/\n\n";
            ArrayList<Object> data=new ArrayList<>();
            data.add(threeWayCodeHandler.index);
            data.add(0);
            threeWayCodeHandler.add(this.id,data);
            threeWayCodeHandler.mainCode+=integerDeclaration;
            return true;
        }else if(Objects.equals(val.type.toString(), "CHARACTER")){

            String charDeclaration="";
            charDeclaration+="/*Declaracion de la variable character '"+this.id+"', sin asignacion de valor*/\n";
            charDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=-1;\n";
            charDeclaration+="/*============================================================*/\n\n";
            ArrayList<Object>data4=new ArrayList<>();
            data4.add(threeWayCodeHandler.index);
            data4.add(-1);
            threeWayCodeHandler.add(this.id,data4);
            threeWayCodeHandler.mainCode+=charDeclaration;
            return true;

        }else if(Objects.equals(val.type.toString(), "LOGICAL")){
            String logicalDeclaration="";
            logicalDeclaration+="/*Declaracion de la logical '"+this.id+"', sin asignacion de valor*/\n";
            logicalDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=0;\n";
            logicalDeclaration+="/*===========================================================*/\n\n";
            ArrayList<Object>data3=new ArrayList<>();
            data3.add(threeWayCodeHandler.index);
            data3.add(0);
            threeWayCodeHandler.add(this.id,data3);
            threeWayCodeHandler.mainCode+=logicalDeclaration;
            return true;

        }else if(Objects.equals(val.type.toString(), "COMPLEX")){
            String complexDeclaration="";
            complexDeclaration+="/*Declaracion de una variable complex '"+this.id+", sin asignacion de valor*/\n";
            complexDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=-1;\n";
            complexDeclaration+="/*============================================================*/\n\n";
            ArrayList<Object>data5=new ArrayList<>();
            data5.add(threeWayCodeHandler.index);
            data5.add(-1);
            threeWayCodeHandler.add(this.id,data5);
            threeWayCodeHandler.mainCode+=complexDeclaration;
            return true;
        }else if(Objects.equals(val.type.toString(), "REAL")){
            String realDeclaration="";
            realDeclaration+="/*Declaracion de la variable real '"+this.id+"', sin asignacion de valor*/\n";
            realDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=0.00000000;\n";
            realDeclaration+="/*============================================================*/\n\n";
            ArrayList<Object>data2=new ArrayList<Object>();
            data2.add(threeWayCodeHandler.index);
            data2.add(0.00000000);
            threeWayCodeHandler.add(this.id,data2);
            threeWayCodeHandler.mainCode+=realDeclaration;
            return true;

        }




        return null;
    }
}
