import Extra.ErrorCollector;
import Extra.Errors;
import org.antlr.v4.runtime.*;
public class AntlrLexicErrors extends BaseErrorListener {
    public static final AntlrLexicErrors INSTANCE = new AntlrLexicErrors();


    @Override
    public void syntaxError(org.antlr.v4.runtime.Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, org.antlr.v4.runtime.RecognitionException e) {
        //System.out.println("line " + line + ":" + charPositionInLine + " " + offendingSymbol+" -----------"+msg);
        ErrorCollector errorHandler=ErrorCollector.getInstance();
        errorHandler.errors.add(new Errors("Lexico",msg,String.valueOf(line),String.valueOf(charPositionInLine)));

    }
}