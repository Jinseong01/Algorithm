import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // MenOfPassion(A[], n) {
        //    sum <- 0;
        //    for i <- 1 to n
        //        sum <- sum + A[i]; # 코드1
        //    return sum;
        // }
        // 이기 때문에 코드1의 실행횟수는 n번
        // 최고차항의 차수는 1
        
        bw.write(n + "\n");
        bw.write(1 + "\n");
        bw.flush();
        bw.close();
    }
}