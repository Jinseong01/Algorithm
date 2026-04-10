import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 규칙을 만족하며 1~N번의 집을 빨/초/파 중 하나의 색으로 칠하는 최소 비용
        // 1,2번은 다른 색 / N-1번과 N번은 다른 색
        // i(2 ≤ i ≤ N-1)번은 i-1번, i+1번과 다른 색
        // dp[i][c] : i번째를 c로 칠했을 때의 최소 비용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[1][0] = Integer.parseInt(st.nextToken());
        dp[1][1] = Integer.parseInt(st.nextToken());
        dp[1][2] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int red =  Integer.parseInt(st.nextToken());
            int green =  Integer.parseInt(st.nextToken());
            int blue  =  Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }

        int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
        System.out.print(result);
    }
}