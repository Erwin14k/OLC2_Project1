package Instruction;

import Ambit.Ambit;
import Expression.ReturnType;

import java.util.ArrayList;

public class DynamicTwoDeclaration extends Instruction{

    private String id;
    public String line;
    public String column;
    public int size1;
    public int size2;
    public ArrayList<Object> values;
    public ReturnType type;

    public DynamicTwoDeclaration(String id, ArrayList<Object> values,int size1,int size2,ReturnType type, String line, String column){
        super(line, column);
        this.values=values;
        this.id=id.toUpperCase();
        this.size1=size1;
        this.size2=size2;
        this.type=type;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        ambit.newArrayOneDim(this.id, this.values, this.type, this.line, this.column);
        ambit.sizeTwoDim(this.id,this.size1,this.size2);
        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
