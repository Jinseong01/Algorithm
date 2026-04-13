import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];  // i행 j열까지 왔을 때의 최대 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 가장 좌측
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                }
                // 가장 우측
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + num;
                }
                // 나머지
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        System.out.print(answer);
    }
}