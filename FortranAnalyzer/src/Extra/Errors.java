package Extra;

public class Errors {
    public String type;
    public String description;
    public String line;
    public String column;

    public Errors(String type, String description, String line, String column){
        this.type=type;
        this.column=column;
        this.line=line;
        this.description=description;

    }
}
