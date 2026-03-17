import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int []> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            sb.append(cur[0]).append(" ");

            if (queue.isEmpty()) break;

            int move = cur[1];

            if (move > 0) {
                move = (move-1) % queue.size();
                for (int i = 0; i < move; i++) {
                    queue.add(queue.poll());
                }
            }
            else {
                move = (-move) % queue.size();
                for (int i = 0; i < move; i++) {
                    queue.addFirst(queue.pollLast());
                }
            }
        }

        System.out.print(sb);
    }
}