import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 M개를 고른 수열 (중복 가능, 비내림차순)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, 1, N, M);

        System.out.println(sb);
    }

    private static void dfs(int depth, int start, int N, int M) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i, N, M);
        }
    }
}