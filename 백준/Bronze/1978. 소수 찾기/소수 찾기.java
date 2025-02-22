import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 1은 패스
            if (num == 1) {
                continue;
            }

            // 소수여부
            boolean flag = true;

            for(int j = 2; j < num; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
    }
}