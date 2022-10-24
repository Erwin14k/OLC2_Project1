package Instruction;

import Expression.*;
import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;

import java.util.ArrayList;

public class AllocateOne extends Instruction{
    public String id;
    public Expression size;
    public String line;
    public String column;

    public AllocateOne(String id,Object size,String line,String column){
        super(line,column);
        this.line=line;
        this.column=column;
        this.id=id.toUpperCase();
        this.size=(Expression)size;
    }

    public Object execute(Ambit ambit){
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal result=this.size.execute(ambit);
        int theActualSize=ambit.getOneDimSize(this.id);
        if(theActualSize!=-1){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Para poder usar la función 'Allocate' en el array '"+this.id+"', primero debe usarse la función 'Deallocate' para eliminar el tamaño actual",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        ArrayList<Object> values=new ArrayList<Object>();
        if(tempSymbol.type.getValue()==0){
            for(int i=0; i< Integer.parseInt(result.value.toString());i++){
                Literal num2=new Literal(0,LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                values.add(num2);
            }
            ambit.updateSizeOneDim(this.id,Integer.parseInt(result.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }else if(tempSymbol.type.getValue()==1){
            for(int i=0; i< Integer.parseInt(result.value.toString());i++){
                Literal num2=new Literal(0.0000000,LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                values.add(num2);
            }
            ambit.updateSizeOneDim(this.id,Integer.parseInt(result.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }else if(tempSymbol.type.getValue()==2){
            for(int i=0; i< Integer.parseInt(result.value.toString());i++){
                Literal num2=new Literal("",LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                values.add(num2);
            }
            ambit.updateSizeOneDim(this.id,Integer.parseInt(result.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }

        return true;
    }
    public Object c3d(Ambit ambit){
        return null;
    }
}
