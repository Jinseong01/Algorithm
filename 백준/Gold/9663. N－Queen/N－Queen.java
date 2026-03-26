import java.io.*;

public class Main {

    static int[] queen;  // queen[row] = 열번호 (row행에 퀸이 놓인 열)
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 방법의 수
        // 퀸은 같은 행, 열, 대각선에 있으면 공격 가능
        // -> 행마다 퀸 1개씩 놓고, 열과 대각선 충돌만 체크

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        queen = new int[N];

        dfs(0, N);

        System.out.print(count);
    }

    private static void dfs(int row, int N) {
        // N행까지 배치
        if (row == N) {
            count++;
            return;
        }

        // 현재 행에서 각 열에 퀸을 배치하며 체크
        for (int i = 0; i < N; i++) {
            queen[row] = i;

            // 현재 열에 퀸 배치 가능
            if (isValid(row)) {
                dfs(row + 1, N);
            }

            // 현재 열에 퀸을 배치 불가능 -> 다음 for문에서 다른 열에 배치 시도
        }
    }

    private static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            // 이전 행들과 같은 열인지 확인
            if (queen[i] == queen[row]) {
                return false;
            }

            // 이전 행들과 대각선인지 확인
            if (Math.abs(queen[i] - queen[row]) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}