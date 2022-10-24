
//import Ambit.Ambit;
import Extra.ErrorCollector;
import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import Interpreter.Interpreter;
import com.sun.tools.javac.Main;
import org.antlr.v4.runtime.*;
import Grammar.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;

import java.io.*;

import static org.antlr.v4.runtime.CharStreams.fromString;
//import Ambit.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Ambit.*;
import Instruction.*;
import Grammar.*;
import Instruction.Instruction;
import ThreeWayCode.ThreeWayCode;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.file.Files;
import org.antlr.v4.runtime.tree.ParseTree;
import org.snt.inmemantlr.exceptions.*;
import org.snt.inmemantlr.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import static org.antlr.v4.runtime.CharStreams.fromString;



public class LoginModule {
    /*Variable global, área de texto que mostrará el texto del archivo
    de entrada*/
    public static  JTextArea textEdition1;
    /*Variable global, área de texto que mostrará todo lo relacionado
    a las salidas*/
    public static  JTextArea textEdition2;
    public static  JTextArea textEdition3;
    /*Un simple Scroll para el área de texto 1 (Entrada).*/
    public static JScrollPane scrollEdition1;
    /*Un simple Scroll para el área de texto 2 (Salidas).*/
    public static JScrollPane scrollEdition2;
    public static JScrollPane scrollEdition3;

    static FilesManipulation filesManipulationHandler = new FilesManipulation();

    static ArrayList<String> LineNum = new ArrayList<String>();
    static ArrayList<String> Type = new ArrayList<String>();
    static ArrayList<String> Content = new ArrayList<String>();
    static GrammarParser grammarParser;
    static GrammarParser.StartContext startContext;
    static Ambit globalAmbit = new Ambit(null,"Global");


