import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPrime(int i) {
        // 1
        if (i == 1) {
            return false;
        }

        // 2
        if (i == 2) {
            return true;
        }

        // 나머지 짝수
        if (i % 2 == 0) {
            return false;
        }

        // 나머지 소수가 아닌 경우
        for (int j = 3; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
}