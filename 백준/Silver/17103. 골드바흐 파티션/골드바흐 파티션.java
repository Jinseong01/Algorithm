import java.io.*;

public class Main {

    static final int MAX = 1000000;
    static boolean[] prime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        // 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수
        // 골드바흐 파티션 : 짝수 N을 두 소수의 합으로 나타내는 표현 (두 소수의 순서만 다른 것은 같은 파티션)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieve();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            for (int j = 2; j <= N / 2; j++) {
                if (prime[j] && prime[N - j]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static void sieve() {
        // 초기화
        for (int i = 2; i <= MAX; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            // i가 소수라면 i의 배수는 소수가 아님
            if (prime[i]) {
                // 이전 단계를 고려하여 i*i부터 배수 확인
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}