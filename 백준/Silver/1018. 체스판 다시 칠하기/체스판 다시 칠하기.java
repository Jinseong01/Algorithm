import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 보드 크기에 따라 8x8의 경우가 다양함
        // -> 이때 가장 좌측 상단 시작 사각형의 좌표가 있어야 8x8체스판 체크 편함
        // N,M이 8,8이면 (1,1)
        // N,M이 10,10이면 (1,1) (1,2) (1,3) ~ (3,1) (3,2) (3,3)
        // N,M이 11,12이면 (1,1) (1,2) (1,3) (1,4) (1,5) ~ (4,1) (4,2) (4,3) (4,4) (4,5)
        // 즉, 가장 좌측 상단 사각형의 좌표는 (N-7, M-7)까지 가능
        // 좌표니까 -1로 고려해서 진행

        int min = 64;
        for(int i = 0; i < N-7; i++) {
            for (int j = 0; j < M - 7; j++) {
                // 기존 min과 check를 통한 min 중 최소값 선택
                min = Math.min(min, check(i, j, board));
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    // i,j부터 시작하여 8x8체스판을 위해 바꾸는 사각형 수 계산 함수
    // 흰색 시작 vs 검정색 시작 중 최소값 반환
    private static int check(int i, int j, char[][] board) {
        int count = 0;

        // for문은 흰색 시작이라 가정하고 진행
        char currentColor = 'W';
        for (int k = i; k < i+8; k++) {
            for (int l = j; l < j+8; l++) {
                if (board[k][l] != currentColor) {
                    count++;
                }
                if(currentColor == 'W') {
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

        return Math.min(count, 64-count);
    }
}