    public static void main(String[] args) throws IOException {
        loginFrameModule();
    }
    //Frame para iniciar sesión, y poder usar la app.
    public static void loginFrameModule() throws IOException {

        //Creamos unos tipos de letra, que nos servirán más adelante
        Font font =new Font("Arial",Font.BOLD,50);
        Font font2 =new Font("Helvetica",Font.BOLD,30);
        Font font3 =new Font("Showcard Gothic",Font.BOLD,30);
        //=========================Creación del Frame Login Principal=========================

        //Se crea el frame y se le agrega un título
        JFrame loginFrame = new JFrame("OLC2");
        loginFrame.setLayout(null);
        //Se hace visible el frame
        loginFrame.setVisible(true);
        // Se restringe al frame a no poder cambiar de tamaño
        loginFrame.setResizable(false);
        //Se le coloca un color de fondo al frame
        loginFrame.getContentPane().setBackground(Color.BLUE);
        //Se le indica al frame que hacer en caso de que se cierre el mismo,
        //en este caso la aplicación termina su ejecución
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Con esto obtenemos las dimensiones de resolución de pantlla
        Toolkit myScreen= Toolkit.getDefaultToolkit();
        Dimension sizeScreen = myScreen.getScreenSize();
        // Guardamos la altura de la dimension de pantalla
        int h= sizeScreen.height;
        // Guardamos la anchura de la dimension de pantalla
        int w= sizeScreen.width;
        //Le agreamos un tamaño al frame login
        loginFrame.setSize(1080,720);
        //Le agreamos una locación al frame login
        loginFrame.setLocation(w/4,h/4);
        //Le agreamos un  ícono al frame login
        Image myIcon= myScreen.getImage("iconoLogin.png");
        loginFrame.setIconImage(myIcon);
        //loginFrame.setLayout(new BorderLayout());







        //=========================Creación de Labels =========================
        //label que nos muestra el mensaje "OLC2"
        JLabel titleL = new JLabel("COMPI 02");
        titleL.setLayout(null);
        titleL.setVisible(true);
        titleL.setForeground(Color.BLACK);
        titleL.setBounds(420,10,400,60);
        titleL.setFont(font);
        loginFrame.add(titleL);
        //label que dice ingresar el nombre de usuario
        JLabel usernameL = new JLabel("UserName: ");
        usernameL.setLayout(null);
        usernameL.setVisible(true);
        usernameL.setForeground(Color.BLACK);
        usernameL.setBounds(220,150,250,30);
        usernameL.setFont(font3);
        loginFrame.add(usernameL);
        //label que dice ingresar contraseña
        JLabel passwordL = new JLabel("PASSWORD: ");
        passwordL.setLayout(null);
        passwordL.setVisible(true);
        passwordL.setForeground(Color.BLACK);
        passwordL.setBounds(220,250,300,30);
        passwordL.setFont(font3);
        loginFrame.add(passwordL);


        //=========================Creación de los campos de texto=========================
        //Creamos el campo de texto que recibirá el nombre de usuario
        JTextField usernameTF = new JTextField();
        usernameTF.setLayout(null);
        usernameTF.setVisible(true);
        usernameTF.setBounds(450,145,350,40);
        usernameTF.setFont(font2);
        usernameTF.setBackground(Color.red);
        loginFrame.add(usernameTF);

        //Creamos el campo de texto que recibirá la contraseña
        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setBounds(450,245,350,40);
        passwordTF.setVisible(true);
        passwordTF.setLayout(null);
        passwordTF.setFont(font2);
        passwordTF.setBackground(Color.red);
        loginFrame.add(passwordTF);
        //=========================Creación del Botón Inicio de sesión=========================
        //Creamos un botón de inicio de Sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setLayout(null);
        loginButton.setVisible(true);
        loginButton.setBounds(380, 420, 300, 100);
        loginButton.setFont(font3);
        loginButton.setBackground(Color.yellow);
        loginButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                try {
                    LoginMethod login_handler = LoginMethod.getInstance();
                    if (login_handler.loginAuthentication(usernameTF.getText(), passwordTF.getText())) {
                        System.out.println("Bievenido");
                        JOptionPane.showMessageDialog(null,"<html><p style=\"color:green; font:20px;\">Inicio De Sesión Exitoso Admin!!</p></html>" );
                        loginFrame.dispose();
                        pMasterMindFrame();
                    }else{
                        JOptionPane.showMessageDialog(null,"<html><p style=\"color:red; font:20px;\">Usuario / Contraseña Incorrectos, Intente De Nuevo!!</p></html>" );
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LoginModule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        loginFrame.add(loginButton);
        loginFrame.repaint();
    }



    public static void pMasterMindFrame() throws IOException {

        //Creamos unos tipos de letra, que nos servirán más adelante
        Font font =new Font("Arial",Font.BOLD,36);
        Font font2 =new Font("Helvetica",Font.BOLD,20);
        Font font3 =new Font("Helvetica",Font.BOLD,40);


        //=========================Creación del Frame del Admin==============================

        //Se crea el frame y se le agrega un título
        JFrame managerFrame = new JFrame("Compi2----Erwin14k");
        managerFrame.setLayout(null);

        //Se hace visible el frame
        managerFrame.setVisible(true);
        // Se restringe al frame a no poder cambiar de tamaño
        managerFrame.setResizable(false);
        //Se le coloca un color de fondo al frame
        managerFrame.getContentPane().setBackground(Color.ORANGE);
        //Se le indica al frame que hacer en caso de que se cierre el mismo,
        //en este caso la aplicación termina su ejecución
        managerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Con esto obtenemos las dimensiones de resolución de pantlla
        //Toolkit myScreen= Toolkit.getDefaultToolkit();

        // Guardamos la altura de la dimension de pantalla
        //int h= sizeScreen.height;
        // Guardamos la anchura de la dimension de pantalla
        //int w= sizeScreen.width;
        //Le agreamos un tamaño al frame admin
        managerFrame.setSize(1360,750);
        //Le agreamos una locación al frame admin
        //managerFrame.setLocation(w/4,h/4);
        //Le agreamos un  ícono al frame admin
        //Image myIcon= myScreen.getImage("iconoLogin.png");
        //managerFrame.setIconImage(myIcon);


        //=========================Creación de los  Botones del frame admin=========================
        //Creamos un botón de Abrir documento
        JButton openButton = new JButton("Abrir");
        openButton.setLayout(null);
        openButton.setVisible(true);
        openButton.setBounds(10, 10, 120, 60);
        openButton.setBackground(Color.green);
        openButton.setForeground(Color.blue);
        openButton.setFont(new Font("cooper black",3,20));

        openButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser browser = new JFileChooser();
                browser.showOpenDialog(openButton);
                File file = browser.getSelectedFile();
                if(file!=null){
                    textEdition1.setText(filesManipulationHandler.readFile(file.getAbsolutePath()));
                }
            }
        });
        managerFrame.add(openButton);


