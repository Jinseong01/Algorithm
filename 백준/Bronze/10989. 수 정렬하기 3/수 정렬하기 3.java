import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1  ~ 10,000
        int[] count = new int[10000 + 1];
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.print(sb);
    }
}