import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {

            if (i == 1) {
                continue;
            }

            // 소수여부
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sum += i;
                if(min > i) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            bw.write("-1\n");
        }
        else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
    }
}