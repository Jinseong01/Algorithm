import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 상근이가 가진 N개의 숫자 카드
        // M개의 정수에 대해 각 숫자 카드를 상근이가 몇개 가지고 있는지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(target, 0);

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}