import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 설탕 봉지는 3kg, 5kg
        // N킬로그램 배달해야 할 때, 최대한 적은 봉지 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int five = N / 5;
        while (five >= 0) {
            int rest = N - (five * 5);

            // 3으로 나누어떨어지면 바로 종료
            if (rest % 3 == 0) {
                System.out.println(five + rest / 3);
                return;
            }
            // 3으로 나누어떨어지지않으면 5kg 봉지를 -1개
            else {
                five--;
            }
        }

        System.out.println(-1);
    }
}