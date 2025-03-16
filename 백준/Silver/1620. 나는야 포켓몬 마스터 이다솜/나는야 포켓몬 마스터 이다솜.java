import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            map1.put(i, s);
            map2.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            // 첫 글자가 숫자인지 확인
            if (Character.isDigit(s.charAt(0))) {
                int j = Integer.parseInt(s);
                sb.append(map1.get(j)).append('\n');
            } else {
                sb.append(map2.get(s)).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}