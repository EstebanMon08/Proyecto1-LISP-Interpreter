import java.util.*;
import java.util.Scanner;

/**
 * LispInterpreter es el intérprete principal que maneja la entrada del usuario.
 */
public class LispInterpreter {

    /**
     * Método principal que ejecuta el intérprete de Lisp.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> env = new HashMap<>();
        
        while (true) {
            System.out.print("Codigo Lisp: ");
            String code = scanner.nextLine();
            if (code.equals("exit")) break;
            
            try {
                Lexer lexer = new Lexer(code);
                List<String> tokens = lexer.tokenize();
                Parser parser = new Parser(tokens);
                Object parsedExpr = parser.parse();
                System.out.println(Evaluator.eval(parsedExpr, env));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}