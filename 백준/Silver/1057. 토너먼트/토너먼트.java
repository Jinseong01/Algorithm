import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int jimin = Integer.parseInt(s.split(" ")[1]);
        int hansu = Integer.parseInt(s.split(" ")[2]);

        // 16 8 9
        // jimin - 8 -> 4 -> 2 -> 1
        // hansu - 9 -> 5 -> 3 -> 2
        // 짝수일때는 /2 / 홀수일때는 +1까지
        int round = 0;
        while (jimin != hansu) {
            if (jimin % 2 == 0) {
                jimin = jimin / 2;
            } else {
                jimin = jimin / 2 + 1;
            }

            if (hansu % 2 == 0) {
                hansu = hansu / 2;
            } else {
                hansu = hansu / 2 + 1;
            }

            // if문 없이도 가능
            // jimin = jimin/2 + jimin%2;
            // hansu = hansu/2 + hansu%2;

            round++;
        }

        System.out.println(round);
        br.close();
    }
}