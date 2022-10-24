package Extra;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class ErrorCollector {
    public ArrayList <Errors> errors;
    public static ErrorCollector instance;

    private ErrorCollector() {
        this.errors = new ArrayList<Errors>();
    }

    public static ErrorCollector getInstance() {
        if (instance == null){
            instance = new ErrorCollector();
        }

        return instance;
    }

    public void errorsReport() {
        FileWriter powerful = null;
        PrintWriter writter = null;
        Date date = new Date();
        String datee = String.valueOf(date);
        try {
            powerful = new FileWriter("Reportes/ErrorsReport.html");

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
                    + "<title>Errors Report</title>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body bgcolor=”#6CFC07”>\n"
                    + "\n"
                    + "<center>");
            writter.println("<h1>" + "Reportes De Errores Compiladores 2 " + "</h1>");
            writter.println("<table width=\"500\" border=\"2\" cellpadding=\"5\">");
            writter.println("<tr>");
            writter.println("<th>TIPO</th>");
            writter.println("<th>DESCRIPCIÓN</th>");
            writter.println("<th>FILA</th>");
            writter.println("<th>COLUMNA</th>");
            writter.println(" </tr>");
            for (int i = 0; i < this.errors.size(); i++) {
                writter.println("<tr>");
                writter.println("<td>"+this.errors.get(i).type+"</td>");
                writter.println("<td>"+this.errors.get(i).description+"</td>");
                writter.println("<td>"+this.errors.get(i).line+"</td>");
                writter.println("<td>"+this.errors.get(i).column+"</td>");
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
