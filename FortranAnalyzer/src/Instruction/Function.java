package Instruction;

import java.util.ArrayList;
import Ambit.*;
public class Function extends Instruction{

    public String id;
    public Statement statement;
    public ArrayList<String> parametersId;
    public String line;
    public String column;
    public String returnId;
    public ArrayList<String> decPar;

    public Function(String id, Object statement,ArrayList<String> parametersId,String returnId,ArrayList<String> decPar, String line, String column){
        super(line, column);
        this.id=id.toUpperCase();
        this.statement=(Statement) statement;
        this.parametersId=parametersId;
        this.returnId=returnId.toUpperCase();
        this.line=line;
        this.column=column;
        this.decPar=decPar;
    }

    public Object execute(Ambit ambit) {
        ambit.saveFunction(this.id, this,this.line,this.column);
        return true;
    }

    public Object c3d(Ambit ambit){
        return null;
    }
}
