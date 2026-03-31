import java.io.*;

public class Main {

    static int countA = 0;
    static int countB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(countA + " " + countB);
    }

    private static int fib(int n) {
        if (n <= 2) {
            countA++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private static void fibonacci(int n) {
        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            countB++;
        }
    }
}