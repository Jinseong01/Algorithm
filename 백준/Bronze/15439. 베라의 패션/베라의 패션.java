import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 상의 N벌과 하의 N벌
        // 상의와 하의가 서로 다른 색상인 조합 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(N * (N - 1));
    }
}