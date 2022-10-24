package Instruction;

import Ambit.Ambit;
import Expression.*;
import Extra.*;
import java.util.ArrayList;
import java.util.Objects;

public class MultipleDeclaration2 extends Instruction{
    private ArrayList<String> ids;
    public String line;
    public String column;
    private Expression value;
    public String type;
    public MultipleDeclaration2(ArrayList<String> ids, Object value, String type,String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.ids=ids;
        this.line=line;
        this.column=column;
        this.type=type;
    }

    public Object execute(Ambit ambit) {
        Returnal val = this.value.execute(ambit);
        if(val!=null){
            if(Objects.equals(val.type.toString(), this.type.toUpperCase())){
                for(int i=0; i<this.ids.size();i++){
                    ambit.setVal(this.ids.get(i).toUpperCase(), val.value, val.type, this.line, this.column);
                }

                return true;
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede  asignar un valor de tipo '"+val.type+"' a un conjunto de variables de tipo '"+this.type.toUpperCase()+"'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            }
        }else{
            return null;
        }
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
