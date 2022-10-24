package Instruction;

import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;

import java.util.ArrayList;
import java.util.Objects;
import ThreeWayCode.*;

public class Declaration2 extends Instruction{
    private String id;
    public String line;
    public String column;
    private Expression value;
    public String type;
    public Declaration2(String id, Object value, String type,String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.id=id.toUpperCase();
        this.line=line;
        this.column=column;
        this.type=type;
    }

    public Object execute(Ambit ambit) {
        Returnal val = this.value.execute(ambit);
        if(val!=null){
            if(Objects.equals(val.type.toString(), this.type.toUpperCase())){
                if(val.type.toString().equals("CHARACTER")){
                    if(val.value.toString().length()>1){
                        ErrorCollector errorHandler=ErrorCollector.getInstance();
                        errorHandler.errors.add(new Errors("Semantico","No se puede asignar mas de un caracter a la variable de tipo character '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                        return null;

                    }else{
                        ambit.setVal(this.id, val.value, val.type, this.line, this.column);
                        return true;
                    }
                }else{
                    ambit.setVal(this.id, val.value, val.type, this.line, this.column);
                    return true;
                }

            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede  asignar un valor de tipo '"+val.type+"' a la variable '"+this.id+"' de tipo '"+this.type.toUpperCase()+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }
        }else{
            return null;
        }
    }

    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Returnal val =this.value.c3d(ambit);
        threeWayCodeHandler.isActive=false;
        if(Objects.equals(val.type.toString(), "INTEGER")){
            String integerDeclaration="";
            integerDeclaration+="/*Declaracion de la variable integer '"+this.id+"', con asignacion de valor*/\n";
            integerDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]="+val.value.toString()+";\n";
            integerDeclaration+="/*============================================================*/\n\n";
            ArrayList<Object> data=new ArrayList<>();
            data.add(threeWayCodeHandler.index );
            data.add(Integer.parseInt(val.value.toString()));
            threeWayCodeHandler.add(this.id,data);
            threeWayCodeHandler.mainCode+=integerDeclaration;
            return true;

        }else if(Objects.equals(val.type.toString(), "REAL")){
            String realDeclaration="";
            realDeclaration+="/*Declaracion de la variable real '"+this.id+"', con asignacion de valor*/\n";
            realDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]="+val.value.toString()+";\n";
            realDeclaration+="/*=========================================================*/\n\n";
            ArrayList<Object>data1=new ArrayList<>();
            data1.add(threeWayCodeHandler.index );
            data1.add(Double.parseDouble(val.value.toString()));
            threeWayCodeHandler.add(this.id,data1);
            threeWayCodeHandler.mainCode+=realDeclaration;
            return true;
        }else if(Objects.equals(val.type.toString(), "LOGICAL")){
            if(Objects.equals(val.value.toString(), "T")){
                String logicalDeclaration="";
                logicalDeclaration+="/* Declaracion de la variable logical '"+this.id+"', con valor true */\n";
                logicalDeclaration+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                logicalDeclaration+=threeWayCodeHandler.lastLabel()+":\n";
                logicalDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=1;\n";
                String temporal="";
                temporal+=threeWayCodeHandler.generateLabel()+":\n";
                temporal+="STACK[(int)"+threeWayCodeHandler.lastIndex()+"]=0;\n";
                logicalDeclaration+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                logicalDeclaration+=temporal;
                logicalDeclaration+=threeWayCodeHandler.lastLabel()+":\n";
                logicalDeclaration+="/*=====================================================*/\n\n";
                ArrayList<Object>data2=new ArrayList<>();
                data2.add(threeWayCodeHandler.index );
                data2.add(1);
                threeWayCodeHandler.add(this.id,data2);
                threeWayCodeHandler.mainCode+=logicalDeclaration;

            }else{
                String logicalDeclaration="";
                logicalDeclaration+="/* Declaracion de la variable logical '"+this.id+"', con valor false */\n";
                String temp= threeWayCodeHandler.generateLabel()+":\n";
                logicalDeclaration+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                String temp2=threeWayCodeHandler.lastLabel()+":\n";
                logicalDeclaration+=temp;
                logicalDeclaration+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]=1;\n";
                logicalDeclaration+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                logicalDeclaration+=temp2;
                logicalDeclaration+="STACK[(int)"+threeWayCodeHandler.lastIndex()+"]=0;\n";
                logicalDeclaration+=threeWayCodeHandler.lastLabel()+":\n";
                logicalDeclaration+="/*=====================================================*/\n\n";
                ArrayList<Object>data2=new ArrayList<>();
                data2.add(threeWayCodeHandler.index );
                data2.add(0);
                threeWayCodeHandler.add(this.id,data2);
                threeWayCodeHandler.mainCode+=logicalDeclaration;
            }
            return true;
        }else if(Objects.equals(val.type.toString(), "CHARACTER")){
            char c= val.value.toString().charAt(0);
            String charDec;
            charDec="/* Declaracion de la variable character '"+this.id+"', con asignacion de valor */\n";
            threeWayCodeHandler.mainCode+=charDec;
            threeWayCodeHandler.mainCode+="STACK[(int)"+threeWayCodeHandler.getNextIndexInStack()+"]="+ (int)c+";\n";
            threeWayCodeHandler.mainCode+="/*============================================================*/\n\n";
            ArrayList<Object>data2=new ArrayList<>();
            data2.add(threeWayCodeHandler.index );
            data2.add((int)c);
            threeWayCodeHandler.add(this.id,data2);
            return true;
        }
        return true;
    }
}
