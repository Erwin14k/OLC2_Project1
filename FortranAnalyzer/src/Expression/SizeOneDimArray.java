package Expression;
import Ambit.*;
import Extra.ErrorCollector;
import Extra.Errors;

public class SizeOneDimArray extends Expression {
    public String id;
    public int line;
    public int column;

    public SizeOneDimArray(String id, int line, int column) {
        super(line, column);
        this.id = id.toUpperCase();
    }

    public Returnal execute(Ambit ambit) {
        if (ambit.booleanGetOneDimSize(this.id)) {
            int theSize = ambit.getOneDimSize(this.id);
            return new Returnal(theSize, ReturnType.INTEGER);
        } else if (ambit.booleanGetTwoDimSize(this.id)) {
            int size1 = ambit.getFirstIndexArray(this.id);
            int size2 = ambit.getSecondIndexArray(this.id);
            return new Returnal(size1 * size2, ReturnType.INTEGER);
        } else {
            ErrorCollector errorHandler = ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico", "No se encontró el array '" + this.id + "'", String.valueOf(this.line), String.valueOf(this.column)));
            return null;
        }
    }


    public Returnal c3d(Ambit ambit){
        return null;
    }
}
