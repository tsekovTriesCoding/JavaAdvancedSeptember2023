package A1StacksAndQueues.Exercise;

import java.util.*;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        Map<String, Integer> precedenceMap = new LinkedHashMap<>();

        precedenceMap.put("+", 2);
        precedenceMap.put("-", 2);
        precedenceMap.put("*", 3);
        precedenceMap.put("/", 3);
        precedenceMap.put("(", 0);

        for (String token : tokens) {
            if (isNumberOrLetter(token)) {
                outputQueue.offer(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedenceMap.get(operatorStack.peek()) >= precedenceMap.get(token)) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                String symbol = operatorStack.pop();
                while (!symbol.equals("(")) {
                    outputQueue.offer(symbol);
                    symbol = operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.addLast(operatorStack.pop());
        }

        while (outputQueue.size() > 0) {
            System.out.print(outputQueue.pop() + " ");
        }
    }

    private static boolean isOperator(String token) {
        if (token.equals("+")) {
            return true;
        } else if (token.equals("-")) {
            return true;
        } else if (token.equals("*")) {
            return true;
        } else if (token.equals("/")) {
            return true;
        }

        return false;
    }

    private static boolean isNumberOrLetter(String token) {

        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")
                && !token.equals("(") && !token.equals(")");
    }
}
