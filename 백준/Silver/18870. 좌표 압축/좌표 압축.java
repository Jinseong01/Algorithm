import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        // 정렬
        Arrays.sort(sorted);

        // 중복 제거
        int[] unique = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            if (size == 0 || sorted[i] != sorted[i - 1]) {
                unique[size++] = sorted[i];
            }
        }

        // 값-순위 매핑
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(unique[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : origin) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}