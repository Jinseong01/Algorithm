import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sumY = 0, sumM = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int call = Integer.parseInt(st.nextToken());

            sumY += ((call / 30) + 1) * 10;
            sumM += ((call / 60) + 1) * 15;
        }

        if (sumY > sumM) {
            System.out.println("M " + sumM);
        }
        else if (sumY < sumM) {
            System.out.println("Y " + sumY);
        }
        else {
            System.out.println("Y M " + sumM);
        }

        br.close();
    }
}