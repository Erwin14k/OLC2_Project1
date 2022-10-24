package Instruction;

import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.Objects;

public class OneDimArrayAssig extends Instruction{
    private String id;
    public String line;
    public String column;
    private Expression value;
    public Expression index;
    public OneDimArrayAssig(String id, Object value, Object index,String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.id=id.toUpperCase();
        this.index= (Expression)index;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal val = this.value.execute(ambit);
        Returnal val2 = this.index.execute(ambit);
        int theSize=ambit.getOneDimSize(this.id);
        if(Integer.parseInt(val2.value.toString())>theSize ){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se puede asignar un valor en la posicion '"+val2.value.toString()+"' del array '"+this.id+"', ya que es una posicion fuera del limite",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        if(tempSymbol.type==val.type){
            if(Objects.equals(tempSymbol.type.toString(), "CHARACTER")){
                if(val.value.toString().length()>1){
                    ErrorCollector errorHandler=ErrorCollector.getInstance();
                    errorHandler.errors.add(new Errors("Semantico","No se puede asignar la cadena '"+val.value.toString()+"' al array '"+this.id+"', que es de tipo "+tempSymbol.type.toString()+"'",String.valueOf(this.line),String.valueOf(this.column)));
                    return null;
                }else{
                    ambit.updateOneDimArray(this.id, val.value,Integer.parseInt(val2.value.toString()));
                }
            }else{
                ambit.updateOneDimArray(this.id, val.value,Integer.parseInt(val2.value.toString()));
            }

        }else{
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se puede asignar un valor de tipo '"+val.type+" ' a un array de tipo '"+tempSymbol.type+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }

        return true;
    }


    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Returnal val = this.value.c3d(ambit);
        Returnal val2 = this.index.c3d(ambit);
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        if(Objects.equals(tempSymbol.type.toString(), "INTEGER")){
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(val2.value.toString())-1) +"]="+val.value.toString()+";\n";
        }else if(Objects.equals(tempSymbol.type.toString(), "REAL")){
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(val2.value.toString())-1) +"]="+val.value.toString()+";\n";
        }else if(Objects.equals(tempSymbol.type.toString(), "CHARACTER")){
            char c= val.value.toString().charAt(0);
            threeWayCodeHandler.mainCode+=this.id+"["+(Integer.parseInt(val2.value.toString())-1) +"]="+(int)c+";\n";

        }
        return true;
    }
}
