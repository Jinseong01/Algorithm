import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 초기에는 다 닫힘 상태
        // 1번째는 1의 배수만 여닫고
        // 2번째는 2의 배수만 여닫고
        // ...
        // 즉, N의 약수가 홀수 개이면 최종 열림 상태
        // 1, 4, 9, ...
        // 자연수에서 약수가 홀수 개인 것은 "제곱수"

        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}