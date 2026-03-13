import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int count = 0;
            boolean valid = true;

            for(char c : input.toCharArray()) {
                if (c == '(') {
                    count++;
                }
                else {
                    count--;
                }

                if (count < 0) {
                    valid = false;
                    break;
                }
            }

            sb.append(valid && count == 0 ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            Stack<Character> stack = new Stack<>();
//            String input = br.readLine();
//            boolean valid = true;
//
//            for(char c : input.toCharArray()) {
//                if (c == '(') {
//                    stack.push(c);
//                }
//                else {
//                    if (stack.isEmpty()) {
//                        valid = false;
//                        break;
//                    }
//                    stack.pop();
//                }
//            }
//
//            sb.append(valid && stack.isEmpty() ? "YES" : "NO").append("\n");
//        }
//
//        System.out.println(sb);
//    }
//}