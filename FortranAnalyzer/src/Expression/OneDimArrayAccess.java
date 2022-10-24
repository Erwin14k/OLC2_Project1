package Expression;

import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OneDimArrayAccess extends Expression{

    private String id;
    public int line;
    public int column;
    public Expression index;

    public OneDimArrayAccess(String id, Object index,int line, int column){
        super(line,column);
        this.id=id.toUpperCase();
        this.index= (Expression) index;
        this.line=line;
        this.column=column;
    }

    public Returnal execute(Ambit ambit) {
        //System.out.println("queremos entrar");
        Symbol value = ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal inde=this.index.execute(ambit);
        //System.out.println(value);
        if(value != null) {
            int theSize= ambit.getOneDimSize(this.id);
            if(theSize==-1){
                //System.out.println("todo es menos -1");
                ArrayList obj = (ArrayList) value.value;
                boolean isNumeric0 =  obj.get(Integer.parseInt(inde.value.toString())-1).toString().matches("[+-]?\\d*");
                boolean isNumericD =  obj.get(Integer.parseInt(inde.value.toString())-1).toString().matches("[+-]?\\d*.\\d*");
                if(isNumeric0){
                    return new Returnal(obj.get(Integer.parseInt(inde.value.toString())-1),value.type);

                }else if(isNumericD){
                    return new Returnal(obj.get(Integer.parseInt(inde.value.toString())-1),value.type);
                } else{
                    Expression temp=(Expression) obj.get(Integer.parseInt(inde.value.toString())-1);
                    Returnal result=temp.execute(ambit);
                    return new Returnal(result.value,value.type);
                }

            }

            //System.out.println(obj+"!!!!!!");

            if(Integer.parseInt(inde.value.toString())-1>theSize){
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Intentas acceder a una posicion fuera de los limites del array '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }else{
                ArrayList obj = (ArrayList) value.value;
                boolean isNumeric0 =  obj.get(Integer.parseInt(inde.value.toString())-1).toString().matches("[+-]?\\d*");
                boolean isNumericD =  obj.get(Integer.parseInt(inde.value.toString())-1).toString().matches("[+-]?\\d*.\\d*");
                if(isNumeric0){
                    return new Returnal(obj.get(Integer.parseInt(inde.value.toString())-1),value.type);

                }else if(isNumericD){
                    return new Returnal(obj.get(Integer.parseInt(inde.value.toString())-1),value.type);
                } else{
                    Expression temp=(Expression) obj.get(Integer.parseInt(inde.value.toString())-1);
                    Returnal result=temp.execute(ambit);
                    return new Returnal(result.value,value.type);
                }

            }


        }else {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se encontro el array '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }


    }

    public Returnal c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Symbol value = ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal inde=this.index.c3d(ambit);
        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.id+"["+(Integer.parseInt(inde.value.toString())-1)+"];\n";
        ArrayList<Object> t=new ArrayList<>();
        t.add(this.id);
        t.add((Integer.parseInt(inde.value.toString())-1));
        return new Returnal(t,value.type);
    }
}
