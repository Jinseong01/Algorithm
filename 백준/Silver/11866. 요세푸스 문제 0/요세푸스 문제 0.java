import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        bw.write("<");

        while (q.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                int tmp = q.poll();
                q.add(tmp);
            }
            bw.write(q.poll() + ", ");
        }
        bw.write(q.poll() + ">");

        bw.flush();
        bw.close();
        br.close();
    }
}