import java.io.*;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }

        draw(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void draw(int x, int y, int size) {
        // 더이상 나눌 수 없으면 종료
        if (size == 1) {
            board[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                // 가운데 블록은 공백
                if (i == 1 && j == 1) {
                    continue;
                }

                draw(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}