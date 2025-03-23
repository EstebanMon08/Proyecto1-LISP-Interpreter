import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PruebasUnitarias {

    @Test
    public void testLexerTokenize() {
        Lexer lexer = new Lexer("(+ 2 3)");
        List<String> tokens = lexer.tokenize();
        
        List<String> expectedTokens = Arrays.asList("(", "+", "2", "3", ")");
        
        assertEquals("Los tokens deberían coincidir con la expresión de entrada", expectedTokens, tokens);
    }

    @Test
    public void testEvaluatorSuma() {
        Map<String, Object> env = new HashMap<>();
        List<Object> expr = Arrays.asList("+", 2, 3);

        Object resultado = Evaluator.eval(expr, env);

        assertEquals("La suma de 2 + 3 debería ser 5", 5, resultado);
    }

    @Test
    public void testParserSimple() {
        List<String> tokens = Arrays.asList("(", "+", "1", "2", ")");
        Parser parser = new Parser(tokens);
        Object parsedExpr = parser.parse();

        List<Object> expectedExpr = Arrays.asList("+", 1, 2);

        assertEquals("El parser debería convertir los tokens en una lista de expresión correcta", expectedExpr, parsedExpr);
    }
}
