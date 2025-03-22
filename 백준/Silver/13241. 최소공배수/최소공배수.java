import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 최소공배수 = 두 수의 곱 / 최대공약수
        // 유클리드 호제법 이용
        // A, B의 최대공약수 = B, (A%B)의 최대 공약수 = ...
        long lcm = A * B / gcd(A, B);

        bw.write(lcm + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}