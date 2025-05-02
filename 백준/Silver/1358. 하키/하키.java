import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int R = H / 2;

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 왼쪽 구역에 있다면 (=원 중심에서 좌표까지의 거리로 계산)
            if (Math.sqrt(Math.pow(X - x, 2) + Math.pow(Y + R - y, 2)) <= R) {
                count++;
            }
            // 가운데 구역에 있다면
            else if ((X <= x && x <= X + W) &&(Y <= y && y <= Y + H)) {
                count++;
            }
            // 오른쪽 구역에 있다면
            else if (Math.sqrt(Math.pow(X + W - x, 2) + Math.pow(Y + R - y, 2)) <= R) {
                count++;
            }
        }

        System.out.println(count);
    }
}