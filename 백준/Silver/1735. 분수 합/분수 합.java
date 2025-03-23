import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        // 덧셈
        int a3 = a1 * b2 + a2 * b1;
        int b3 = b1 * b2;

        // 기약분수를 위해 최대공약수를 구함
        int gcd = gcd(a3, b3);
        
        bw.write(a3/gcd + " " + b3/gcd + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int b1, int b2) {
        if (b2 == 0) {
            return b1;
        }
        else {
            return gcd(b2, b1 % b2);
        }
    }
}