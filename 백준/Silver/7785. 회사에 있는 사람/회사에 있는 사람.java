import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 입력
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            map.put(name, log);
        }

        // 회사에 있는 사람들
        List<String> people = new ArrayList<>();
        for (String name : map.keySet()) {
            String log = map.get(name);
            if(log.equals("enter")) {
                people.add(name);
            }
        }

        // 사전 역순
        people.sort(Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String name : people) {
            sb.append(name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}