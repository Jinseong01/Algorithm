import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // MenOfPassion(A[], n) {
        //    sum <- 0;
        //    for i <- 1 to n - 1
        //        for j <- i + 1 to n
        //            sum <- sum + A[i] × A[j]; # 코드1
        //    return sum;
        // }
        // 이기 때문에 코드1의 실행횟수는
        // i=1 -> j는 n-1번
        // i=2 -> j는 n-2번
        // ...
        // i=n-1 -> j는 1번
        // 총 = 1+2+...+n-1번 = (n-1)*n/2
        // n(1 ≤ n ≤ 500,000)이기 때문에
        // long으로 처리

        long n = Long.parseLong(br.readLine());

        bw.write((n-1)*n/2 + "\n");
        bw.write("2\n");
        bw.flush();
        bw.close();
    }
}