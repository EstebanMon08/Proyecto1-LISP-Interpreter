import java.util.*;
/**
 * Evaluator es una clase que evalúa las expresiones analizadas.
 */
class Evaluator {

    /**
     * Evalúa una expresión en un entorno dado.
     * 
     * @param expr La expresión a evaluar.
     * @param env El entorno donde se definen las variables.
     * @return El resultado de la evaluación de la expresión.
     */
    public static Object eval(Object expr, Map<String, Object> env) {
        if (expr instanceof String) {
            return env.get(expr);
        } else if (expr instanceof Integer) {
            return expr;  // Retorna el valor tal cual si es un número entero
        } else if (expr instanceof List) {
            List<?> list = (List<?>) expr;
            if (list.isEmpty()) return null;

            String op = (String) list.get(0);
            List<Object> args = new ArrayList<>(list.subList(1, list.size())); // Cambié de subList a nuevo ArrayList
            
            switch (op) {
                case "+": return args.stream().mapToInt(a -> (int) eval(a, env)).sum();  // Cambié de Double a Integer
                case "-": 
                    return (int) eval(args.get(0), env) - args.subList(1, args.size()).stream().mapToInt(a -> (int) eval(a, env)).sum();  // Cambié de Double a Integer
                case "*": 
                    return args.stream().mapToInt(a -> (int) eval(a, env)).reduce(1, (a, b) -> a * b);  // Cambié de Double a Integer
                case "/": 
                    return args.stream().mapToInt(a -> (int) eval(a, env)).reduce((a, b) -> a / b).orElseThrow();  // Cambié de Double a Integer
                case "define":
                    env.put((String) args.get(0), eval(args.get(1), env));
                    return null;
                default:
                    throw new RuntimeException("Operación desconocida: " + op);
            }
        }
        return null;
    }
}