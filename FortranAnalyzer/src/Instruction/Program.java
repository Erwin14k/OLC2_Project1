package Instruction;

import Ambit.*;


public class Program extends Instruction{
    public String id;
    public MainStatement statement;
    public String line;
    public String column;

    public Program(String id, Object statement, String line, String column){
        super(line, column);
        this.id=id;
        this.statement=(MainStatement) statement;
        this.line=line;
        this.column=column;

    }

    public Object execute(Ambit ambit) {
        this.statement.execute(ambit);
        return null;

    }

    public Object c3d(Ambit ambit){
        this.statement.c3d(ambit);
        return null;
    }
}
