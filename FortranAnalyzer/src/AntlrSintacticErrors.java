import Extra.ErrorCollector;
import Extra.Errors;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.*;
public class AntlrSintacticErrors extends BaseErrorListener {
    public static final AntlrSintacticErrors INSTANCE = new AntlrSintacticErrors();


    @Override
    public void syntaxError(org.antlr.v4.runtime.Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, org.antlr.v4.runtime.RecognitionException e) {
        ErrorCollector errorHandler=ErrorCollector.getInstance();
        errorHandler.errors.add(new Errors("Sintactico",msg,String.valueOf(line),String.valueOf(charPositionInLine)));
        //System.out.println("line " + line + ":" + charPositionInLine + " " + offendingSymbol+" -----------"+msg);

    }
}
