import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        // 나무 간격들의 최대공약수 계산
        int gcd = 0;
        for (int i = 1; i < N; i++) {
            int dist = trees[i] - trees[i - 1];
            gcd = GCD(gcd, dist);
        }

        // 추가로 심어야하는 나무 개수 계산
        int answer = 0;
        for (int i = 1; i < N; i++) {
            int dist = trees[i] - trees[i - 1];
            answer += (dist / gcd) - 1;
        }

        System.out.println(answer);
    }

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
}