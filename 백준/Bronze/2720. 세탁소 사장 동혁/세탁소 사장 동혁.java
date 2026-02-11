import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 화폐단위가 배수이기 때문에 그리디 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int money = Integer.parseInt(br.readLine());

            int quarter = money / 25;
            money %= 25;

            int dime = money / 10;
            money %= 10;

            int nickel = money / 5;
            money %= 5;

            int penny = money;

            sb.append(quarter).append(" ")
                    .append(dime).append(" ")
                    .append(nickel).append(" ")
                    .append(penny).append("\n");
        }

        System.out.println(sb);
    }
}