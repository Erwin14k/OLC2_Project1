package Instruction;

import Ambit.Ambit;

public abstract class Instruction {
    public String line;
    public String column;
    public Instruction(String line, String column) {
        this.line = line;
        this.column = column;
    }

    public abstract Object execute(Ambit ambit);

    public abstract Object c3d(Ambit ambit);
}
