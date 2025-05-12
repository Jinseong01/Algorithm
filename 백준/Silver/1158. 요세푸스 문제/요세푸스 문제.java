import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size() != 1) {
            // K-1까지는 뒤로 보내고
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }

            // K번째 추출
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}