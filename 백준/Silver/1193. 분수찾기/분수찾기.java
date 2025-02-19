import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        
        // 대각선 개수가 1, 2, 3, .. -> X가 몇번째 라인의 몇번째 분수인지 알 수 있음

        int line = 1;
        while (X > line) {
            X -= line++;
        }

        int lineSum = line + 1;  // 분자 + 분모
        int a = 0;
        int b = 0;

        // 짝수 라인
        if (line % 2 == 0) {
            a = X;
            b = lineSum - X;
        }
        // 홀수 라인
        else {
            b = X;
            a = lineSum - X;
        }

        bw.write(String.format("%d/%d", a, b));
        bw.flush();
        bw.close();
    }
}