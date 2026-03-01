import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N의 분해합은 N과 N을 이루는 각 자리수의 합
        // M의 분해합이 N인 경우, M을 N의 생성자라 함
        // ex) 245의 분해합은 256(=245+2+4+5)이며, 245는 256의 생성자
        // N의 가장 작은 생성자 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 1;
        while (num <= N) {
            int res = calc(num);

            if (res == N) {
                System.out.println(num);
                return;
            }

            num++;
        }

        System.out.println(0);
    }

    private static int calc(int n) {
        int tmp = n;

        while(n > 0){
            tmp += n % 10;
            n = n / 10;
        }

        return tmp;
    }
}