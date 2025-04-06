import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
                        bw.write(deque.pollFirst() + "\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
                case 5:
                    bw.write(deque.size() + "\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case 7:
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
                case 8:
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekLast() + "\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}