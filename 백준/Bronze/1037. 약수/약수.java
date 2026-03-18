import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N의 1과 N을 제외한 모든 약수가 주어질 때, N 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        System.out.println(arr[0] * arr[N - 1]);
    }
}