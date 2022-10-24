package Ambit;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Expression.Expression;
import Extra.ErrorCollector;
import Extra.Errors;
import Instruction.*;
import Expression.ReturnType;
public class Ambit {
    public HashMap<String, Symbol> variables;
    public HashMap<String, Function> functions;
    public HashMap<String, Subroutine> subroutines;

    public HashMap<String, Integer> oneArrays;

    public HashMap<String, ArrayList<Integer>> twoArrays;
    public Ambit previous;
    public String name;

    public int position;
    public Ambit(Ambit previous,String name){
        this.previous=previous;
        this.variables=new HashMap<String, Symbol>();
        this.functions=new HashMap<String, Function>();
        this.subroutines=new HashMap<String, Subroutine>();
        this.oneArrays=new HashMap<String, Integer>();
        this.twoArrays=new HashMap<String ,ArrayList<Integer>>();
        this.name=name;
        this.position=-1;
    }

    public void setVal(String id, Object value, ReturnType type, String line, String column) {
        Ambit ambit = this;
            if (ambit.variables.containsKey(id)) {
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errors.add(new Errors("Semantico","Ya existe una variable con el nombre '"+id+"' en el entrono actual",String.valueOf(line),String.valueOf(column)));
            }else{
                this.position++;
                this.variables.put(id, new Symbol(value, id, type,line,column,this.position));
            }
    }
    public Boolean update(String id, Object value, String line, String column) {
        Ambit ambit = this;

        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                Symbol temp = ambit.variables.get(id);
                temp.value=value;
                ambit.variables.put(id,temp);
                return true;
            }
            ambit = ambit.previous;
        }
        ErrorCollector errorHandler=ErrorCollector.getInstance();
        errorHandler.errors.add(new Errors("Semantico","No se encontró la variable con el nombre '"+id+"'.",String.valueOf(line),String.valueOf(column)));
        return false;

    }

    public Object updateSizeOneDim(String id, int size) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.oneArrays.containsKey(id)) {
                return ambit.oneArrays.put(id,size);
            }
            ambit = ambit.previous;
        }
        //System.out.println("Error semántico, no se encontró la variable a la cual se quiere asignar");
        return null;

    }
    public Boolean updateOneDimArray(String id, Object value,int index) {
        Ambit ambit = this;

        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                Symbol temp = ambit.variables.get(id);
                ArrayList obj = (ArrayList) temp.value;
                //System.out.println(index+"yyyy");
                obj.set(index-1,value);
                temp.value=obj;
                ambit.variables.put(id,temp);
                return true;
            }
            ambit = ambit.previous;
        }
        return false;

    }

    public Boolean updateOneDimArrayValues(String id, ArrayList<Object> values) {
        Ambit ambit = this;

        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                Symbol temp = ambit.variables.get(id);
                temp.value=values;
                ambit.variables.put(id,temp);
                return true;
            }
            ambit = ambit.previous;
        }
        return false;

    }
    public Boolean updateTwoDimArrayValues(String id, ArrayList<Object> values) {
        Ambit ambit = this;

        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                Symbol temp = ambit.variables.get(id);
                temp.value=values;
                ambit.variables.put(id,temp);
                return true;
            }
            ambit = ambit.previous;
        }
        return false;

    }

    public Boolean updateTwoDimArray(String id, Object value,int index1,int index2) {
        Ambit ambit = this;

        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                Symbol temp = ambit.variables.get(id);
                ArrayList obj = (ArrayList) temp.value;
                ArrayList obj2 = (ArrayList) obj.get(index1-1);;
                //System.out.println(index+"yyyy");
                obj2.set(index2-1,value);
                obj.set(index1-1,obj2);
                temp.value=obj;
                ambit.variables.put(id,temp);
                return true;
            }
            ambit = ambit.previous;
        }
        return false;

    }

    public Symbol getVal(String id,String line, String column) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.variables.containsKey(id)) {
                return ambit.variables.get(id);
            }
            ambit = ambit.previous;
        }
        //ErrorCollector errorHandler=ErrorCollector.getInstance();
        //errorHandler.errors.add(new Errors("Semantico","No se encontró la variable con el nombre '"+id+"'.",String.valueOf(line),String.valueOf(column)));
        return null;
    }

    public Boolean existOneDimArray(String id,String line, String column) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.oneArrays.containsKey(id)) {
                return true;
            }
            ambit = ambit.previous;
        }
        //ErrorCollector errorHandler=ErrorCollector.getInstance();
        //errorHandler.errors.add(new Errors("Semantico","No se encontró la variable con el nombre '"+id+"'.",String.valueOf(line),String.valueOf(column)));
        return false;
    }

    public Boolean existTwoDimArray(String id,String line, String column) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.twoArrays.containsKey(id)) {
                return true;
            }
            ambit = ambit.previous;
        }
        //ErrorCollector errorHandler=ErrorCollector.getInstance();
        //errorHandler.errors.add(new Errors("Semantico","No se encontró la variable con el nombre '"+id+"'.",String.valueOf(line),String.valueOf(column)));
        return false;
    }

    public Integer getOneDimSize(String id) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.oneArrays.containsKey(id)) {
                return ambit.oneArrays.get(id);
            }
            ambit = ambit.previous;
        }
        return null;
    }

    public Boolean booleanGetOneDimSize(String id) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.oneArrays.containsKey(id)) {
                return true;
            }
            ambit = ambit.previous;
        }
        return false;
    }

    public Boolean booleanGetTwoDimSize(String id) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.twoArrays.containsKey(id)) {
                return true;
            }
            ambit = ambit.previous;
        }
        return false;
    }


    /*public void saveOneArray(String id, Object value, ReturnType type, String line, String column) {
        this.oneArrays.put(id, function);
    }*/

    public void saveFunction(String id, Function function,String line, String column) {
        if(this.functions.containsKey(id)){
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Ya existe una función con el nombre '"+id+"'",String.valueOf(line),String.valueOf(column)));
        }else{
            this.functions.put(id, function);
        }

    }

    public Function getFunction(String id)  {
        Ambit ambit = this;
        while (ambit != null) {
            if (ambit.functions.containsKey(id)) {
                return ambit.functions.get(id);
            }
            ambit = ambit.previous;
        }
        return null;
    }

    public void saveSubroutine(String id, Subroutine subroutine,String line, String column) {
        if(this.subroutines.containsKey(id)){

            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Ya existe una Subrutina con el nombre '"+id+"'",String.valueOf(line),String.valueOf(column)));
        }else{
            this.subroutines.put(id, subroutine);
        }

    }

    public Subroutine getSubroutine(String id)  {
        Ambit ambit = this;
        while (ambit != null) {
            if (ambit.subroutines.containsKey(id)) {
                return ambit.subroutines.get(id);
            }
            ambit = ambit.previous;
        }
        return null;
    }
    public Ambit getGlobal() {
        Ambit ambit=this;
        while (ambit.previous != null) {
            ambit = ambit.previous;
        }
        return ambit;
    }

    public int getPrevSizes() {
        int size = 0;
        Ambit ambit=this.previous;
        while(ambit!=null){
            size += ambit.variables.size();
            ambit=ambit.previous;
        }
        return size;
    }



    public void newArrayOneDim(String id, ArrayList<Object> values, ReturnType type, String line, String column) {
        Ambit ambit = this;


        if (ambit.variables.containsKey(id)) {
            ErrorCollector errorHandler=ErrorCollector.getInstance();
            errorHandler.errors.add(new Errors("Semantico","Ya existe una variable con el nombre '"+id+"' en el entrono actual",String.valueOf(line),String.valueOf(column)));
        }else{
            this.position++;
            this.variables.put(id, new Symbol(values, id, type,line,column,this.position));
        }

    }

    public void sizeOneDim(String id, int size) {
        Ambit ambit = this;


        if (ambit.oneArrays.containsKey(id)) {
            System.out.println("Ya existe el array en este entorno con el mismo nombre!!!");
        }else{
            this.oneArrays.put(id, size);
        }

    }


    //Método que ingresa un nuevo arreglo de 2 dimensiones a una lista temporal.
    public void sizeTwoDim(String id, int size1,int size2) {
        Ambit ambit = this;
        //System.out.println(ambit);
        //System.out.println(ambit.twoArrays);
        ArrayList<Integer> sizes=new ArrayList<Integer>();
        sizes.add(size1);
        sizes.add(size2);

        if (ambit.twoArrays.containsKey(id)) {
            System.out.println("Ya existe el array en este entorno con el mismo nombre!!!");
        }else{
            this.twoArrays.put(id, sizes);
        }

    }

    public void updatesizeTwoDim(String id, int size1,int size2) {
        Ambit ambit = this;
        //System.out.println(ambit);
        //System.out.println(ambit.twoArrays);
        ArrayList<Integer> sizes=new ArrayList<Integer>();
        sizes.add(size1);
        sizes.add(size2);

        if (ambit.twoArrays.containsKey(id)) {
            this.twoArrays.put(id, sizes);
        }else{
            System.out.println("No se encontró el array");
        }

    }

    public void deallocateAnArray(String id, Object values) {
        Ambit ambit = this;
        if (ambit.variables.containsKey(id)) {
            Symbol temp= this.variables.get(id);
            temp.value=values;
            this.variables.put(id, temp);
        }else{
            System.out.println("No se encontró el array");
        }

    }
    public void deallocateSizeOfAnArray(String id){
        Ambit ambit = this;
        if (ambit.twoArrays.containsKey(id)) {
            ArrayList<Integer> sizes=new ArrayList<Integer>();
            sizes.add(-1);
            sizes.add(1);
            this.twoArrays.put(id, sizes);
        }else if(ambit.oneArrays.containsKey(id)){

            this.oneArrays.put(id,-1);
        }else{
            System.out.println("No se encontró el array");
        }
    }

    public Integer getFirstIndexArray(String id) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.twoArrays.containsKey(id)) {
                //System.out.println("buscandooooo");
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp=ambit.twoArrays.get(id);
                return temp.get(0);
            }
            ambit = ambit.previous;
        }
        //System.out.println("Error semántico, no se encontró la variable a la cual se quiere asignar");
        return null;
    }

    public Integer getSecondIndexArray(String id) {
        Ambit ambit= this;
        while (ambit != null) {
            if (ambit.twoArrays.containsKey(id)) {
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp=ambit.twoArrays.get(id);
                return temp.get(1);
            }
            ambit = ambit.previous;
        }
        //System.out.println("Error semántico, no se encontró la variable a la cual se quiere asignar");
        return null;
    }

    public void symbolsReport() {
        FileWriter powerful = null;
        PrintWriter writter = null;
        Date date = new Date();
        String datee = String.valueOf(date);
        try {
            powerful = new FileWriter("Reportes/SymbolReports.html");

            writter = new PrintWriter(powerful);
            writter.println(datee);
            writter.println("<!DOCTYPE html><!--Declarar el tipo de cumento -->\n"
                    + "<html>\n"
                    + "\n"
                    + "<!--Encabezado-->\n"
                    + "<head>\n"
                    + "<meta charset=\"UTF-8\"><!--codififcaion de caracteres ñ y á-->\n"
                    + "\n"
                    + "\n"
                    + "<meta name=\"name\" content=\"Reporte\">\n"
                    + "<meta name=\"description\" content=\"name\">\n"
                    + "<meta name=\"keywods\" content=\"uno,dos,tres\">\n"
                    + "<meta name=\"robots\" content=\"Index, Follow\">\n"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "\n"
                    + "\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\"/><!--css /estilo/tipo/ruta relativa -->\n"
                    + "\n"
                    + "<title>Symbols Report</title>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body bgcolor=”#6CFC07”>\n"
                    + "\n"
                    + "<center>");
            writter.println("<h1>" + "Tabla De Simbolos Compiladores 2 " + "</h1>");
            writter.println("<table width=\"500\" border=\"2\" cellpadding=\"5\">");
            writter.println("<tr>");
            writter.println("<th>Identifier</th>");
            writter.println("<th>Type</th>");
            writter.println("<th>value</th>");
            writter.println("<th>Line</th>");
            writter.println("<th>Column</th>");
            writter.println("<th>Ambit</th>");
            writter.println(" </tr>");
            //System.out.println(this.variables.size()+"#######");
            Ambit ambit= this;
            for (int i = 0; i < this.variables.size(); i++) {
                Object key=this.variables.keySet().toArray()[i];
                if(!this.oneArrays.containsKey(this.variables.get(key).getId()) && !this.twoArrays.containsKey(this.variables.get(key).getId())){
                    writter.println("<tr>");
                    writter.println("<td>"+this.variables.get(key).getId()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getType()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getValue().toString()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getLine()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getColumn()+"</td>");
                    writter.println("<td>"+ambit.name+"</td>");
                    writter.println(" </tr>");
                }

            }

            for (int i = 0; i < this.variables.size(); i++) {
                Object key=this.variables.keySet().toArray()[i];
                if(this.oneArrays.containsKey(this.variables.get(key).getId()) && !this.twoArrays.containsKey(this.variables.get(key).getId())){
                    int theSize=getOneDimSize(this.variables.get(key).getId());
                    writter.println("<tr>");
                    writter.println("<td>"+this.variables.get(key).getId()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getType()+"</td>");
                    writter.println("<td>"+"Size= "+theSize+"</td>");
                    writter.println("<td>"+this.variables.get(key).getLine()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getColumn()+"</td>");
                    writter.println("<td>"+ambit.name+"</td>");
                    writter.println(" </tr>");
                }


            }

            for (int i = 0; i < this.variables.size(); i++) {
                Object key=this.variables.keySet().toArray()[i];
                if(!this.oneArrays.containsKey(this.variables.get(key).getId()) && this.twoArrays.containsKey(this.variables.get(key).getId())){
                    int theSize=getFirstIndexArray(this.variables.get(key).getId())*getSecondIndexArray(this.variables.get(key).getId());
                    writter.println("<tr>");
                    writter.println("<td>"+this.variables.get(key).getId()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getType()+"</td>");
                    writter.println("<td>"+"Size= "+theSize+"</td>");
                    writter.println("<td>"+this.variables.get(key).getLine()+"</td>");
                    writter.println("<td>"+this.variables.get(key).getColumn()+"</td>");
                    writter.println("<td>"+ambit.name+"</td>");
                    writter.println(" </tr>");
                }


            }

            for (int i = 0; i < this.functions.size(); i++) {
                Object key=this.functions.keySet().toArray()[i];
                writter.println("<tr>");
                writter.println("<td>"+this.functions.get(key).id+"</td>");
                writter.println("<td>"+"Funcion"+"</td>");
                writter.println("<td>"+this.functions.get(key).returnId+"</td>");
                writter.println("<td>"+this.functions.get(key).line+"</td>");
                writter.println("<td>"+this.functions.get(key).column+"</td>");
                writter.println("<td>"+ambit.name+"</td>");
                writter.println(" </tr>");
            }

            for (int i = 0; i < this.subroutines.size(); i++) {
                Object key=this.subroutines.keySet().toArray()[i];
                writter.println("<tr>");
                writter.println("<td>"+this.subroutines.get(key).id+"</td>");
                writter.println("<td>"+"Subrutina"+"</td>");
                writter.println("<td>"+"null"+"</td>");
                writter.println("<td>"+this.subroutines.get(key).line+"</td>");
                writter.println("<td>"+this.subroutines.get(key).column+"</td>");
                writter.println("<td>"+ambit.name+"</td>");
                writter.println(" </tr>");
            }






            writter.println("</center>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != powerful) {
                    powerful.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
