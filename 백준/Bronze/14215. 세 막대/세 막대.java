import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순
        Arrays.sort(n);

        // 삼각형 조건 = 삼각형의 가장 긴 변 < 나머지 두 변의 합
        // 삼각형 조건을 맞추면서 최대 둘레

        // 충족한 경우
        if (n[2] < n[0] + n[1]) {
            bw.write(String.valueOf(n[0] + n[1] + n[2]));
        }

        // 충족하지 않은 경우
        // -> 가장 긴 변을 두 변의 합보다 1만 작게
        // -> n[2] = n[0] + n[1] -1
        else {
            bw.write(String.valueOf(2*(n[0] + n[1]) -1));
        }

        bw.flush();
        bw.close();
    }
}