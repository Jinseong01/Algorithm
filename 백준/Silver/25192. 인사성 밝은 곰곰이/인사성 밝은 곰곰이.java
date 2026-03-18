import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

       int answer = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.equals("ENTER")) {
                set.clear();
            }
            else {
                if (!set.contains(s)) {
                    set.add(s);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
