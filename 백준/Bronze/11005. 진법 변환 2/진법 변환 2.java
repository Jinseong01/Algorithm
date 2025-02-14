import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 60466175 36진법으로
        // 몫 1679615 나머지 35
        // 몫 46655 나머지 35
        // 몫 1295 나머지 35
        // 몫 35 나머지 35
        // 몫 0 나머지 35
        // 마지막부터 35 35 35 35 35 -> ZZZZZ

        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int remainder = num % n; // 나머지
            num /= n; // 몫
            char c;
            if (remainder < 10) {
                c = (char) ('0' + remainder);
            }
            else {
                c = (char) ('A' + (remainder-10));
            }
            sb.append(c);
        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
}