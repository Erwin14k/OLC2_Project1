package Instruction;
import Ambit.*;
public class Break extends Instruction{
    public String line;
    public String column;
    public Break(String line, String column){
        super(line,column);
    }

    public Object execute(Ambit ambit) {
        return this;
    }

    public Object c3d(Ambit ambit){
        return this;
    }
}
