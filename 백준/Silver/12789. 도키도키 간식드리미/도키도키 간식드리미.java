import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == student) {
                student++;
                while (!stack.isEmpty() && stack.peek() == student) {
                    stack.pop();
                    student++;
                }
            }
            else {
                stack.push(num);
            }
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}