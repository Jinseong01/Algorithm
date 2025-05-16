import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 대각선 실제 길이
        int D = Integer.parseInt(input.split(" ")[0]);

        // 높이, 너비 비율
        int H = Integer.parseInt(input.split(" ")[1]);
        int W = Integer.parseInt(input.split(" ")[2]);

        // 높이, 너비 실제 길이
        double realH;
        double realW;

        // 1번 식 - realH^2 + realW^2 = D^2
        // 2번 식 - realH : realW = H : W

        realH = D * H / Math.sqrt(H*H + W*W);
        realW = D * W / Math.sqrt(H*H + W*W);


        System.out.println((int) realH + " " + (int) realW);
        br.close();
    }
}