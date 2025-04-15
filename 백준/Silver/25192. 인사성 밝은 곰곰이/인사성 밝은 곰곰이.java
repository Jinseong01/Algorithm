import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            // 누군가 새로 입장
            if (s.equals("ENTER")) {
                set.clear();
            }
            // 입장 아니고 채팅인사한 경우
            else {
                // 기존에 채팅 안 친 경우만
                if (!set.contains(s)) {
                    set.add(s);
                    count++; // 누군가 새로 들어오면 clear()해주기 때문에 새로 들어오고 채팅친 경우도 카운트됨
                }
            }
        }

        System.out.println(count);
    }
}