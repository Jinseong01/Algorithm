import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // for문 -> 시간 초과 -> 다른 방식 필요
        // day = K + 1
        // 하루마다 up-down씩 올라감 + 마지막 날에는 up만큼 올라감 >= V
        // K(up-down) + up >= V
        // K >= (V-up) / (up-down)

        int K = (V-up) / (up-down);
        if ((V - up) % (up - down) != 0) { // 나머지가 있으면
            K++; // 하루 추가
        }

        int day = K + 1;

        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}
