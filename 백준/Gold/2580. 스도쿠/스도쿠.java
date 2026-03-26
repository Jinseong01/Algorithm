import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;

                if (num == 0) {
                    blanks.add(new int[] {i, j});
                }
            }
        }

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static boolean dfs(int idx) {
        // 모든 빈칸을 채웠으면 완성
        if (idx == blanks.size()) {
            return true;
        }

        int[] cur = blanks.get(idx);
        int row = cur[0];
        int col = cur[1];

        for (int i = 1; i <= 9; i++) {
            if (isValid(row, col, i)) {
                // 유효한 숫자 배치
                map[row][col] = i;

                if (dfs(idx + 1)) {
                    return true;  // 하위 재귀에서 완료되면 바로 종료
                }

                // 실패 시 원상복구
                map[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        // 가로
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return false;
            }
        }

        // 세로
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) {
                return false;
            }
        }

        // 같은 블록
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}