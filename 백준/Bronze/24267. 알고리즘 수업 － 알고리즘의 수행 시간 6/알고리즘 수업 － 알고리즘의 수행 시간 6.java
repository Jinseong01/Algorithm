import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // MenOfPassion(A[], n) {
        //    sum <- 0;
        //    for i <- 1 to n - 2
        //        for j <- i + 1 to n - 1
        //            for k <- j + 1 to n
        //                sum <- sum + A[i] × A[j] × A[k]; # 코드1
        //    return sum;
        // }
        // i=1, j=2 -> k=3~n(n-2번)
        // i=1, j=3 -> k=4~n(n-3번)
        // ...
        // i=1, j=n-1 -> k=n~n(1번)
        // i=1일 때만, 총 (n-2)+(n-3)+...+1 = (n-2)(n-1)/2번
        //
        // i=2, j=3 -> k=4~n(n-3번)
        // ...
        // i=2, j=n-1 -> k=n~n(1번)
        // i=2일 때만, 총 (n-3)+...+1 = (n-3)(n-2)/2번
        //
        // i=n-2, j=n-1 -> k=n~n(1번)
        // i=n-2일 때만, 총 1번
        // 코드1의 실행 횟수 = 시그마(1~n-2) (n-i-1)(n-i)/2
        // = n(n-1)(n-2)/6
        // n(1 ≤ n ≤ 500,000)이니까 long

        long n = Long.parseLong(br.readLine());

        bw.write(((n * (n - 1) * (n - 2)) / 6) + "\n");
        bw.write("3\n");
        bw.flush();
        bw.close();
    }
}