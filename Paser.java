import java.util.*;
/**
 * Parser es una clase encargada de analizar los tokens y convertirlos en una estructura de datos.
 */
class Parser {
    private List<String> tokens;
    private int pos;

    /**
     * Constructor que toma la lista de tokens.
     * 
     * @param tokens La lista de tokens que se van a analizar.
     */
    public Parser(List<String> tokens) {
        this.tokens = tokens;
        this.pos = 0;
    }

    /**
     * Analiza los tokens y devuelve una estructura de datos correspondiente a la expresión.
     * 
     * @return La expresión analizada, que puede ser una lista o un número.
     */
    public Object parse() {
        if (pos >= tokens.size()) return null;
        String token = tokens.get(pos++);
        if ("(".equals(token)) {
            List<Object> list = new ArrayList<>();
            while (!tokens.get(pos).equals(")")) {
                list.add(parse());
            }
            pos++; // consume ')'
            return list;
        } else if (")".equals(token)) {
            throw new RuntimeException("Unexpected )");
        } else {
            try {
                return Integer.parseInt(token);  // Cambié esto de Double a Integer
            } catch (NumberFormatException e) {
                return token;
            }
        }
    }
}