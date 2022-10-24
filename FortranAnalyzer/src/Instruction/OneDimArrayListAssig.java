package Instruction;

import Ambit.*;
import Expression.*;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Objects;

public class OneDimArrayListAssig extends Instruction{
    private String id;
    public String line;
    public String column;
    public ArrayList<Expression> values;

    public OneDimArrayListAssig(String id, ArrayList<Expression> values , String line, String column){
        super(line, column);
        this.values=values;
        this.id=id.toUpperCase();
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        //Se recupera el tamaño del array a asignar los valores
        int theSize= ambit.getOneDimSize(this.id);
        int bad=0;
        if(this.values.size()!=theSize){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Se asignó un número incorrecto de datos al array '"+this.id+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }else{

            for(int i=0; i<this.values.size();i++){
                Expression evaluate=this.values.get(i);
                Returnal temp= evaluate.execute(ambit);
                if(tempSymbol.type!=temp.type){
                    bad++;
                }
            }
        }
        //Se verifica que todos los valores, sean del mismo tipo que el del array.
        if(bad!=0){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se puede asignar valores de diferentes tipos al array '"+this.id+"' que es de tipo '"+tempSymbol.type.toString()+"'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }
        int incorrectLength=0;
        if(Objects.equals(tempSymbol.type.toString(), "CHARACTER")){
            for(int i=0; i<this.values.size();i++) {
                Expression evaluate = this.values.get(i);
                Returnal temp = evaluate.execute(ambit);
                if (temp.value.toString().length() > 1) {
                    incorrectLength++;
                }else{
                    ambit.updateOneDimArray(this.id, temp.value,i+1);
                }
            }
            if(incorrectLength!=0){
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Algunos valores no fueron agregados al array '"+this.id+"', ya que no cumplian con la longitud de un char",String.valueOf(this.line),String.valueOf(this.column)));
                return true;

            }else{
                return true;
            }
        }


        for(int i=0; i<this.values.size();i++){
            Expression evaluate=this.values.get(i);
            Returnal temp= evaluate.execute(ambit);
            ambit.updateOneDimArray(this.id, temp.value,i+1);
        }


        return true;
    }


    public Object c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Symbol tempSymbol= ambit.getVal(this.id,String.valueOf(this.line) ,String.valueOf(this.column));
        if(Objects.equals(tempSymbol.type.toString(), "CHARACTER")){
            for(int i=0; i<this.values.size();i++) {
                Expression evaluate = this.values.get(i);
                Returnal temp = evaluate.c3d(ambit);
                char c= temp.value.toString().charAt(0);
                threeWayCodeHandler.mainCode+=this.id+="["+i+"]"+"="+(int)c+";\n";

            }

        }else {
            for(int i=0; i<this.values.size();i++){
                Expression evaluate=this.values.get(i);
                Returnal temp= evaluate.c3d(ambit);
                threeWayCodeHandler.mainCode+=this.id+="["+i+"]"+"="+temp.value.toString()+";\n";
            }
        }
        return true;
    }


}
