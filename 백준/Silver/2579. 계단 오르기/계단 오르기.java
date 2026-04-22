import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.print(score[0]);
            return;
        }

        // dp[i] : i번째 계단을 반드시 밟고 도착했을 때의 최대 점수
        // i까지 오는 방법 : (i-2 -> i) or (i-3 -> i-1 -> i)
        int[] dp = new int[n];
        dp[0] = score[0];
        dp[1] = score[0] + score[1];

        if (n > 2) {
            dp[2] = Math.max(
                    score[0] + score[2],
                    score[1] + score[2]
            );
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + score[i],
                    dp[i - 3] + score[i - 1] + score[i]
            );
        }

        System.out.print(dp[n - 1]);
    }
}