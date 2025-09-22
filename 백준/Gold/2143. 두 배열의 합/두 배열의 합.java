import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m+1];
        for (int i = 1; i < m+1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 각 부배열 조합의 합 구하기
        // n의 부배열 조합의 합 구하기
        ArrayList<Integer> arr_A = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sum_A = 0;
            for (int j = i; j <= n; j++) {
                sum_A += a[j];
                arr_A.add(sum_A);
            }
        }

        // m의 부배열 조합의 합 구하기
        ArrayList<Integer> arr_B = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int sum_B = 0;
            for (int j = i; j <= m; j++) {
                sum_B += b[j];
                arr_B.add(sum_B);
            }
        }

        // 3. 정렬
        Collections.sort(arr_A);
        Collections.sort(arr_B, Collections.reverseOrder());

        // 4. 각 부배열 조합의 합들로 T가 되는 경우의 수 구하기 (투포인터)
        int i = 0;
        int j = 0;
        long answer = 0;

        while (i < arr_A.size() && j < arr_B.size()) {
            int sum = arr_A.get(i) + arr_B.get(j);

            if (sum == T) {
                int countA = 1, countB = 1;

                // 같은 값에 대한 처리 (arr_A)
                while (i + 1 < arr_A.size() && arr_A.get(i).equals(arr_A.get(i + 1))) {
                    countA++;
                    i++;
                }
                // 같은 값에 대한 처리 (arr_B)
                while (j + 1 < arr_B.size() && arr_B.get(j).equals(arr_B.get(j + 1))) {
                    countB++;
                    j++;
                }

                answer += (long) countA * countB;
                i++;
                j++;
            }
            else if (sum < T) {
                i++;
            }
            else {
                j++;
            }
        }

        System.out.println(answer);
    }
}