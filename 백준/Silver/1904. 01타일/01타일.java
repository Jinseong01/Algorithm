import java.io.*;

public class Main {

    static int[] dp;  // dp[i] = i에서 시작해서 N까지 가는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 1;  // 1
        if (N >= 2) {
            dp[2] = 2;  // 00, 11
        }

        for (int i = 3; i <= N; i++) {
            // dp[3] : 1+00, 00+1, 1+1+1
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.print(dp[N]);
    }
}
