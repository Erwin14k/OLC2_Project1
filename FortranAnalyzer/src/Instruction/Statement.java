package Instruction;
import Ambit.*;
import Expression.Expression;

import java.util.ArrayList;

public class Statement extends Instruction{
    public ArrayList<Object> code;
    public String line;
    public String column;

    public Statement(ArrayList<Object> code,String line, String column){
        super(line, column);
        this.code=code;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        Ambit newAmb = new Ambit(ambit,"Statement");
        Object theFinal=null;
        for (Object value : this.code) {
            try{
                Instruction temp = (Instruction) value;
                theFinal =temp;
                //System.out.println(temp);

                if(temp instanceof Continue) break;
                if(temp instanceof Break) break;

                Object element = temp.execute(newAmb);
                //System.out.println(element+"*************");
                if(element instanceof Continue){
                    theFinal=element;
                    break;
                }
                if(element instanceof Break){
                    theFinal=element;
                    break;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return theFinal;
    }

    public Object c3d(Ambit ambit){
        Ambit newAmb = new Ambit(ambit,"Statement");
        Object theFinal=null;
        for (Object value : this.code) {
            try{
                Instruction temp = (Instruction) value;
                //System.out.println(temp);
                theFinal =temp;
                if(temp instanceof Break) break;
                if(temp instanceof Continue) break;


                Object element = temp.c3d(newAmb);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return theFinal;
    }



}
