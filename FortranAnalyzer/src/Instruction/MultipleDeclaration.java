package Instruction;

import Ambit.*;
import Expression.*;

import java.util.ArrayList;

public class MultipleDeclaration extends Instruction{
    public ArrayList<String> ids;
    public String line;
    public String column;
    private Expression value;
    public MultipleDeclaration(ArrayList<String> ids, Object value, String line, String column){
        super(line, column);
        this.value=(Expression) value;
        this.ids=ids;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Returnal val = this.value.execute(ambit);
        for(int i=0;i<this.ids.size();i++){
            String temp=this.ids.get(i).toUpperCase();
            ambit.setVal(temp, val.value, val.type, this.line, this.column);
        }
        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
