import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> divisors = new ArrayList<>();

        // 1. 루트N까지 탐색
        int root = (int) Math.sqrt(N);
        for (int i = 1; i <= root; i++) {
            if (N % i == 0) {
                divisors.add(i);

                // 제곱수가 아닌 경우에는 그 쌍인 약수까지 저장
                if (i != N / i) {
                    divisors.add(N / i);
                }
            }
        }

        // 2. 약수들을 오름차순으로 정렬
        Collections.sort(divisors);

        // 3. K번째 약수 출력
        if (divisors.size() >= K) {
            System.out.println(divisors.get(K - 1));
        }
        else {
            System.out.println(0);
        }
    }
}