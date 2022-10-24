package Expression;

import Ambit.Ambit;
import Extra.ErrorCollector;
import Extra.Errors;
import Instruction.Function;

import java.util.ArrayList;
import java.util.Objects;

public class FunctionCallExpr extends Expression{
    public String id;
    public ArrayList<Expression> parametersId;
    public int line;
    public int column;


    public FunctionCallExpr(String id,ArrayList<Expression> parametersId,int line,int column){
        super(line, column);
        this.id=id.toUpperCase();
        this.parametersId=parametersId;
        this.line=line;
        this.column=column;
    }

    public Returnal execute(Ambit ambit) {
        //System.out.println(this.parametersId.size());
        Function func = ambit.getFunction(this.id);
        //System.out.println(this.parametersId);
        //System.out.println(func.decPar);
        if (func != null) {
            if (this.parametersId.size() == func.parametersId.size()) {
                //System.out.println("mismo tamaño");
                Ambit newAmbit = new Ambit(ambit.getGlobal(),"Function '"+this.id+"'");
                if(this.parametersId.size()>0){
                    for (int i=0;i<this.parametersId.size();i++) {
                        Expression temp=this.parametersId.get(i);
                        Returnal val = temp.execute(ambit);
                        if(val.type.toString().equalsIgnoreCase(func.decPar.get(i))){
                            if(val.value instanceof ArrayList<?>){
                                if(val.value.toString().contains("],")) {
                                    //System.out.println("twooo");
                                    ArrayList a = (ArrayList) val.value;
                                    newAmbit.setVal(func.parametersId.get(i).toUpperCase(), val.value, val.type, String.valueOf(this.line) , String.valueOf(this.column));
                                    newAmbit.newArrayOneDim(func.parametersId.get(i).toUpperCase(), a, val.type, String.valueOf(this.line) , String.valueOf(this.column));
                                    newAmbit.sizeTwoDim(func.parametersId.get(i).toUpperCase(), -1, -1);
                                }else{
                                    ArrayList a = (ArrayList) val.value;
                                    newAmbit.setVal(func.parametersId.get(i).toUpperCase(), val.value, val.type, String.valueOf(this.line) , String.valueOf(this.column));
                                    newAmbit.newArrayOneDim(func.parametersId.get(i).toUpperCase(), a, val.type, String.valueOf(this.line) , String.valueOf(this.column));
                                    newAmbit.sizeOneDim(func.parametersId.get(i).toUpperCase(),-1);

                                }
                            }else{
                                newAmbit.setVal(func.parametersId.get(i).toUpperCase() ,val.value,val.type,String.valueOf(this.line) ,String.valueOf(this.column));
                            }
                        }else{
                            ErrorCollector errorHandler=ErrorCollector.getInstance();
                            errorHandler.errors.add(new Errors("Semantico","No se puede asignar un valor de tipo '"+val.type+"' al parametro '"+func.parametersId.get(i)+"' , ya que es de tipo '"+func.decPar.get(i)+"'",String.valueOf(this.line),String.valueOf(this.column)));
                        }

                    }

                }


                //System.out.println(func.decPar.get(this.parametersId.size()-1));
                //System.out.println("sssss");
                //System.out.println(func.decPar.get(this.parametersId.size())+"----");
                if(Objects.equals(func.decPar.get(this.parametersId.size()), "integer")){
                    //System.out.println("sisisisis");

                    newAmbit.setVal(func.returnId.toUpperCase() ,0,ReturnType.INTEGER,String.valueOf(this.line) ,String.valueOf(this.column));

                }else if(Objects.equals(func.decPar.get(this.parametersId.size()), "real")){

                    //System.out.println("siuuu");
                    newAmbit.setVal(func.returnId ,0.00000000,ReturnType.REAL,String.valueOf(this.line) ,String.valueOf(this.column));

                }else if(Objects.equals(func.decPar.get(this.parametersId.size()), "logical")){

                    newAmbit.setVal(func.returnId ,"F",ReturnType.LOGICAL,String.valueOf(this.line) ,String.valueOf(this.column));

                }else if(Objects.equals(func.decPar.get(this.parametersId.size()), "character")){

                    newAmbit.setVal(func.returnId ,"",ReturnType.CHARACTER,String.valueOf(this.line) ,String.valueOf(this.column));

                }

                //System.out.println("siuuu");
                func.statement.execute(newAmbit);
                //System.out.println(newAmbit.getVal(func.returnId, String.valueOf(this.line) ,String.valueOf(this.column)).type+"________");

                return new Returnal(newAmbit.getVal(func.returnId.toUpperCase(), String.valueOf(this.line) ,String.valueOf(this.column)).value,newAmbit.getVal(func.returnId, String.valueOf(this.line) ,String.valueOf(this.column)).type);
            } else {
                //System.out.println("oooo");
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Cantidad incorrecta de parametros para la llamada de la funcion '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }
        } else {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se encontro la funcion '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
    }

    public Returnal c3d(Ambit ambit){
        return null;
    }
}
