import java.io.*;
import java.util.*;

public class Main {

    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combination(M, N)).append("\n");
        }

        System.out.print(sb);
    }

    private static long combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        // 이미 계산된 값이면 재사용
        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        // 없으면 계산 후 저장
        // nCr = (n-1)C(r-1) + (n-1)Cr
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            sb.append(combination(M, N)).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    private static long combination(int n, int r) {
//        r = Math.min(r, n - r);
//
//        long result = 1;
//        for (int i = 1; i <= r; i++) {
//            result = result * (n - i + 1) / i;
//        }
//
//        return result;
//    }
//}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            sb.append(combination(M, N)).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    private static long combination(int n, int r) {
//        long result = 1;
//        for (int i = 1; i <= r; i++) {
//            result = result * (n - i + 1) / i;
//        }
//
//        return result;
//    }
//}