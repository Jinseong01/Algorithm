import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (오름차순)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, 1, N, M);

        System.out.print(sb);
    }

    private static void dfs(int depth, int next, int N, int M) {
        // 길이 M 수열 완성
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // next부터 시작 (=이전에 선택한 값보다 큰 값만 선택, 오름차순)
        for (int i = next; i <= N; i++) {
            // 현재 depth의 숫자 선택
            arr[depth] = i;

            // 다음 depth의 숫자 선택 (i+1부터 탐색)
            dfs(depth + 1, i + 1, N, M);
        }
    }
}