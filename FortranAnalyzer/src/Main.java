import Extra.*;
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
import Ambit.*;
public class Main {
    static ArrayList<String> LineNum = new ArrayList<String>();
    static ArrayList<String> Type = new ArrayList<String>();
    static ArrayList<String> Content = new ArrayList<String>();
    static GrammarParser grammarParser;
    public static void main(String[] args) throws IOException {
        LoginModule.loginFrameModule();




    }




}