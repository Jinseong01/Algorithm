import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] water = new int[N];
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(water);

        boolean[] tape = new boolean[1001];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int a = water[i];

            if (!tape[a]) {
                count++;
                for (int j = a; j < a + L && j < tape.length; j++) {
                    tape[j] = true;
                }
            }
        }

        System.out.println(count);
    }
}