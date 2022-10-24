package Expression;
import Ambit.*;
import ThreeWayCode.ThreeWayCode;

public class Literal extends Expression{
    public Object value ;
    private LiteralType type;
    public int line;
    public int column;

    public Literal(Object value, LiteralType type, int line, int column){

        super(line,column);
        this.value=value;
        this.type=type;
    }

    public Returnal execute(Ambit ambit){
        //System.out.println("aaaa");
        if (this.type.getValue() == 0) {
            //return { value: this.value.toString(), type: Type.STRING };
            return new Returnal(this.value.toString(),ReturnType.CHARACTER);
        } else if (this.type.getValue() == 1) {
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.INTEGER);
        }else if (this.type.getValue() == 2) {
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.LOGICAL);
        }else if (this.type.getValue() == 3) {
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.REAL);
        }
        else if (this.type.getValue() == 4) {
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.COMPLEX);
        }
        else if (this.type.getValue() == 5) {
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.ARRAY);
        }

        return null;
    }

    public Returnal c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        //System.out.println("bbbb");
        if (this.type.getValue() == 0) {
            //return { value: this.value.toString(), type: Type.STRING };
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            return new Returnal(this.value.toString(),ReturnType.CHARACTER);
        } else if (this.type.getValue() == 1) {
            //return { value: Number(this.value), type: Type.NUMBER };
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            return new Returnal(this.value,ReturnType.INTEGER);
        }else if (this.type.getValue() == 2) {
            //return { value: Number(this.value), type: Type.NUMBER };
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            return new Returnal(this.value,ReturnType.LOGICAL);
        }else if (this.type.getValue() == 3) {
            //return { value: Number(this.value), type: Type.NUMBER };
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            return new Returnal(this.value,ReturnType.REAL);
        }
        else if (this.type.getValue() == 4) {
            //return { value: Number(this.value), type: Type.NUMBER };
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            return new Returnal(this.value,ReturnType.COMPLEX);
        }
        else if (this.type.getValue() == 5) {
            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+this.value.toString()+";\n";
            //return { value: Number(this.value), type: Type.NUMBER };
            return new Returnal(this.value,ReturnType.ARRAY);
        }

        return null;
    }
}




