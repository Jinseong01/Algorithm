import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());

            sb.append(money / quarter + " ");
            money %= quarter;
            sb.append(money / dime + " ");
            money %= dime;
            sb.append(money / nickel + " ");
            money %= nickel;
            sb.append(money / penny + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}