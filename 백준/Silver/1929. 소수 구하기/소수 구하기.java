import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            if(isPrime(i)) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 소수 판별
    private static boolean isPrime(int n) {
        // 0, 1
        if (n <= 1) {
            return false;
        }

        // 2
        if (n == 2) {
            return true;
        }

        // 2를 제외한 짝수는 소수가 아님
        if (n % 2 == 0) {
            return false;
        }

        // 나머지 소수가 아닌 경우
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }

        // 나머지 소수인 경우
        return true;
    }
}