import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // N의 생성자 = M + 각 자리수의 합

        int M = 0;
        for(int i = 1; i <= N; i++) {
            int result = 0;
            int num = i;

            // 자리수의 합
            while (num > 0) {
                result = result + num%10;
                num /= 10;
            }

            if (result + i == N) {
                M = i; //현재 i가 가장 작은 생성자인 것
                break;
            }
        }

        bw.write(String.valueOf(M));
        bw.flush();
        bw.close();
    }
}