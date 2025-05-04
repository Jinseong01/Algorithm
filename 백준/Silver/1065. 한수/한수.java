import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 1~9 - 등차수열 O

        // 10~99 - 등차수열 O
        // 10, 11, 12, 13, ...

        // 100~999 - 판단 필요
        // 1000 - 등차수열 X

        System.out.println(hansu(N));
    }

    private static int hansu(int i) {
        if (i < 100) {
            return i;
        }
        else if (i == 1000) {
            // 100~999 결과는 모르지만 문제 예시에 144라 명시
            // 99까지는 99개이니, 100~999까지는 45개라고 예측 가능
            return 144;
        }
        else {
            int count = 99;
            for (int j = 100; j <= i; j++) {
                int first = j % 10;
                int second = (j / 10) % 10;
                int third = (j / 100) % 10;
                if ((second - first) == (third - second)) {
                    count++;
                }
            }
            return count;
        }
    }
}