import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        // 산술평균
        sb.append(Math.round((float) sum / N)).append("\n");
//        sb.append(Math.round((float) Arrays.stream(arr).sum() / N)).append("\n");

        // 중앙값
        sb.append(arr[N / 2]).append("\n");

        // 최빈값
        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        Collections.sort(list);
        sb.append(list.size() == 1 ? list.get(0) : list.get(1)).append("\n");

        // 범위
        sb.append(arr[N - 1] - arr[0]).append("\n");

        System.out.print(sb);
    }
}