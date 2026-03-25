import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 M개를 고른 수열 (중복 가능)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, N, M);

        System.out.print(sb);
    }

    private static void dfs(int depth, int N, int M) {
        // 길이 M 수열 완성
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지 모든 숫자 선택 가능 (중복 허용)
        for (int i = 1; i <= N; i++) {
            // 현재 depth의 숫자 선택
            arr[depth] = i;

            // 다음 depth의 숫자 선택
            dfs(depth + 1, N, M);
        }
    }
}