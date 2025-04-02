import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();

            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
