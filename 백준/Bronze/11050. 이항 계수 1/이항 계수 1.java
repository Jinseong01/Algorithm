import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());

        System.out.println(combination(N, K));
    }

    private static int combination(int n, int k) {
        int a = 1, b = 1;
        for (int i = 0; i < k; i++) {
            a *= (n - i);
            b *= (i + 1);
        }

        return a / b;
    }
}