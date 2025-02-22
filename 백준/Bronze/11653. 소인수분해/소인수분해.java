import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            return;
        }

        // a * b = N
        // if) a>루트N, b>루트N -> a*b > N
        // 즉, a,b 중 1개는 루트 N보다 작다
        // 루트N보다 큰 인수에 대해서는 루트N보다 작은 인수들의 조합으로 해결 가능하거나 안 나누어지는 것
        for ( int i = 2; i <= Math.sqrt(N); i++) {
            while ( N % i == 0) {
                bw.write(i + "\n");
                N /= i;
            }
        }

        if (N>1) {
            bw.write(N + "\n");
        }

        bw.flush();
        bw.close();
    }
}