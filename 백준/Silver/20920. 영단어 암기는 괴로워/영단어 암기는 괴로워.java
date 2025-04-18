import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());
        words.sort((a, b) -> {
            // 자주 나오든 단어가 앞
            if (Integer.compare(map.get(b), map.get(a)) != 0) {
                // map.get(b) > map.get(a)이면
                // 양수 반환 -> (a,b)에서 (b,a)로 순서바뀜
                return Integer.compare(map.get(b), map.get(a));
            }

            // 단어의 길이가 길수록 앞
            if (b.length() != a.length()) {
                // b.길이 > a.길이 이면
                // 양수 반환 -> (a,b)에서 (b,a)로 순서바뀜
                return b.length() - a.length();
            }

            // 사전순 먼저일수록 앞
            // a의 사전순서가 b의 사전순서보다 뒤이면
            // 양수 반환 -> (a,b)에서 (b,a)로 순서바뀜
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}