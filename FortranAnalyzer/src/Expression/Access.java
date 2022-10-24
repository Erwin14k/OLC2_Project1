package Expression;

import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.security.spec.ECParameterSpec;
import java.util.ArrayList;

public class Access extends Expression{
    private String id;
    public int line;
    public int column;

    public Access(String id, int line, int column){
        super(line,column);
        this.id=id.toUpperCase();
        this.line=line;
        this.column=column;
    }



        public Returnal execute(Ambit ambit) {
            Symbol value = ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));

            if(value != null) {
                if(!ambit.existOneDimArray(this.id,String.valueOf(this.line) ,String.valueOf(this.column)) && !ambit.existTwoDimArray(this.id,String.valueOf(this.line) ,String.valueOf(this.column))){
                    return new Returnal(value.value,value.type);
                }else if(ambit.existOneDimArray(this.id,String.valueOf(this.line) ,String.valueOf(this.column))){
                    ArrayList temp=(ArrayList)value.value;
                    ArrayList<Object> result=new ArrayList<>();
                    for(int i=0; i<temp.size();i++){
                        if(temp.get(i) instanceof Expression){
                            Expression e= (Expression) temp.get(i);
                            Returnal r=e.execute(ambit);
                            result.add(r.value.toString());
                        }else{
                            result.add(temp.get(i).toString());
                        }

                    }
                    return new Returnal(result,value.type);
                }else{
                    ArrayList temp=(ArrayList)value.value;
                    ArrayList<Object> result=new ArrayList<>();
                    //System.out.println(temp);
                    for(int i=0; i<temp.size();i++){
                        ArrayList temp2=(ArrayList)temp.get(i);
                        ArrayList<Object> t=new ArrayList<>();
                        //System.out.println(temp2);
                        for(int j=0; j<temp2.size();j++){
                            //System.out.println(temp2.get(j)+"______");
                            if(temp2.get(j) instanceof Expression){
                                Expression e= (Expression)temp2.get(j);
                                Returnal r=e.execute(ambit);
                                t.add(r.value.toString());
                            }else{
                                t.add(temp2.get(j).toString());
                            }

                        }
                        result.add(t);

                    }

                    return new Returnal(result,value.type);
                }

            }else {
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se encontró la variable '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }

        }

        public Returnal c3d(Ambit ambit){
            ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
            Symbol value = ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
            System.out.println(this.id);
            Object a=threeWayCodeHandler.getVariableData(this.id);
            ArrayList data=(ArrayList)a;
            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=STACK[(int)"+data.get(0).toString()+"];\n";
            threeWayCodeHandler.tempCharId=this.id;
            return new Returnal(data.get(1).toString(),value.type);

        }
}
