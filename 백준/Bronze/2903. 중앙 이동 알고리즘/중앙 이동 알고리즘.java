import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 초기 : 4
        //  n = 1 -> 9 = 3^2 = (2+1)^2
        // n = 2 -> 25 = 5^2 = (4+1)^2
        // n = 3 -> 49 = 9^2 = (8+1)^2
        // n = 4 -> ?? = ?^2 = (16+1)^2

        // Math.pow의 결과는 double이기 때문에 캐스팅 필요
        int result = (int) Math.pow( Math.pow(2, n) + 1, 2);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}