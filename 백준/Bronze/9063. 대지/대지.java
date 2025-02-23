import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int x_min = Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_max = Integer.MIN_VALUE;

        // N개의 좌표에 대한 최소&최대
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x 최소값, 최대값 계산
            if (x < x_min) x_min = x;
            if (x > x_max) x_max = x;

            // y 최소값, 최대값 계산
            if (y < y_min) y_min = y;
            if (y > y_max) y_max = y;
        }

        int width = x_max - x_min;
        int height = y_max - y_min;

        bw.write(String.valueOf(width*height));
        bw.flush();
        bw.close();
    }
}