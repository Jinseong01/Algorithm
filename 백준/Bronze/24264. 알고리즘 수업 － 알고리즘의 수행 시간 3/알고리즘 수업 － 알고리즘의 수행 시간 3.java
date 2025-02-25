import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 ≤ n ≤ 500,000이기 때문에 n^2이면 250,000,000,000으로 너무 커지기 때문에
        // long으로 받아야함
        long n = Long.parseLong(br.readLine());

        // MenOfPassion(A[], n) {
        //    sum <- 0;
        //    for i <- 1 to n
        //        for j <- 1 to n
        //            sum <- sum + A[i] × A[j]; # 코드1
        //    return sum;
        // }
        // 이기 때문에 코드1의 실행횟수는 n*n번
        // 최고차항의 차수는 2


        bw.write(n*n + "\n");
        bw.write(2 + "\n");
        bw.flush();
        bw.close();
    }
}