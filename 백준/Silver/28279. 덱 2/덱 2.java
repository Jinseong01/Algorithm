import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int X = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    X = Integer.parseInt(st.nextToken());
                    deque.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    deque.addLast(X);
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case 7:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 8:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}