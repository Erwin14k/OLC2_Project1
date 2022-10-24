
import java.io.*;

public class FilesManipulation {
    public String route;
    public FilesManipulation(){}

    private static FilesManipulation instance;
    /*Función que devuelve la instancia de esta clase para trabajarla con
    un manejador, y así poder trasladar información de manera eficiente.*/
    public static FilesManipulation getInstance() {
        if(instance == null) {
            instance = new FilesManipulation();
        }
        return instance;
    }

    /*Función que sirve para leer el archivo de entrada, el parámetro, que
    recibe, es una ruta de un fileChooser, y como resultado nos devuelve
    el texto del archivo de entrada para poder mostrarlo en el área de texto.*/
    public String readFile(String route){
        String tempText = "";
        String line = "";
        this.route = route;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(route));
            while(((line=bf.readLine())!=null)){
                tempText += line+"\n";
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return tempText;
    }

    /*Método guardar como, en pocas palabras recibe la ruta de donde se quiere
    guardar el archivo, además como el texto que se desea guardar en el*/
    public void newFileCreation(String route,String updatedContent){
        File file;
        try{
            file = new File(route);
            if(file.createNewFile()){
                FileWriter fileW=new FileWriter(file);
                BufferedWriter bufferedF=new BufferedWriter(fileW);
                PrintWriter printW=new PrintWriter(bufferedF);
                try{
                    printW.write(updatedContent);
                    printW.close();
                    bufferedF.close();
                }catch(Exception e){
                    System.out.println(e.toString());
                }
                //Si todo sale bien, se crea un nuevo archivo.
                System.out.println("¡New File was created!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    /*Método para guardar el archivo actual con el texto actualizado,
    tomar en cuenta que no se crea un archivo nuevo, solo lo guarda.*/
    public void saveFile(String updatedContent) throws IOException{
        File file=new File(this.route);
        FileWriter fileW=new FileWriter(file);
        BufferedWriter bufferedF=new BufferedWriter(fileW);
        PrintWriter printW=new PrintWriter(bufferedF);
        try{
            printW.write(updatedContent);
            printW.close();
            bufferedF.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public boolean isExpExtension(String route){
        int index = route.lastIndexOf(".");
        boolean isExp=false;
        if(route.substring(index+1).toString().equals("exp")){
            isExp = true;
        }
        return isExp;
    }
}