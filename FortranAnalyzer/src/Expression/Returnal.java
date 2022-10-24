package Expression;

public class Returnal {
    public ReturnType type;
    public Object value;

    public Returnal(Object value, ReturnType type ) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return (String) this.value;
    }
}
