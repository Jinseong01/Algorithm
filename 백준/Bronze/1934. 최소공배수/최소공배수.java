import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        // A와 B의 최소공배수
        // (A × B) = LCM(A, B) × GCD(A, B)
        // LCM(A, B) = (A * B) / GCD(A, B)
        // GCD(A, B) = GCD(B, A % B)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int res = (A * B) / GCD(A, B);
//            int res = (A * B) / BigInteger.valueOf(A).gcd(BigInteger.valueOf(B)).intValue();


            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
}