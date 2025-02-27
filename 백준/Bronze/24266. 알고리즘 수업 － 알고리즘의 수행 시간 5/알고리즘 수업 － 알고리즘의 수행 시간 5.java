import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // MenOfPassion(A[], n) {
        //    sum <- 0;
        //    for i <- 1 to n
        //        for j <- 1 to n
        //            for k <- 1 to n
        //                sum <- sum + A[i] × A[j] × A[k]; # 코드1
        //    return sum;
        // }
        // i = 1, j = 1 -> k=1~n
        // -> 코드1 실행횟수 n^3
        // n(1 ≤ n ≤ 500,000)이기 때문에 n은 Long으로 처리

        Long n = Long.parseLong(br.readLine());

        bw.write(n * n * n + "\n");
        bw.write("3\n");
        bw.flush();
        bw.close();
    }
}