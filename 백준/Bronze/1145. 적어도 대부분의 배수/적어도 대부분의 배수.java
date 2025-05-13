import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int count = 0;
        while(true) {
            // 1부터 쭉 체크하며 '적어도 대부분의 배수' 판단
            for (int i = 0; i < 5; i++) {
                if (result % arr[i] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                break;
            }

            result++;
            count = 0;
        }

        System.out.println(result);
        br.close();
    }
}