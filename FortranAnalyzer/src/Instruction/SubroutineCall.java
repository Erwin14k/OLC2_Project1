package Instruction;
import java.util.ArrayList;
import java.util.Objects;

import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;

public class SubroutineCall extends Instruction{
    private String id;
    private  ArrayList<Expression> parametersId;
    public String line;
    public String column;

    public SubroutineCall(String id,ArrayList<Expression> parametersId,String line,String column){
        super(line, column);
        this.id=id.toUpperCase();
        this.parametersId=parametersId;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Subroutine sub = ambit.getSubroutine(this.id);
        if (sub != null) {
            //System.out.println(this.parametersId);
            //System.out.println(sub.parametersId);
            //System.out.printf(sub.decPar.toString());
            if (this.parametersId.size() == sub.parametersId.size()) {
                //System.out.println("mismo tamanio");
                Ambit newAmbit = new Ambit(ambit.getGlobal(),"Subroutine '"+this.id+"'");

                for (int i=0;i<this.parametersId.size();i++) {
                    Expression temp=this.parametersId.get(i);
                    Returnal val = temp.execute(ambit);
                    if(val.type.toString().equalsIgnoreCase(sub.decPar.get(i))){
                        System.out.println(sub.parametersId.get(i).toUpperCase());
                        if(val.value instanceof ArrayList<?>){
                            if(val.value.toString().contains(",")) {
                                //System.out.println("twooo");
                                ArrayList a = (ArrayList) val.value;
                                newAmbit.setVal(sub.parametersId.get(i).toUpperCase(), val.value, val.type, this.line, this.column);
                                newAmbit.newArrayOneDim(sub.parametersId.get(i).toUpperCase(), a, val.type, this.line, this.column);
                                newAmbit.sizeTwoDim(sub.parametersId.get(i).toUpperCase(), -1, -1);
                            }else{
                                ArrayList a = (ArrayList) val.value;
                                newAmbit.setVal(sub.parametersId.get(i).toUpperCase(), val.value, val.type, this.line, this.column);
                                newAmbit.newArrayOneDim(sub.parametersId.get(i).toUpperCase(), a, val.type, this.line, this.column);
                                newAmbit.sizeOneDim(sub.parametersId.get(i).toUpperCase(),-1);

                            }
                        }else{
                            newAmbit.setVal(sub.parametersId.get(i).toUpperCase(), val.value, val.type, this.line, this.column);
                        }

                    }else{
                        ErrorCollector errorHandler=ErrorCollector.getInstance();
                        errorHandler.errors.add(new Errors("Semantico","No se puede asignar un valor de tipo '"+val.type+"' al parametro '"+sub.parametersId.get(i)+"' , ya que es de tipo '"+sub.decPar.get(i)+"'",String.valueOf(this.line),String.valueOf(this.column)));
                    }
                }
                sub.statement.execute(newAmbit);

            } else {
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Cantidad incorrecta de parametros para la llamada de la Subrutina '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }
        } else {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se encontro la Subrutina '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        return true;
    }


    public Object c3d(Ambit ambit){
        return null;
    }
}
