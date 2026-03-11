import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n보다 크거나 같은 소수 중 갖아 작은 소수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());

            while (true) {
                if(isPrime(n)) {
                    sb.append(n).append("\n");
                    break;
                }
                n++;
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}