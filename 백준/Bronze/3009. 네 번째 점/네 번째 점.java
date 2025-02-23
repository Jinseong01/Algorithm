import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] x_arr = new int[3];
        int[] y_arr = new int[3];
        int x = 0;
        int y = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x_arr[i] = Integer.parseInt(st.nextToken());
            y_arr[i] = Integer.parseInt(st.nextToken());
        }

        if (x_arr[0] == x_arr[1]) {
            x = x_arr[2];
        }
        else if (x_arr[0] == x_arr[2]) {
            x = x_arr[1];
        }
        else {
            x = x_arr[0];
        }

        if (y_arr[0] == y_arr[1]) {
            y = y_arr[2];
        }
        else if (y_arr[0] == y_arr[2]) {
            y = y_arr[1];
        }
        else {
            y = y_arr[0];
        }

//        위에는 직관적이지만, 코드가 길어짐
//        XOR 연산 사용 -> 같은 숫자끼리 XOR하면 0 / 0과 다른 숫자 XOR하면 다른 숫자
//        즉, 홀수번 나오는 좌표 선별 가능
//        for (int i = 0; i < 3; i++) {
//            st = new StringTokenizer(br.readLine());
//            x ^= Integer.parseInt(st.nextToken());  // XOR
//            y ^= Integer.parseInt(st.nextToken());  // XOR
//        }

        bw.write(x + " " + y + "\n");
        bw.flush();
        bw.close();
    }
}