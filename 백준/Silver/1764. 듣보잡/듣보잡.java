import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                count++;
                result.add(name);
            }
        }

        Collections.sort(result);

         bw.write(count + "\n");
        for (String name : result) {
            bw.write(name + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}