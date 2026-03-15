import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            sb.append(stack.isEmpty() && valid ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }
}