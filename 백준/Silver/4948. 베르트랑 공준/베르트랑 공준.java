import java.io.*;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {
        // n보다 크고, 2n보다 작거나 같은 소수의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            count = 0;
            for (int j = n + 1; j <= 2 * n; j++) {
                isPrime(j);
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static void isPrime(int a) {
        if (a <= 1) {
            return;
        }

        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return;
            }
        }

        count++;
    }
}