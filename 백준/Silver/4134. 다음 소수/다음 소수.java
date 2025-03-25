import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());

            while (!isPrime(N)) {
                N++;
            }

            bw.write(N + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 소수 판별
    private static boolean isPrime(long n) {
        // 0, 1
        if (n < 2) {
            return false;
        }

        // 소수가 아닌 경우
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        // 소수인 경우
        return true;
    }
}