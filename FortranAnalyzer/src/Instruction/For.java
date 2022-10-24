package Instruction;
import Ambit.*;
import Expression.*;

import java.util.Objects;

public class For extends Instruction{

    private Instruction body;
    public Object initial;
    public Object limit;
    public Object speed;
    public String line;
    public String column;

    public For(Object initial, Object limit,Object speed,Object body, String line, String column){
        super(line,column);
        this.initial= initial;
        this.speed= speed;
        this.limit= limit;
        this.body=(Instruction) body;
    }

    public Object execute(Ambit ambit) {

        for(int i=Integer.parseInt(this.initial.toString()) ; i<Integer.parseInt(this.limit.toString());i+=Integer.parseInt(this.speed.toString())){
            this.body.execute(ambit);
        }
        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
