import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 창문(처음에는 모두 닫혀있음)과 N명의 사람
        // 1번째 사람은 1의 배수 번째 창문을 반대로
        // 2번째 사람은 2의 배수 번째 창문을 반대로
        // 이러한 행동을 N번째 사람까지 진행한 후 열려 있는 창문의 개수

        // 1번째 창문 - 1번째 사람
        // 2번째 창문 - 2번째 사람
        // 3번째 창문 - 3번째 사람
        // 4번째 창문 - 2, 4번째 사람
        // ...
        // N번째 창문 - {N의 약수}명의 사람

        // 처음에 닫혀있으니, 열리려면 {N의 약수}가 홀수여야 함
        // 약수가 홀수개인 수는 제곱수
        // 즉 1~N까지 제곱수의 개수 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            count++;
        }

        System.out.println(count);
//        System.out.println((int)Math.sqrt(N));
    }
}