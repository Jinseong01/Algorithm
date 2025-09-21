import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 2. 오름차순 정렬
        Arrays.sort(arr);

        // 3. 연속적인 수 5개를 위한 최소 필요 개수 (최대 5)
        int minAdd = 5;

        for (int i = 0; i < N; i++) {
            int start = arr[i];
            int count = 1;      // arr[i] 포함

            // start 다음 연속적인 수 4개가 존재하는지
            for (int j = i+1; j <= i + 4 && j < N; j++) {
                // 오름차순 정렬했기 때문에 start+4 이하인지 확인
                if (arr[j] <= start+4) {
                    count++;
                }
                else {
                    break;
                }
            }

            minAdd = Math.min(minAdd, 5- count);
        }

        System.out.println(minAdd);
    }
}