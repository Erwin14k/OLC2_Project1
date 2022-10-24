package Instruction;

import Ambit.*;
import Expression.*;
import Extra.*;


import java.util.ArrayList;

public class AllocateTwo extends Instruction{
    public String id;
    public Expression size1;
    public Expression size2;
    public String line;
    public String column;

    public AllocateTwo(String id,Object size1,Object size2,String line,String column){
        super(line,column);
        this.line=line;
        this.column=column;
        this.id=id.toUpperCase();
        this.size1=(Expression)size1;
        this.size2=(Expression)size2;
    }

    public Object execute(Ambit ambit){
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal result=this.size1.execute(ambit);
        Returnal result2=this.size2.execute(ambit);
        int theSize= ambit.getFirstIndexArray(this.id);
        int theSize2= ambit.getSecondIndexArray(this.id);
        //System.out.println(theSize+"---"+theSize2);
        if(theSize!=-1 && theSize2!=-1){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Para poder usar la función 'Allocate' en el array '"+this.id+"', primero debe usarse la función 'Deallocate' para eliminar el tamaño actual",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        ArrayList<Object> values=new ArrayList<Object>();
        if(tempSymbol.type.getValue()==0){
            for(int i=0;i<Integer.parseInt(result.value.toString());i++){
                ArrayList<Object> tempList=new ArrayList<>();
                for(int j=0;j<Integer.parseInt(result2.value.toString());j++){
                    Literal num2=new Literal(0,LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                    tempList.add(num2);
                }
                values.add(tempList);
            }
            ambit.updatesizeTwoDim(this.id,Integer.parseInt(result.value.toString()),Integer.parseInt(result2.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }else if(tempSymbol.type.getValue()==1){
            for(int i=0;i<Integer.parseInt(result.value.toString());i++){
                ArrayList<Object> tempList=new ArrayList<>();
                for(int j=0;j<Integer.parseInt(result2.value.toString());j++){
                    Literal num2=new Literal(0.000000,LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                    tempList.add(num2);
                }
                values.add(tempList);
            }
            ambit.updatesizeTwoDim(this.id,Integer.parseInt(result.value.toString()),Integer.parseInt(result2.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }else if(tempSymbol.type.getValue()==2){
            for(int i=0;i<Integer.parseInt(result.value.toString());i++){
                ArrayList<Object> tempList=new ArrayList<>();
                for(int j=0;j<Integer.parseInt(result2.value.toString());j++){
                    Literal num2=new Literal("",LiteralType.INTEGER,Integer.parseInt(this.line) ,Integer.parseInt(this.column));
                    tempList.add(num2);
                }
                values.add(tempList);
            }
            ambit.updatesizeTwoDim(this.id,Integer.parseInt(result.value.toString()),Integer.parseInt(result2.value.toString()));
            ambit.updateOneDimArrayValues(this.id,values);
        }

        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
