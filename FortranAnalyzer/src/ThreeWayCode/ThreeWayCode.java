package ThreeWayCode;


import Ambit.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreeWayCode {

    public String code;
    public int index;
    public String mainCode;
    public int counter;
    public int labelsCounter;
    public static ThreeWayCode instance;
    public HashMap<String, ArrayList<Object>> variables;
    public int c;
    public String tempCharId;

    //Variables controladoras de operaciones Aritmeticas
    public boolean isTheFirst;
    public boolean isActive;
    public int arithmeticCounter;
    public int charCounter;
    public String charsPrints;
    public String resultOfLogical;

    public String conditionOfWhile;



    private ThreeWayCode() {
        this.code = "";
        this.counter=-1;
        this.mainCode="";
        this.labelsCounter=-1;
        this.variables=new HashMap<>();
        this.index=-1;
        this.isTheFirst=false;
        this.isActive=false;
        this.arithmeticCounter=0;
        this.c=0;
        this.tempCharId="";
        this.charCounter=0;
        this.charsPrints="";
        this.resultOfLogical="";
        this.conditionOfWhile="";
    }

    public static ThreeWayCode getInstance() {
        if (instance == null){
            instance = new ThreeWayCode();
        }

        return instance;
    }



    public String generateTemporal()
    {
        this.counter++;
        return String.valueOf("t" + this.counter);
    }

    public String lastTemporal()
    {
        return String.valueOf("t" + this.counter);
    }

    public String previousTemporal()
    {
        return String.valueOf("t" + (this.counter-1));
    }

    public String getPersonalizePreviousTemporal(int minus)
    {
        return String.valueOf("t" + (this.counter-minus));
    }
    public String getPersonalizePreviousLabel(int minus)
    {
        return String.valueOf("L" + (this.labelsCounter-minus));
    }
    public String generateLabel()
    {
        this.labelsCounter++;
        //System.out.println(this.labelsCounter);
        return "L" + this.labelsCounter;
    }
    public String lastLabel()
    {
        return String.valueOf("L" + this.labelsCounter);
    }

    public String previousLabel(){
        return "L"+(this.labelsCounter-1);
    }
    public String getHeader() {
        String printStr=printSting();
        //String printC=printChar();
        String temps = "";
        for (int i = 0; i <= this.counter; i++)
            temps += "t" + String.valueOf(i) + (i < this.counter ? "," : ";\n");
        if(this.counter==-1){
            return "/*============Header============*/\n\n"+
                    "#include <stdio.h>\n" +
                    "#include <math.h>\n"+
                    "double STACK[30101999];\n" +
                    "double HEAP[30101999];\n" +
                    "double P;\n" +
                    "double H;\n"+
                    "/*================================*/\n\n";
        }else{
            return "/*============Header============*/\n\n"+
                    "#include <stdio.h>\n" +
                    "double STACK[30101999];\n" +
                    "double HEAP[30101999];\n" +
                    "double P;\n" +
                    "double H;\n" +
                    "double " + temps+"\n"+
                    printStr+"\n"+
                    this.charsPrints+"\n"+
                    "/*================================*/\n\n";
        }

    }

    public void joinTheCode(){
        this.code+=getHeader();
        this.code+="void main() {\nP=0; \nH=0;\n";
        this.code+=this.mainCode;
        this.code+="\nreturn;\n}\n";
    }

    public int getNextIndexInStack(){
        this.index++;
        return this.index;
    }

    public int lastIndex(){
        return this.index;
    }

    public void add(String id, ArrayList<Object> data){
        this.variables.put(id,data);

    }
    public Object getVariableData(String id){
        return this.variables.getOrDefault(id, null);
    }


    public void printChar(String theChar){
        //System.out.println(theChar+"{{{{");
        //System.out.println(theChar+"&&&&&&");
        String first=generateTemporal();
        String firstLabel=generateLabel();
        String secondLabel=generateLabel();
        String thirdLabel=generateLabel();

        this.charsPrints+=  "void printChar"+this.charCounter+"() {\n"+
                firstLabel+":\n"+
                first+"="+theChar+";\n"+
                "if("+first+"!=-1) goto "+secondLabel+";\n"+
                "goto "+thirdLabel+";\n"+
                secondLabel+":\n"+
                "printf(\"%c\", (char)"+theChar+");\n"+
                "goto "+thirdLabel+";\n"+
                thirdLabel+":\n"+
                "return;\n"+
                "}\n";
        this.charCounter++;



    }

    public String printSting(){
        String tempStart = this.generateTemporal();
        String labelStart = this.generateLabel();
        return "void printString()\n" +
                "{\n" +
                tempStart + " = P;\n" +
                labelStart + ":\n" +
                this.generateTemporal() + " = HEAP[(int)" + tempStart + "];\n" +
                "if (" + this.lastTemporal() + " != -1) goto L" + (this.labelsCounter + 1) + ";\n" +
                "goto L" + (this.labelsCounter + 2) + ";\n" +
                this.generateLabel() + ":\n" +
                "printf(\"%c\", (char)" + this.lastTemporal() + ");\n" +
                tempStart + "=" + tempStart + " + 1;\n" +
                "goto " + labelStart + ";\n" +
                this.generateLabel() + ":\n" +
                //"printf(\"%c\\n\", (char)32);\n" +
                "return;\n" +
                "}\n\n";
    }




}
