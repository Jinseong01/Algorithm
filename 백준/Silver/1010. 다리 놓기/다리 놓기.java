import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // M개 중 N개를 선택, 중복 X = 조합
            // 다리이기 때문에 겹치면 X -> 순서를 신경쓰지 않으므로 상관 X
            // ex) (1,2,3) (1,3,2)를 구분하지 않고 동일한 것으로 취급
            // 즉, 겹치는 경우는 자연스레 제외됨
            // mCn
            // N,M<=30이여서 일반적인 해결법으로는 해결 X

            // nCr = n*(n-1)*(n-2)*...*(n-r+1) / r!
            // 10C3 = 10*9*8 / 3*!

            sb.append(comb(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    private static long comb(int m, int n) {
        // 10C7 = 10C3
        if (n > m - n) {
            n = m - n;
        }

        long res = 1;

        for(int i = 1; i <= n; i++) {
            res = res * (m - i + 1) / i;
            // 10/1
            // 10*9 / 1*2
            // 10*9*8 / 1*2*3
        }

        return res;
    }
}