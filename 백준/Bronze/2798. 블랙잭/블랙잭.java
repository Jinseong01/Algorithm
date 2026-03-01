import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // M에 최대한 가까운 카드 3장의 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                // M보다 크면
                if (sum > M) {
                    right--;
                }
                // M 이하이면
                else {
                    max = Math.max(max, sum);
                    left++;
                }
            }
        }

        System.out.println(max);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        // M에 최대한 가까운 카드 3장의 합
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < N - 2; i++) {
//            for (int j = i + 1; j < N - 1; j++) {
//                for (int k = j + 1; k < N; k++) {
//                    if (arr[i] + arr[j] + arr[k] <= M) {
//                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
//                    }
//                }
//            }
//        }
//
//        System.out.println(max);
//    }
//}