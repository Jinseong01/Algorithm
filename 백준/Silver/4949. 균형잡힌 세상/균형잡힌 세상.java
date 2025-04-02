import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            Stack<Character> stack = new Stack<>();

            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            for (char c : input.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            stack.push(c);
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            stack.push(c);
                        }
                        break;
                }
            }
            if (stack.isEmpty()) {
                bw.write("yes\n");
            }
            else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}