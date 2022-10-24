package Instruction;

import Ambit.*;

import java.util.ArrayList;

public class DeallocateOne extends Instruction{
    public String id;
    public String line;
    public String column;

    public DeallocateOne(String id,String line,String column){
        super(line,column);
        this.line=line;
        this.column=column;
        this.id=id.toUpperCase();

    }

    public Object execute(Ambit ambit){
        ArrayList<Object> values=new ArrayList<>();
        ambit.deallocateAnArray(this.id,values);
        ambit.deallocateSizeOfAnArray(this.id);
        return true;

    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
