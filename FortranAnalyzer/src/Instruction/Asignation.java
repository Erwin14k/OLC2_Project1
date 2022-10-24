package Instruction;
import Ambit.*;
import Expression.*;
import Extra.*;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Objects;

public class Asignation extends Instruction{
    private String id;
    public String line;
    public String column;
    private Expression value;
    public Asignation(String id, Object value, String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.id=id.toUpperCase();
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Returnal val = this.value.execute(ambit);
        //System.out.println(val.value.toString()+"iiiiii");
        //System.out.println(this.id+"uuuu");
        Symbol temp=ambit.getVal(this.id,this.line,this.column);
        if (val!=null) {
            if (Objects.equals(val.type.toString(), temp.type.toString())) {
                ambit.update(this.id, val.value, this.line, this.column);
                return true;
            } else {
                ErrorCollector errorHandler = ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico", "No se puede asignar un valor de tipo '" + val.type.toString() + "' a la variable '" + this.id + "' de tipo '" + temp.type.toString() + "'", String.valueOf(line), String.valueOf(column)));
                return null;
            }
        }else{
            return null;
        }

    }


    public Object c3d(Ambit ambit){
        //System.out.println(this.id+"---------");
        System.out.println(this.id+"****");

        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        //System.out.println(this.value);
        Returnal val = this.value.c3d(ambit);
        //System.out.println(this.value);
        //System.out.println(val.type+"......"+val.value.toString());
        Object var= threeWayCodeHandler.getVariableData(this.id);
        ArrayList oldData=(ArrayList)var;
        ArrayList<Object> newData=new ArrayList<>();
        newData.add(oldData.get(0) );
        threeWayCodeHandler.isActive=false;
        //String key=threeWayCodeHandler.lastTemporal();

        if(Objects.equals(val.type.toString(), "INTEGER")){
            threeWayCodeHandler.mainCode+="/* ==== Asignacion a la variable '"+this.id+"' ==== */\n";
            if(this.value instanceof Literal){
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"] = "+val.value.toString()+";\n";
            }else{
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"] = "+threeWayCodeHandler.lastTemporal()+";\n";
            }
            threeWayCodeHandler.mainCode+="/*  Fin de asignacion a la variable '"+this.id+"'  */\n";
            newData.add(Integer.parseInt(val.value.toString()));
            threeWayCodeHandler.add(this.id,newData);
            return true;
        }else if(Objects.equals(val.type.toString(), "REAL")){
            threeWayCodeHandler.mainCode+="/* ==== Asignacion a la variable '"+this.id+"' ==== */\n";
            if(this.value instanceof Literal){
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"] = "+val.value.toString()+";\n";
            }else{
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"] = "+threeWayCodeHandler.lastTemporal()+";\n";
            }
            threeWayCodeHandler.mainCode+="/*  Fin de asignacion a la variable '"+this.id+"'  */\n";
            newData.add(Double.parseDouble(val.value.toString()));
            threeWayCodeHandler.add(this.id,newData);
            return true;
        }else if(Objects.equals(val.type.toString(), "LOGICAL")){
            if(Objects.equals(val.value.toString(), "T")){
                threeWayCodeHandler.mainCode+="/* ==== Asignacion a la variable '"+this.id+"' ==== */\n";
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"]=1;\n";
                String temporal="";
                temporal+=threeWayCodeHandler.generateLabel()+":\n";
                temporal+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"]=0;\n";
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                threeWayCodeHandler.mainCode+=temporal;
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                threeWayCodeHandler.mainCode+="/*  Fin de asignacion a la variable '"+this.id+"'  */\n";
                newData.add(1);
                threeWayCodeHandler.add(this.id,newData);
                return true;
            }else{
                threeWayCodeHandler.mainCode+="/* ==== Asignacion a la variable '"+this.id+"' ==== */\n";
                String temp= threeWayCodeHandler.generateLabel()+":\n";
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                String temp2=threeWayCodeHandler.lastLabel()+":\n";
                threeWayCodeHandler.mainCode+=temp;
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"]=1;\n";
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                threeWayCodeHandler.mainCode+=temp2;
                threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"]=0;\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                threeWayCodeHandler.mainCode+="/*  Fin de asignacion a la variable '"+this.id+"'  */\n";
                newData.add(0);
                threeWayCodeHandler.add(this.id,newData);
                return true;
            }
        }else if(Objects.equals(val.type.toString(), "CHARACTER")){
            char c= val.value.toString().charAt(0);
            threeWayCodeHandler.mainCode+="/* ==== Asignacion a la variable '"+this.id+"' ==== */\n";
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+(int)c+";\n";
            threeWayCodeHandler.mainCode+="STACK[(int)"+Integer.parseInt(oldData.get(0).toString())+"]="+ threeWayCodeHandler.lastTemporal()+";\n";
            threeWayCodeHandler.mainCode+="/*  Fin de asignacion a la variable '"+this.id+"'  */\n";
            newData.add((int) c);
            threeWayCodeHandler.add(this.id,newData);
            return true;



        }

        return true;
    }
}
