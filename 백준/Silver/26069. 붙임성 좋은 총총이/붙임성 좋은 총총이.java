import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String user1, user2;

        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            user1 = st.nextToken();
            user2 = st.nextToken();

            if (dance.contains(user1) || dance.contains(user2)) {
                dance.add(user1);
                dance.add(user2);
            }
        }

        System.out.println(dance.size());
    }
}