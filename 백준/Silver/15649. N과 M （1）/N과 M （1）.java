import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 1-based
        arr = new int[M];

        dfs(0, N, M);

        System.out.println(sb);
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

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // 현재 depth의 숫자 선택
                visited[i] = true;
                arr[depth] = i;

                // 다음 depth의 숫자 선택
                dfs(depth + 1, N, M);

                // 현재 depth 숫자 선택 취소
                visited[i] = false;
            }
        }
    }
}