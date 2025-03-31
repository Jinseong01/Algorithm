import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;  
            } 
            bw.write(isValid ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
