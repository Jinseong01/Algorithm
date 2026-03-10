import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numerator1 = Integer.parseInt(st.nextToken());
        int denominator1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numerator2 = Integer.parseInt(st.nextToken());
        int denominator2 = Integer.parseInt(st.nextToken());

        int numerator3 = numerator1 * denominator2 + numerator2 * denominator1;
        int denominator3 = denominator1 * denominator2;

        int gcd = GCD(numerator3, denominator3);

        System.out.println(numerator3/gcd + " " + denominator3/gcd);
    }

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
}