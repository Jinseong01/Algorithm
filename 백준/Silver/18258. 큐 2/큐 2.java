import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            switch (order) {
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!deque.isEmpty()) {
                        bw.write(deque.poll()+"\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    else {
                        bw.write("-1\n");
                    }
                    break;
                case "back":
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