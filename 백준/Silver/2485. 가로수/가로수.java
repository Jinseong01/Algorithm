import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 기존 나무 간격들의 최대공약수로 나무를 심으면 전체적으로 균일하게 심어짐
        int gcd = 0;
        for (int i = 0; i < N-1; i++) {
            int distance = arr[i+1] - arr[i];
            gcd = gcd(distance, gcd);
        }

        int total = arr[N-1] - arr[0];
        // (total/gcd)는 간격의 개수이기 때문에 +1해야 나무의 개수
        // 마지막으로 기존 나무들의 개수는 제외
        bw.write((total/gcd)+1-arr.length + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}