import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, 0, N-1);

        System.out.println(result);
    }

    private static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);  // 앞쪽 정렬
            mergeSort(A, mid+1, right);  // 뒤쪽 정렬
            merge(A, left, mid, right);  // 병합
        }
    }

    static void merge(int[] A, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int t = 0;

        // 비교하면서 tmp에 오름차순 저장
        while (i<=mid && j<=right) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            }
            else {
                tmp[t++] = A[j++];
            }
        }

        // 앞쪽 남은부분 저장
        while (i <= mid) {
            tmp[t++] = A[i++];
        }

        // 뒤쪽 남은부분 저장
        while (j <= right) {
            tmp[t++] = A[j++];
        }

        // tmp를 A에 복사 & K번째 저장되는 수 확인
        i = left; t = 0;
        while (i<=right) {
            A[i] = tmp[t];
            count++;

            if (count==K) {
                result = A[i];
                return;
            }

            i++; t++;
        }
    }
}