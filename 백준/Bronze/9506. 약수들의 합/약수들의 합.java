import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> factors = new ArrayList<>();
            int sum = 1;
            factors.add(1);

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                    sum += i;

                    int pair = n / i;
                    if (i != pair) {
                        factors.add(pair);
                        sum += pair;
                    }
                }
            }

            Collections.sort(factors);

            sb.append(n);
            if (n == sum) {
                sb.append(" = ").append(factors.get(0));
                for (int i = 1; i < factors.size(); i++) {
                    sb.append(" + ").append(factors.get(i));
                }
            }
            else {
                sb.append(" is NOT perfect.");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}