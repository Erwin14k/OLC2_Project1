package Instruction;

import Ambit.Ambit;
import Expression.ReturnType;

import java.util.ArrayList;

public class DynamicOneDeclaration extends Instruction{
    private String id;
    public String line;
    public String column;
    public int size;
    public ArrayList<Object> values;
    public ReturnType type;

    public DynamicOneDeclaration(String id, ArrayList<Object> values,int size,ReturnType type, String line, String column){
        super(line, column);
        this.values=values;
        this.id=id.toUpperCase();
        this.size=size;
        this.type=type;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        ambit.newArrayOneDim(this.id, this.values, this.type, this.line, this.column);
        ambit.sizeOneDim(this.id,this.size);
        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }

}
