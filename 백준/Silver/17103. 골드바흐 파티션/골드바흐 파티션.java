import java.io.*;

public class Main {
    static final int MAX = 1000000;
    static boolean[] sosu = new boolean[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int partition = 0;
            for (int j = 2; j <= N / 2; j++) {
                if (sosu[j] && sosu[N - j]) {
                    partition++;
                }
            }

            bw.write(partition + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void init() {
        sosu[0] = sosu[1] = false;

        // 나머지 모든 수를 소수로 가정
        for (int i = 2; i <= MAX; i++) {
            sosu[i] = true;
        }

        // 에라토스테네스의 체
        // 해당 수가 소수이면, 그 수의 배수는 소수가 X
        for (int i = 2; i * i <= MAX; i++) {
            if (sosu[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    sosu[j] = false;
                }
            }
        }
    }
}