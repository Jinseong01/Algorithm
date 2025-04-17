import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int [] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += arr[i];

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr);

        // 1. 평균
        sb.append(Math.round((double) sum / N)).append("\n");

        // 2. 중앙값
        sb.append(arr[N / 2]).append("\n");

        // 3. 최빈값
        int maxValue = Collections.max(map.values());
        List<Integer> keys = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }

        Collections.sort(keys);
        if (keys.size() > 1) {
            sb.append(keys.get(1)).append("\n");
        }
        else {
            sb.append(keys.get(0)).append("\n");
        }

        // 4. 범위
        sb.append(arr[N-1]-arr[0]).append("\n");

        
        System.out.println(sb.toString());
    }
}