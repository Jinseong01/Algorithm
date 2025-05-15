import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);


        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int length = Math.min(N, M);

        while (length > 1) {
            for (int i = 0; i <= N - length; i++) {
                for (int j = 0; j <= M - length; j++) {
                    int num = map[i][j];

                    if (num == map[i][j + length - 1] && num == map[i + length - 1][j] && num == map[i + length - 1][j + length - 1]) {
                        System.out.println(length * length);
                        return;
                    }
                }
            }

            length--;
        }

        System.out.println(1);
    }
}