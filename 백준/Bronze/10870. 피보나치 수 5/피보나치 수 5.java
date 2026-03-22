import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}