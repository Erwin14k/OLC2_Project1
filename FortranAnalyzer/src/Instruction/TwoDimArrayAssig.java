package Instruction;

import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.Objects;

public class TwoDimArrayAssig extends Instruction{
    private String id;
    public String line;
    public String column;
    private Expression value;
    public Expression index1;
    public Expression index2;

    public TwoDimArrayAssig(String id, Object value, Object index1,Object index2,String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.id=id.toUpperCase();
        this.index1= (Expression)index1;
        this.index2= (Expression)index2;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        //System.out.println(tempSymbol+"===========");
        Returnal val = this.value.execute(ambit);
        Returnal index1 = this.index1.execute(ambit);
        Returnal index2 = this.index2.execute(ambit);
        //System.out.println(tempSymbol.type+"  "+val.type);
        if(tempSymbol.type==val.type){
            ambit.updateTwoDimArray(this.id, val.value,Integer.parseInt(index1.value.toString()),Integer.parseInt(index2.value.toString()));
        }else{
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se puede colocar un valor de tipo '"+val.type+"' a un array de tipo '"+tempSymbol.type+"'",String.valueOf(this.line),String.valueOf(this.column)));
        }

        return true;
    }
    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal index1 = this.index1.c3d(ambit);
        Returnal index2 = this.index2.c3d(ambit);
        Returnal val = this.value.c3d(ambit);
        if(Objects.equals(tempSymbol.type.toString(), "INTEGER")){
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(index1.value.toString())*Integer.parseInt(index2.value.toString())-1) +"]="+val.value.toString()+";\n";
        }else if(Objects.equals(tempSymbol.type.toString(), "REAL")){
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(index1.value.toString())*Integer.parseInt(index2.value.toString())-1) +"]="+val.value.toString()+";\n";
        }else if(Objects.equals(tempSymbol.type.toString(), "CHARACTER")){
            char c= val.value.toString().charAt(0);
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(index1.value.toString())*Integer.parseInt(index2.value.toString())-1) +"]="+(int)c+";\n";
        }
        return true;
    }
}
