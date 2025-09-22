import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 배열 합치기 (투포인터로)
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < N && j < M) {
            if (arrA[i] <= arrB[j]) {
                sb.append(arrA[i++]).append(" ");
            }
            else {
                sb.append(arrB[j++]).append(" ");
            }
        }
        
        // 위에서 arrA or arrB 배열 중 1개는 다 돌았다는 의미
        while (i < N) {
            sb.append(arrA[i++]).append(" ");
        }
        while (j < M) {
            sb.append(arrB[j++]).append(" ");
        }

        System.out.println(sb);
    }
}