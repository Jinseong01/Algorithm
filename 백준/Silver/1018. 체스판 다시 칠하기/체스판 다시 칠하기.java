import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // M×N 크기의 보드를 잘라서 8×8 크기의 체스판을 만듦
        // 검흰이 알맞게 배치되기 위해 색칠해야 하는 정사각형의 최소 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(min, checkMin(i, j, board));
            }
        }

        System.out.println(min);
    }

    private static int checkMin(int startX, int startY, char[][] board) {
        int count = 0;

        char currentColor = 'W';
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                if (board[i][j] != currentColor) {
                    count++;
                }

                if (currentColor == 'W') {
                    currentColor = 'B';
                }
                else {
                    currentColor = 'W';
                }
            }

            if (currentColor == 'W') {
                currentColor = 'B';
            }
            else {
                currentColor = 'W';
            }
        }

        return Math.min(count, 64 - count);
    }
}