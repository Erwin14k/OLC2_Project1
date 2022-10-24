package Instruction;

import Ambit.Ambit;

import java.util.ArrayList;

public class MainStatement extends Instruction{
    private ArrayList<Object> code;
    public String line;
    public String column;

    public MainStatement(ArrayList<Object> code,String line, String column){
        super(line, column);
        this.code=code;
    }

    public Object execute(Ambit ambit) {
        //System.out.println("holaaaaaaaaaaaaaaaa");
        Object theFinal=null;
        for (Object value : this.code) {
            try{
                Instruction temp = (Instruction) value;
                //System.out.println(temp);
                theFinal =temp;
                if(temp instanceof Continue) break;
                if(temp instanceof Break) break;
                Object element = temp.execute(ambit);
                //System.out.println(element);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return theFinal;
    }


    public Object c3d(Ambit ambit){
        Object theFinal=null;
        for (Object value : this.code) {
            try{
                Instruction temp = (Instruction) value;
                theFinal =temp;
                //System.out.println(temp);
                if(temp instanceof Continue) break;
                if(temp instanceof Break) break;
                Object element = temp.c3d(ambit);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return theFinal;
    }
}