        //Creamos un botón de Guardar
        JButton interpretButton = new JButton("Interpretar");
        interpretButton.setLayout(null);
        interpretButton.setVisible(true);
        interpretButton.setBounds(140, 10, 180, 60);
        interpretButton.setBackground(Color.green);
        interpretButton.setForeground(Color.blue);
        interpretButton.setFont(new Font("cooper black",3,20));
        interpretButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                CharStream cs = fromString(textEdition1.getText());
                GrammarLexer grammarLexer = new GrammarLexer(cs);
                grammarLexer.removeErrorListeners();
                grammarLexer.addErrorListener(AntlrLexicErrors.INSTANCE);
                CommonTokenStream commonTokenStream = new CommonTokenStream(grammarLexer);
                grammarParser = new GrammarParser(commonTokenStream);
                grammarParser.removeErrorListeners();
                grammarParser.addErrorListener(AntlrSintacticErrors.INSTANCE);
                startContext = grammarParser.start();
                //GrammarParser.StartContext startContext2 = grammarParser.start();
                Visitor visitor = new Visitor();

                Object treeAst = visitor.visit(startContext);
                for (Object item: (List) treeAst) {
                    if(item!=null){
                        ((Instruction) item).execute(globalAmbit);
                    }

                }
                Interpreter interpreterHandler= Interpreter.getInstance();
                textEdition2.setText(interpreterHandler.console);




            }
        });
        managerFrame.add(interpretButton);




        //Creamos un botón de Guardar Como
        JButton translateButton = new JButton("Traducir");
        translateButton.setLayout(null);
        translateButton.setVisible(true);
        translateButton.setBounds(330, 10, 200, 60);
        translateButton.setBackground(Color.green);
        translateButton.setForeground(Color.blue);
        translateButton.setFont(new Font("cooper black",3,20));
        translateButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //Segunda pasada
                Visitor3D secondVisit = new Visitor3D();
                Object treeAst2 = secondVisit.visit(startContext);
                for (Object item: (List<?>) treeAst2) {
                    if(item!=null){
                        ((Instruction) item).c3d(globalAmbit);
                    }

                }

                ///Pruebas con c3d
                ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
                threeWayCodeHandler.joinTheCode();
                textEdition3.setText(threeWayCodeHandler.code);



            }
        });
        managerFrame.add(translateButton);

        //Creamos un botón de Nuevo archivo, vaciará el área de texto de edición.
        JButton errorsButton = new JButton("Errors/Symbols");
        errorsButton.setLayout(null);
        errorsButton.setVisible(true);
        errorsButton.setBounds(540, 10, 250, 60);
        errorsButton.setBackground(Color.green);
        errorsButton.setForeground(Color.blue);
        errorsButton.setFont(new Font("cooper black",3,20));

        errorsButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
                ErrorCollector errorHandler=ErrorCollector.getInstance();
                errorHandler.errorsReport();
                globalAmbit.symbolsReport();


            }
        });
        managerFrame.add(errorsButton);


        //Creamos un botón de Generación de Reportes
        JButton astButton = new JButton("AST");
        astButton.setLayout(null);
        astButton.setVisible(true);
        astButton.setBounds(800, 10, 250, 60);
        astButton.setBackground(Color.green);
        astButton.setForeground(Color.blue);
        astButton.setFont(new Font("cooper black",3,20));

        astButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e4){
                Interpreter interpreterHandler=Interpreter.getInstance();
                generateAST(startContext, false, 0);
                interpreterHandler.astCode+="digraph G {\n";
                printDOT();
                interpreterHandler.astCode+="}\n";

                System.out.println(interpreterHandler.astCode);
                try {
                    graphAst();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        managerFrame.add(astButton);

        //Se crea el objeto de área de texto
        textEdition1 = new javax.swing.JTextArea();
        textEdition1.setFont(font2);
        textEdition1.setVisible(true);
        //Se crea el objeto de la barra scroll
        scrollEdition1 = new JScrollPane(textEdition1);
        scrollEdition1.setBounds(20, 150, 625, 520);
        scrollEdition1.setVisible(true);
        scrollEdition1.setViewportView(textEdition1);
        //Se agrega el scroll con el text area dentro de él al frame.
        managerFrame.add(scrollEdition1);

        //label que indica el área de texto de salida.
        JLabel outsLabel = new JLabel("Interprete: ");
        outsLabel.setLayout(null);
        outsLabel.setVisible(true);
        outsLabel.setForeground(Color.BLACK);
        outsLabel.setBounds(700,100,250,30);
        outsLabel.setFont(font3);
        managerFrame.add(outsLabel);

        //label que indica el área de texto de salida.
        JLabel c3dLabel = new JLabel("Traductor: ");
        c3dLabel.setLayout(null);
        c3dLabel.setVisible(true);
        c3dLabel.setForeground(Color.BLACK);
        c3dLabel.setBounds(700,380,250,30);
        c3dLabel.setFont(font3);
        managerFrame.add(c3dLabel);

        //label que indica el área de texto de entrada.
        JLabel entryLabel = new JLabel("Entrada: ");
        entryLabel.setLayout(null);
        entryLabel.setVisible(true);
        entryLabel.setForeground(Color.BLACK);
        entryLabel.setBounds(20,100,250,30);
        entryLabel.setFont(font3);
        managerFrame.add(entryLabel);

        //Se crea el objeto de área de texto de salidas
        textEdition2 = new javax.swing.JTextArea();
        textEdition2.setFont(font2);
        textEdition2.setVisible(true);
        //Se crea el objeto de la barra scroll
        scrollEdition2 = new JScrollPane(textEdition2);
        scrollEdition2.setBounds(700, 150, 625, 225);
        scrollEdition2.setVisible(true);
        scrollEdition2.setViewportView(textEdition2);
        //Se agrega el scroll con el text area dentro de él al frame.
        managerFrame.add(scrollEdition2);

        //Se crea el objeto de área de texto de salidas
        textEdition3 = new javax.swing.JTextArea();
        textEdition3.setFont(font2);
        textEdition3.setVisible(true);
        //Se crea el objeto de la barra scroll
        scrollEdition3 = new JScrollPane(textEdition3);
        scrollEdition3.setBounds(700, 420, 625, 245);
        scrollEdition3.setVisible(true);
        scrollEdition3.setViewportView(textEdition3);
        //Se agrega el scroll con el text area dentro de él al frame.
        managerFrame.add(scrollEdition3);


        JButton cstButton = new JButton("CST");
        cstButton.setLayout(null);
        cstButton.setVisible(true);
        cstButton.setBounds(1060, 10, 200, 60);
        cstButton.setBackground(Color.green);
        cstButton.setForeground(Color.blue);
        cstButton.setFont(new Font("cooper black",3,20));
        cstButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                List<String> ruleNames = Arrays.asList(grammarParser.getRuleNames());
                TreeViewer treeViewer = new TreeViewer(ruleNames, startContext);
                treeViewer.open();
            }
        });
        managerFrame.add(cstButton);
        managerFrame.repaint();
    }

    private static void generateAST(RuleContext ctx, boolean verbose, int indentation) {
        boolean toBeIgnored = !verbose && ctx.getChildCount() == 1 && ctx.getChild(0) instanceof ParserRuleContext;

        if (!toBeIgnored) {
            String ruleName = grammarParser.ruleNames[ctx.getRuleIndex()];
            LineNum.add(Integer.toString(indentation));
            Type.add(ruleName);
            Content.add(ctx.getText());
        }
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                generateAST((RuleContext) element, verbose, indentation + (toBeIgnored ? 0 : 1));
            }
        }
    }

    private static void printDOT(){
        printLabel();
        Interpreter interpreterHandler=Interpreter.getInstance();
        int pos = 0;
        for(int i=1; i<LineNum.size();i++){
            pos=getPos(Integer.parseInt(LineNum.get(i))-1, i);
            interpreterHandler.astCode+=(Integer.parseInt(LineNum.get(i))-1)+Integer.toString(pos)+"->"+LineNum.get(i)+i+"\n";
        }
    }

    private static void printLabel(){
        Interpreter interpreterHandler=Interpreter.getInstance();
        for(int i =0; i<LineNum.size(); i++){
            if(Type.get(i).equals("expr")){
                interpreterHandler.astCode+=LineNum.get(i)+i+"[label=\""+"\\n "+Content.get(i).replaceAll("\"","")+" \"]"+"\n";
            }else{
                interpreterHandler.astCode+=LineNum.get(i)+i+"[label=\""+Type.get(i)+" \"]"+"\n";
            }
        }
    }

    private static int getPos(int n, int limit){
        int pos = 0;
        for(int i=0; i<limit;i++){
            if(Integer.parseInt(LineNum.get(i))==n){
                pos = i;
            }
        }
        return pos;
    }

    public static void graphAst() throws IOException{
        Interpreter interpreterHandler=Interpreter.getInstance();
        String route="Reportes/AST.txt";
        String graph="Reportes/AST.png";
        String tParam = "-Tpng";
        String tOParam = "-o";
        String pathString = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
        FileWriter fw = new FileWriter(route);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(interpreterHandler.astCode);
        bw.close();

        String[] cmd = new String[5];
        cmd[0] = pathString;
        cmd[1] = tParam;
        cmd[2] = route;
        cmd[3] = tOParam;
        cmd[4] = graph;

        Runtime rt = Runtime.getRuntime();

        rt.exec( cmd );
    }
}
