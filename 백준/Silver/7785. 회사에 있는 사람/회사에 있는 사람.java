import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String io =  st.nextToken();

            if (io.equals("leave")) {
                set.remove(name);
            }
            else {
                set.add(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}