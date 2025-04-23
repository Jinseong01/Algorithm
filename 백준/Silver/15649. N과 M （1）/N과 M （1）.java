import java.io.*;
import java.util.*;

public class Main {

    static int[] sequence;
    static boolean[] visited;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 수열을 담을 배열
        sequence = new int[M];

        // 사용된 숫자를 체크할 배열 (1을 사용했으면 visited[1]로 할거기 때문에 N+1)
        visited = new boolean[N + 1];

        // DFS 함수
        dfs(0, N, M);

        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int n, int m) {
        // 수열의 길이가 m이 되면 끝
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 n까지 탐색
        for (int i = 1; i <= n; i++) {
            // 아직 선택되지 않았다면
            if (!visited[i]) {
                visited[i] = true; // 선택
                sequence[depth] = i; // 수열에 추가
                dfs(depth + 1, n, m); // 해당 수열의 다음 숫자

                // 백트래킹
                // 호출한 재귀함수가 끝난 뒤, visited[i]를 되돌림
                visited[i] = false;
            }
        }
    }
}
