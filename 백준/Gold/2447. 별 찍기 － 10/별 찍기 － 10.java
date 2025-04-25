import java.util.Scanner;

public class Main {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][N];

        star(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char ch : row) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 별 찍기 함수
    public static void star(int size, int x, int y) {
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        int div = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // 가운데 부분 공백 채우기
                    fillBlank(div, x + i * div, y + j * div);
                } else {
                    // 나머지 부분 재귀
                    star(div, x + i * div, y + j * div);
                }
            }
        }
    }

    // 공백 채우기 함수
    public static void fillBlank(int size, int x, int y) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = ' ';
            }
        }
    }
}
