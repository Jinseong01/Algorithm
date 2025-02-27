import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)
        // f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지
        // f(n) = a1*n+a0, g(n)=n

        int fn0 = (a1 * n0 + a0 <= c * n0 && a1 <= c)? 1 : 0;

        bw.write(fn0 + "\n");
        bw.flush();
        bw.close();
    }
}