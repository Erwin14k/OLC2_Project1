package Interpreter;
public class Interpreter {
    public String  console;
    public String astCode;
    public static Interpreter instance;

    private Interpreter() {
        this.console = "";
        this.astCode="";
    }

    public static Interpreter getInstance() {
        if (instance == null){
            instance = new Interpreter();
        }

        return instance;
    }
}
