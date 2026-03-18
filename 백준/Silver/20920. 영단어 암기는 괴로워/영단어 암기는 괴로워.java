import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        List<String> list;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            // 자주 나오는 단어일수록 앞에 배치
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            // 해당 단어의 길이가 길수록 앞에 배치
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }

            // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
            return a.compareTo(b);
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}