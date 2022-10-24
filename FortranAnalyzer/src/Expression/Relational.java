package Expression;
import Ambit.*;
import Extra.*;
import ThreeWayCode.ThreeWayCode;

import java.util.Objects;

public class Relational extends Expression{

    public Expression left;
    public Expression right;
    public RelationalType type;
    public int line;
    public int column;
    public Relational(Object left, Object right, RelationalType type, int line, int column){
        super(line, column);
        this.left= (Expression) left;
        this.right= (Expression) right;
        this.type=type;
        this.line=line;
    }


    public Returnal execute(Ambit ambit) {
        Returnal leftValue = this.left.execute(ambit);
        Returnal rightValue = this.right.execute(ambit);
        //System.out.println(leftValue.value.toString()+"---"+leftValue.type.toString());
        if (this.type == RelationalType.IGUALIGUAL) {
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  == Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")){
                Boolean result =Integer.parseInt(leftValue.value.toString())  == Integer.parseInt(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "CHARACTER") && Objects.equals(rightValue.type.toString(), "CHARACTER")){
                Boolean result = Objects.equals(leftValue.value.toString(), rightValue.value.toString());
                //System.out.println(result);
                return new Returnal(result,ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '==' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }

        } else if (this.type == RelationalType.DIFERENTE) {

            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  != Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")){
                Boolean result =Integer.parseInt(leftValue.value.toString())  != Integer.parseInt(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "CHARACTER") && Objects.equals(rightValue.type.toString(), "CHARACTER")){
                Boolean result = ! Objects.equals(leftValue.value.toString(), rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '/=' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }

        } else if (this.type == RelationalType.MAYOR) {
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  > Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) > Integer.parseInt(rightValue.value.toString());
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '>' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }

        } else if (this.type == RelationalType.MAYOR_IGUAL) {
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  >= Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) >= Integer.parseInt(rightValue.value.toString());
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '>=' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }
        } else if (this.type == RelationalType.MENOR) {
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  < Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) < Integer.parseInt(rightValue.value.toString());
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '<' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }
        } else if (this.type == RelationalType.MENOR_IGUAL) {
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  <= Double.parseDouble(rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) <= Integer.parseInt(rightValue.value.toString());
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '<=' expresiones de diferentes tipos",String.valueOf(this.line),String.valueOf(this.column)));
            }
        }else if(this.type == RelationalType.AND){
            if(Objects.equals(leftValue.type.toString(), "LOGICAL") && Objects.equals(rightValue.type.toString(), "LOGICAL")){
                Boolean result= Objects.equals(leftValue.value.toString(), "true") && Objects.equals(rightValue.value.toString(), "true");
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '.and.' expresiones que no sean de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
            }


        }else if(this.type == RelationalType.OR){
            if(Objects.equals(leftValue.type.toString(), "LOGICAL") && Objects.equals(rightValue.type.toString(), "LOGICAL")){
                Boolean result= Objects.equals(leftValue.value.toString(), "true") || Objects.equals(rightValue.value.toString(), "true");
                return new Returnal(result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '.or.' expresiones que no sean de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
            }


        }else if(this.type == RelationalType.NOT){
            if(Objects.equals(leftValue.type.toString(), "LOGICAL")){
                //System.out.println(leftValue.value.toString());
                Boolean result= Objects.equals(leftValue.value.toString(), "true") ;
                if(result){

                }else{
                    result= Objects.equals(leftValue.value.toString(), "T") ;
                }
                //System.out.println(result+"----");
                return new Returnal(!result, ReturnType.LOGICAL);
            }else{
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '.not.' expresiones que no sean de tipo 'Logical'",String.valueOf(this.line),String.valueOf(this.column)));
            }


        }
        return null;
    }

    public Returnal c3d(Ambit ambit){
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        Returnal leftValue = this.left.c3d(ambit);
        Returnal rightValue = this.right.c3d(ambit);
        if (this.type == RelationalType.IGUALIGUAL) {
            threeWayCodeHandler.conditionOfWhile="==";
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  == Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"=="+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"=="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"=="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "==" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "==" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")){
                //System.out.println("es en enetroror");
                Boolean result =Integer.parseInt(leftValue.value.toString())  == Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"=="+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"=="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"=="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "==" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "==" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "==" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "CHARACTER") && Objects.equals(rightValue.type.toString(), "CHARACTER")){
                Boolean result = Objects.equals(leftValue.value.toString(), rightValue.value.toString());
                //System.out.println(result);
                return new Returnal(result,ReturnType.LOGICAL);
            }

        } else if (this.type == RelationalType.DIFERENTE) {
            threeWayCodeHandler.conditionOfWhile="/=";

            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  != Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"!="+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"!="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"!="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "!=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "!=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")){
                Boolean result =Integer.parseInt(leftValue.value.toString())  != Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"!="+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"!="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"!="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "!=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "!=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "!=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "CHARACTER") && Objects.equals(rightValue.type.toString(), "CHARACTER")){
                Boolean result = ! Objects.equals(leftValue.value.toString(), rightValue.value.toString());
                return new Returnal(result,ReturnType.LOGICAL);
            }

        } else if (this.type == RelationalType.MAYOR) {
            threeWayCodeHandler.conditionOfWhile=">";
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  > Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">"+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) > Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">"+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result, ReturnType.LOGICAL);
            }

        } else if (this.type == RelationalType.MAYOR_IGUAL) {
            threeWayCodeHandler.conditionOfWhile=">=";
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  >= Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">="+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+">="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) >= Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">="+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+">="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + ">=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + ">=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result, ReturnType.LOGICAL);
            }
        } else if (this.type == RelationalType.MENOR) {
            threeWayCodeHandler.conditionOfWhile="<";
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  < Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<"+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) < Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<"+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<"+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result, ReturnType.LOGICAL);
            }
        } else if (this.type == RelationalType.MENOR_IGUAL) {
            threeWayCodeHandler.conditionOfWhile="<=";
            if(Objects.equals(leftValue.type.toString(), "REAL") && Objects.equals(rightValue.type.toString(), "REAL")){
                Boolean result =Double.parseDouble(leftValue.value.toString())  <= Double.parseDouble(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<="+Double.parseDouble(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Double.parseDouble(leftValue.value.toString())+"<="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<=" + Double.parseDouble(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result,ReturnType.LOGICAL);
            }else if(Objects.equals(leftValue.type.toString(), "INTEGER") && Objects.equals(rightValue.type.toString(), "INTEGER")) {
                Boolean result = Integer.parseInt(leftValue.value.toString()) <= Integer.parseInt(rightValue.value.toString());
                if(this.left instanceof Literal){
                    if(this.right instanceof Literal){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<="+Integer.parseInt(rightValue.value.toString())+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";
                        threeWayCodeHandler.mainCode+="printf(\"%c\", (char)10);\n";

                    }else if(this.right instanceof Arithmetic){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }else if(this.right instanceof Access){
                        threeWayCodeHandler.mainCode+="if("+Integer.parseInt(leftValue.value.toString())+"<="+threeWayCodeHandler.lastTemporal()+") goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                        threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.previousLabel()+":\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastTemporal()+"=(double)0;\n";
                        threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                    }
                }else if(this.left instanceof  Arithmetic) {
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }
                }else if(this.left instanceof Access){
                    if (this.right instanceof Literal) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.lastTemporal() + "<=" + Integer.parseInt(rightValue.value.toString()) + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";
                        threeWayCodeHandler.mainCode += "printf(\"%c\", (char)10);\n";

                    } else if (this.right instanceof Arithmetic) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";

                    } else if (this.right instanceof Access) {
                        threeWayCodeHandler.mainCode += "if(" + threeWayCodeHandler.previousTemporal() + "<=" + threeWayCodeHandler.lastTemporal() + ") goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal() + "=(double)1;\n";
                        threeWayCodeHandler.mainCode += "goto " + threeWayCodeHandler.generateLabel() + ";\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.previousLabel() + ":\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastTemporal() + "=(double)0;\n";
                        threeWayCodeHandler.mainCode += threeWayCodeHandler.lastLabel() + ":\n";


                    }

                }
                return new Returnal(result, ReturnType.LOGICAL);
            }
        }else if(this.type == RelationalType.AND){
            if(Objects.equals(leftValue.type.toString(), "LOGICAL") && Objects.equals(rightValue.type.toString(), "LOGICAL")){
                Boolean result= Objects.equals(leftValue.value.toString(), "true") && Objects.equals(rightValue.value.toString(), "true");
                String firstLabel=threeWayCodeHandler.generateLabel();
                String secondLabel=threeWayCodeHandler.generateLabel();
                String thirdLabel=threeWayCodeHandler.generateLabel();
                //System.out.println(firstLabel+"_____");
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"==1) goto "+thirdLabel+";\n";
                threeWayCodeHandler.mainCode+="goto "+secondLabel+";\n";
                threeWayCodeHandler.mainCode+=thirdLabel+":\n";
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.lastTemporal()+"==1) goto "+firstLabel+";\n";
                threeWayCodeHandler.mainCode+="goto "+secondLabel+";\n";
                threeWayCodeHandler.mainCode+=firstLabel+":\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=(double)1;\n";
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.lastTemporal();
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.generateLabel()+";\n";
                threeWayCodeHandler.mainCode+=secondLabel+":\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.resultOfLogical+"=(double)0;\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                return new Returnal(result, ReturnType.LOGICAL);
            }


        }else if(this.type == RelationalType.OR){
            if(Objects.equals(leftValue.type.toString(), "LOGICAL") && Objects.equals(rightValue.type.toString(), "LOGICAL")){
                Boolean result= Objects.equals(leftValue.value.toString(), "true") || Objects.equals(rightValue.value.toString(), "true");
                String l1=threeWayCodeHandler.generateLabel();
                String l2=threeWayCodeHandler.generateLabel();
                String l3=threeWayCodeHandler.generateLabel();
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"==1) goto "+l1+";\n";
                threeWayCodeHandler.mainCode+="goto "+l3+";\n";
                threeWayCodeHandler.mainCode+=l3+":\n";
                threeWayCodeHandler.mainCode+="if((int)"+threeWayCodeHandler.lastTemporal()+"==1) goto "+l1+";\n";
                threeWayCodeHandler.mainCode+="goto "+l2+";\n";
                threeWayCodeHandler.mainCode+=l1+":\n";
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.generateTemporal();
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.resultOfLogical+"=(double)1;\n";
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.lastTemporal();
                threeWayCodeHandler.generateLabel();
                //System.out.println(threeWayCodeHandler.lastLabel());
                threeWayCodeHandler.mainCode+="goto "+threeWayCodeHandler.lastLabel()+";\n";
                threeWayCodeHandler.mainCode+=l2+":\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.resultOfLogical+"=(double)0;\n";
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.lastLabel()+":\n";

                return new Returnal(result, ReturnType.LOGICAL);
            }


        }else if(this.type == RelationalType.NOT){

            Boolean result= Objects.equals(leftValue.value.toString(), "true") ;
            //System.out.println(result+"----");
            if(result){

            }else{
                result= Objects.equals(leftValue.value.toString(), "T") ;
            }
            //System.out.println(!result+"////");
            if(result){
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.generateTemporal();
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.resultOfLogical+"=(double)0;\n";
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.lastTemporal();

            }else{
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.generateTemporal();
                threeWayCodeHandler.mainCode+=threeWayCodeHandler.resultOfLogical+"=(double)1;\n";
                threeWayCodeHandler.resultOfLogical=threeWayCodeHandler.lastTemporal();
            }


            return new Returnal(!result, ReturnType.LOGICAL);
        }
        return null;
    }

}
