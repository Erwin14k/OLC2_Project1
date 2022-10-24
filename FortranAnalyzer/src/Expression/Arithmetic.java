package Expression;

import Ambit.Ambit;
import Extra.ErrorCollector;
import Extra.Errors;
import ThreeWayCode.*;

public class Arithmetic extends Expression{

    public Expression left;
    public Expression right;
    public int line;
    public int column;
    private ArithmeticType type;

    public Arithmetic(Object left, Object right,ArithmeticType type,int line, int column){
        super(line,column);
        this.left=(Expression) left;
        this.right=(Expression)right;
        this.type=type;
        this.line=line;
        this.column=column;
    }


    public Returnal execute(Ambit ambit) {
        //System.out.println("sssss");
        if(this.type == ArithmeticType.NEGATIVE){
            Returnal leftValue = this.left.execute(ambit);
            if(leftValue==null){
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","No se puede evaluar con el operador '-' expresiones que no sean de tipo 'Integer' o 'Real'",String.valueOf(this.line),String.valueOf(this.column)));
                return null;
            } else{
                if(leftValue.type==ReturnType.INTEGER){
                    //System.out.println(-Integer.parseInt(leftValue.value.toString()));
                    return  new Returnal(-Integer.parseInt(leftValue.value.toString()),  ReturnType.INTEGER );

                }else if(leftValue.type==ReturnType.REAL){
                    return new Returnal  (0-Double.parseDouble(leftValue.value.toString())  ,ReturnType.REAL );
                }
            }
        }
        Returnal leftValue = this.left.execute(ambit);

        Returnal rightValue = this.right.execute(ambit);

        if(leftValue==null || rightValue==null){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","No se puede evaluar la operacion aritmetica con expresiones que no sean de tipo 'Integer' o 'Real'",String.valueOf(this.line),String.valueOf(this.column)));
            return null;
        }

        int dominant = this.dominantType(leftValue.type, rightValue.type);
        //ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();

        if (this.type == ArithmeticType.SUMA) {
            //System.out.println("1");
            if (dominant == ReturnType.REAL.getValue()) {
                return new Returnal  (Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
            } else if (dominant == ReturnType.INTEGER.getValue()) {
                //System.out.println(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()));
                return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
            } else {
                //throw new Error_(this.line, this.column, 'Semantico', 'No se puede operar: ' + leftValue.type + ' _ ' + rightValue.type);
            }
        } else if (this.type == ArithmeticType.RESTA) {
            //System.out.println("2");
            if (dominant == ReturnType.INTEGER.getValue()) {
                //System.out.println(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()));

                return new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()) , ReturnType.INTEGER );
            } else if(dominant == ReturnType.REAL.getValue()){
                return new Returnal  (Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
            }else{
                //throw new Error_(this.line, this.column, 'Semantico', 'No se puede operar: ' + leftValue.type + ' _ ' + rightValue.type);
            }
        }
        else if (this.type == ArithmeticType.MULTIPLICACION) {
            //System.out.println("3");
            if (dominant == ReturnType.INTEGER.getValue()) {
                //System.out.println(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()));
                return new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()), ReturnType.INTEGER);
            }else if(dominant == ReturnType.REAL.getValue()){
                return new Returnal  (Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
            }else {
                //throw new Error_(this.line, this.column, 'Semantico', 'No se puede operar: ' + leftValue.type + ' _ ' + rightValue.type);
            }
        }
        else if (this.type == ArithmeticType.DIVISION) {
            //System.out.println("4");
            if (dominant == ReturnType.INTEGER.getValue()) {
                if (Integer.parseInt(rightValue.value.toString()) == 0) {
                    //throw new Error_(this.line, this.column, "Semantico", "No se puede dividir entre 0");
                } else {
                    return new Returnal ((int)(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString())),  ReturnType.INTEGER );
                }
            } else if(dominant == ReturnType.REAL.getValue()) {
                if (Integer.parseInt(rightValue.value.toString()) == 0) {
                    //throw new Error_(this.line, this.column, "Semantico", "No se puede dividir entre 0");
                }else{
                    return new Returnal  (Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                }
            }else{
                //throw new Error_(this.line, this.column, 'Semantico', 'No se puede operar: ' + leftValue.type + ' _ ' + rightValue.type);

            }
        }else if (this.type == ArithmeticType.POTENCIA) {
            if (dominant == ReturnType.INTEGER.getValue()) {
                return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);
            }else if(dominant == ReturnType.REAL.getValue()){
                return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );
            }else {
                //throw new Error_(this.line, this.column, 'Semantico', 'No se puede operar: ' + leftValue.type + ' _ ' + rightValue.type);
            }
        }
        return null;
    }



    public Returnal c3d(Ambit ambit) {
        //System.out.println(this.left);
        //System.out.println(this.right);
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        if(this.type == ArithmeticType.NEGATIVE){
            Returnal leftValue = this.left.c3d(ambit);
            if(leftValue.type==ReturnType.INTEGER){
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=0-"+Integer.parseInt(leftValue.value.toString())+";\n";
                    return  new Returnal(-Integer.parseInt(leftValue.value.toString()),  ReturnType.INTEGER );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=0-"+Integer.parseInt(leftValue.value.toString())+";\n";
                    return  new Returnal(-Integer.parseInt(leftValue.value.toString()),  ReturnType.INTEGER );
                }


            }else if(leftValue.type==ReturnType.REAL){
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=0-"+Double.parseDouble(leftValue.value.toString())+";\n";
                    return new Returnal  (0-Double.parseDouble(leftValue.value.toString())  ,ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=0-"+Double.parseDouble(leftValue.value.toString())+";\n";
                    return new Returnal  (0-Double.parseDouble(leftValue.value.toString())  ,ReturnType.REAL );

                }

            }
            return null;

        }

        Returnal leftValue = this.left.c3d(ambit);
        Returnal rightValue = this.right.c3d(ambit);
        //System.out.println(leftValue.value.toString());
        int dominant = this.dominantType(leftValue.type, rightValue.type);



        if (this.type == ArithmeticType.SUMA) {
            if (dominant == ReturnType.REAL.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Double.parseDouble(leftValue.value.toString()) + "+" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Double.parseDouble(leftValue.value.toString())+"+"+Double.parseDouble(rightValue.value.toString())+";\n";
                    return new Returnal  (Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"+"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            //System.out.println(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()));
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) + Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }

                }

            } else if (dominant == ReturnType.INTEGER.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Integer.parseInt(rightValue.value.toString())+";\n";
                            //threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Integer.parseInt(leftValue.value.toString()) + "+" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Integer.parseInt(leftValue.value.toString())+"+"+Integer.parseInt(rightValue.value.toString())+";\n";
                    return new Returnal  (Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"+"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"+"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"+"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) + Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }

                }

            }
        } else if (this.type == ArithmeticType.RESTA) {
            if (dominant == ReturnType.INTEGER.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Integer.parseInt(leftValue.value.toString()) + "-" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Integer.parseInt(leftValue.value.toString())+"-"+Integer.parseInt(rightValue.value.toString())+";\n";
                    return new Returnal  (Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"-"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(3)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) - Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }

                }

            } else if(dominant == ReturnType.REAL.getValue()){
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Double.parseDouble(leftValue.value.toString()) + "-" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Double.parseDouble(leftValue.value.toString())+"-"+Double.parseDouble(rightValue.value.toString())+";\n";
                    return new Returnal  (Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"-"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"-"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"-"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) - Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }

                }
            }
        }
        else if (this.type == ArithmeticType.MULTIPLICACION) {
            if (dominant == ReturnType.INTEGER.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Integer.parseInt(leftValue.value.toString()) + "*" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }


                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Integer.parseInt(leftValue.value.toString())+"*"+Integer.parseInt(rightValue.value.toString())+";\n";
                    return new Returnal  (Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"*"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof  Access){
                            System.out.println("sjdfjsdfjdf");
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) * Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }

                }
            }else if(dominant == ReturnType.REAL.getValue()){
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            //System.out.println(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()));
                            return new Returnal  (Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Double.parseDouble(leftValue.value.toString()) + "*" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Double.parseDouble(leftValue.value.toString())+"*"+Double.parseDouble(rightValue.value.toString())+";\n";
                    return new Returnal  (Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"*"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"*"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"*"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) * Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }

                }
            }
        }
        else if (this.type == ArithmeticType.DIVISION) {
            if (dominant == ReturnType.INTEGER.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Integer.parseInt(leftValue.value.toString()) + "/" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Integer.parseInt(leftValue.value.toString())+"/"+Integer.parseInt(rightValue.value.toString())+";\n";
                    return new Returnal  (Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),ReturnType.INTEGER );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"/"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Integer.parseInt(leftValue.value.toString())+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Integer.parseInt(rightValue.value.toString())+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Integer.parseInt(leftValue.value.toString()) / Integer.parseInt(rightValue.value.toString()),  ReturnType.INTEGER );
                        }
                    }

                }


            } else if(dominant == ReturnType.REAL.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    if(this.left instanceof Access){
                        if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode+="="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return new Returnal  (Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }else{
                        if(this.right instanceof  Access) {
                            threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                            threeWayCodeHandler.mainCode += "=" + Double.parseDouble(leftValue.value.toString()) + "/" + threeWayCodeHandler.previousTemporal() + ";\n";
                            return new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()), ReturnType.INTEGER);
                        }

                    }
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="="+Double.parseDouble(leftValue.value.toString())+"/"+Double.parseDouble(rightValue.value.toString())+";\n";
                    return new Returnal  (Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"/"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }else if(this.right instanceof  Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+Double.parseDouble(leftValue.value.toString())+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }
                    }else if(this.left instanceof Arithmetic){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }


                    }else if(this.left instanceof Access){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.previousTemporal()+"/"+Double.parseDouble(rightValue.value.toString())+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Arithmetic){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(4)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );

                        }else if(this.right instanceof Access){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"="+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+"/"+threeWayCodeHandler.previousTemporal()+";\n";
                            return  new Returnal(Double.parseDouble(leftValue.value.toString()) / Double.parseDouble(rightValue.value.toString()),  ReturnType.REAL );
                        }
                    }

                }

            }
        }else if (this.type == ArithmeticType.POTENCIA) {
            if (dominant == ReturnType.INTEGER.getValue()) {
                if(!threeWayCodeHandler.isActive){
                    threeWayCodeHandler.isTheFirst=true;
                    threeWayCodeHandler.isActive=true;
                    threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode+="=pow( "+Integer.parseInt(leftValue.value.toString())+","+ Integer.parseInt(rightValue.value.toString()) +");\n";
                    return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+Integer.parseInt(leftValue.value.toString())+","+Integer.parseInt(rightValue.value.toString())+");\n";
                            return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+Integer.parseInt(leftValue.value.toString())+","+threeWayCodeHandler.previousTemporal()+");\n";
                            return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);
                        }
                    }else{
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+threeWayCodeHandler.previousTemporal()+","+Integer.parseInt(rightValue.value.toString())+");\n";
                            return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);

                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+","+threeWayCodeHandler.previousTemporal()+");\n";
                            return new Returnal((int)(Math.pow(Integer.parseInt(leftValue.value.toString()), Integer.parseInt(rightValue.value.toString()))) , ReturnType.INTEGER);

                        }
                    }

                }
            }else if(dominant == ReturnType.REAL.getValue()){
                if(!threeWayCodeHandler.isActive) {
                    threeWayCodeHandler.isTheFirst = true;
                    threeWayCodeHandler.isActive = true;
                    threeWayCodeHandler.mainCode += threeWayCodeHandler.generateTemporal();
                    threeWayCodeHandler.mainCode += "=pow( " + Double.parseDouble(leftValue.value.toString()) + "," + Double.parseDouble(rightValue.value.toString()) + ");\n";
                    return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );
                }else{
                    threeWayCodeHandler.isTheFirst=false;
                    if(this.left instanceof Literal){
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+Double.parseDouble(leftValue.value.toString())+","+Double.parseDouble(rightValue.value.toString())+");\n";
                            return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );
                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+Double.parseDouble(leftValue.value.toString())+","+threeWayCodeHandler.previousTemporal()+");\n";
                            return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );
                        }
                    }else{
                        if(this.right instanceof Literal){
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+threeWayCodeHandler.previousTemporal()+","+Double.parseDouble(rightValue.value.toString())+");\n";
                            return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );

                        }else{
                            threeWayCodeHandler.mainCode+=threeWayCodeHandler.generateTemporal()+"=pow("+threeWayCodeHandler.getPersonalizePreviousTemporal(2)+","+threeWayCodeHandler.previousTemporal()+");\n";
                            return new Returnal  (Math.pow(Double.parseDouble(leftValue.value.toString()), Double.parseDouble(rightValue.value.toString()))  ,ReturnType.REAL );

                        }
                    }
                }
            }
        }
        return null;
    }
    public enum ArithmeticType {
            SUMA,
            RESTA,
            MULTIPLICACION,
            DIVISION,
            POTENCIA,
            NEGATIVE
    }
}
