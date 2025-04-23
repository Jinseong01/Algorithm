import java.io.*;
import java.util.*;

public class Main {
    static int[] sequence;
    static int K;
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, N - 1);

        System.out.println(result);
    }

    private static void merge_sort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(p, q); // 왼쪽
            merge_sort(q + 1, r); // 오른쪽
            merge(p, q, r); // 병합
        }
    }

    /*
     p : 시작 idx
     q : 중간 idx
     r : 마지막 idx
    */
    private static void merge(int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p;
        int j = q + 1; // 분할 배열 시작 idx
        int t = 0;

        while ( i <= q && j <= r) {
            // 왼쪽 배열의 숫자가 오른쪽 배열보다 같거나 작으면
            if (sequence[i] <= sequence[j]) {
                tmp[t++] = sequence[i++];
            }
            // 왼쪽 배열의 숫자가 오른쪽 배열보다 크면
            else {
                tmp[t++] = sequence[j++];
            }
        }

        // 왼쪽 배열이 남은 경우
        while (i <= q) {
            tmp[t++] = sequence[i++];
        }

        // 오른쪽 배열이 남은 경우
        while (j <= r) {
            tmp[t++] = sequence[j++];
        }

        // 저장
        for (i = p; i <= r; i++) {
            count++;
            if (count == K) {
                result = tmp[i - p];
                break;
            }

            sequence[i] = tmp[i - p];
        }

    }

}