import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 수열을 담을 배열
        int[] sequence = new int[M];

        // 사용된 숫자를 체크할 배열
        boolean[] visited = new boolean[N + 1];

        // DFS 함수
        dfs(0, N, M, sequence, visited);
    }

    // DFS로 수열을 찾는 함수
    public static void dfs(int depth, int N, int M, int[] sequence, boolean[] visited) {
        // 수열의 길이가 M에 도달했으면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 숫자를 고르기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {  // 이미 방문한 숫자가 아니면
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1, N, M, sequence, visited);
                visited[i] = false;  // 백트래킹: 숫자 방문을 취소
            }
        }
    }
}
