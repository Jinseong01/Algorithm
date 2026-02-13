import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 마지막 날은 정상 도착하면 끝 -> 마지막 날 제외하고 계산
        int height = V - A;
        int move = A - B;

//        int daysBeforeLast = height / move;
//        if (height % move != 0) {
//            daysBeforeLast++;
//        }
        int daysBeforeLast = (height + (move-1)) / move;

        System.out.println(daysBeforeLast + 1);
    }
}