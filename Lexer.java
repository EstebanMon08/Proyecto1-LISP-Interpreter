import java.util.*;

/**
 * Lexer es una clase encargada de tokenizar la entrada en una lista de tokens.
 */
class Lexer {
    private String input;

    /**
     * Constructor que toma la entrada y reemplaza los paréntesis por espacios.
     * 
     * @param input La cadena de entrada a ser tokenizada.
     */
    public Lexer(String input) {
        this.input = input.replace("(", " ( ").replace(")", " ) ");
    }

    /**
     * Tokeniza la entrada en una lista de tokens.
     * 
     * @return Una lista de tokens.
     */
    public List<String> tokenize() {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}