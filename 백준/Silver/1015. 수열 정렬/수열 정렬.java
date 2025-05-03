import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        // 2 3 1
        int[] B = new int[N];
        // 1 2 3

        // B[P[i]] = A[i]이기 때문에
        // P는 1 2 0
        // -> P는 A의 각 값이 B에서 위치한 인덱스

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }

        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    sb.append(j).append(" ");
                    B[j] = -1;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}