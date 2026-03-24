package BalanceoExpresion;

import java.util.Stack;

public class BalanceoExpresion {

    public static boolean estaBalanceado(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {

                if (pila.isEmpty()) {
                    return false;
                }

                char tope = pila.pop();

                if ((c == ')' && tope != '(') ||
                    (c == '}' && tope != '{') ||
                    (c == ']' && tope != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {

        // Expresiones de prueba (automático)
        String[] pruebas = {
            "((a+b)*5)-7",
            "2*((a+b)/2.5 + x - 7*y",
            "{[()]}",
            "{[(])}"
        };

        for (String exp : pruebas) {
            if (estaBalanceado(exp)) {
                System.out.println(exp + " → BALANCEADA");
            } else {
                System.out.println(exp + " → NO balanceada");
            }
        }
    }
}