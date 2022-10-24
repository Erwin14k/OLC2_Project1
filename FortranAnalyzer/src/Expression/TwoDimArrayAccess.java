package Expression;

import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;

public class TwoDimArrayAccess extends Expression{
    private String id;
    public int line;
    public int column;
    public Expression index1;

    public Expression index2;
    public TwoDimArrayAccess(String id, Object index1,Object index2,int line, int column){
        super(line,column);
        this.id=id.toUpperCase();
        this.index1= (Expression) index1;
        this.index2=(Expression)index2;
    }

    public Returnal execute(Ambit ambit) {
        Symbol value = ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        Returnal inde=this.index1.execute(ambit);
        Returnal inde2=this.index2.execute(ambit);

        if(value != null) {

            //System.out.println(obj+"!!!!!!");
            int theSize= ambit.getFirstIndexArray(this.id);

            int theSize2= ambit.getSecondIndexArray(this.id);
            //System.out.println(theSize+";;;;;;");
            //System.out.println(theSize2+";;;;;;");
            if(theSize==-1 && theSize2==-1){
                //System.out.println("todo es menos -1");
                ArrayList obj = (ArrayList) value.value;
                ArrayList obj2=(ArrayList) obj.get(Integer.parseInt(inde.value.toString())-1);
                boolean isNumeric0 =  obj2.get(Integer.parseInt(inde2.value.toString())-1).toString().matches("[+-]?\\d*");
                boolean isNumericD =  obj2.get(Integer.parseInt(inde2.value.toString())-1).toString().matches("[+-]?\\d*.\\d*");
                if(isNumeric0){
                    return new Returnal(obj2.get(Integer.parseInt(inde2.value.toString())-1),value.type);

                }else if(isNumericD){
                    return new Returnal(obj2.get(Integer.parseInt(inde2.value.toString())-1),value.type);
                } else{
                    Expression temp=(Expression) obj2.get(Integer.parseInt(inde2.value.toString())-1);
                    Returnal result=temp.execute(ambit);
                    return new Returnal(result.value,value.type);
                }

            }
            if((Integer.parseInt(inde.value.toString())-1>theSize)||(Integer.parseInt(inde2.value.toString())-1>theSize2)){
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Intentas acceder a una posicion fuera de los limites del array '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }else{
                ArrayList obj = (ArrayList) value.value;
                ArrayList obj2=(ArrayList) obj.get(Integer.parseInt(inde.value.toString())-1);
                boolean isNumeric0 =  obj2.get(Integer.parseInt(inde2.value.toString())-1).toString().matches("[+-]?\\d*");
                boolean isNumericD =  obj2.get(Integer.parseInt(inde2.value.toString())-1).toString().matches("[+-]?\\d*.\\d*");
                if(isNumeric0){
                    return new Returnal(obj2.get(Integer.parseInt(inde2.value.toString())-1),value.type);

                }else if(isNumericD){
                    return new Returnal(obj2.get(Integer.parseInt(inde2.value.toString())-1),value.type);
                } else{
                    Expression temp=(Expression) obj2.get(Integer.parseInt(inde2.value.toString())-1);
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
        Returnal inde=this.index1.c3d(ambit);
        Returnal inde2=this.index2.c3d(ambit);
        ArrayList<Object> t=new ArrayList<>();
        t.add(this.id);
        if(Integer.parseInt(inde.value.toString())-1==0  &&  Integer.parseInt(inde2.value.toString())-1==0){
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.id+"["+0+"];\n";
            t.add(0);
        }else if(Integer.parseInt(inde.value.toString())-1==0  &&  Integer.parseInt(inde2.value.toString())-1!=0){
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.id+"["+(Integer.parseInt(inde2.value.toString())-1)+"];\n";
            System.out.println((Integer.parseInt(inde2.value.toString()))-1);
            t.add((Integer.parseInt(inde2.value.toString()))-1);
        }else if(Integer.parseInt(inde.value.toString())-1!=0  &&  Integer.parseInt(inde2.value.toString())-1==0){
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.id+"["+(Integer.parseInt(inde.value.toString())-1)+"];\n";
            t.add((Integer.parseInt(inde.value.toString())-1));
        }else{
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.id+"["+(Integer.parseInt(inde.value.toString())-1)*(Integer.parseInt(inde.value.toString())-1)+"];\n";
            t.add((Integer.parseInt(inde.value.toString())-1)*(Integer.parseInt(inde.value.toString())-1));
        }

        return new Returnal(t,value.type);
    }
}
