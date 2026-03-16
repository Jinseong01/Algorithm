import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "1":
                    queue.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "3":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "4":
                    sb.append(queue.isEmpty() ? -1 : queue.pollLast()).append("\n");
                    break;
                case "5":
                    sb.append(queue.size()).append("\n");
                    break;
                case "6":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "8":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}