import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            return;
        }

        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                list.add(i);
                N = N / i;
            }
        }

        if (N > 1) {
            list.add(N);
        }

        for (int num : list) {
            System.out.println(num );
        }
    }
}