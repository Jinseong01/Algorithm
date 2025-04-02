import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            // 입려에 대해 검사
            if (count == x) {
                count++;
            }
            else {
                stack.push(x);
            }

            // 스택 검사
            while (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            }
        }


        if (stack.isEmpty()) {
            bw.write("Nice\n");
        }
        else {
            bw.write("Sad\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}