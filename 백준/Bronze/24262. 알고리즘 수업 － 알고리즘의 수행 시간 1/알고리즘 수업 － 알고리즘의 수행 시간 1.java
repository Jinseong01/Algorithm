import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // MenOfPassion(A[], n) {
        //    i = ⌊n / 2⌋;
        //    return A[i]; # 코드1
        // }
        // 이기 때문에 실행횟수는 n과 상관없이 무조건 1번
        // 따라서 최고차항 차수는 0
        bw.write(1 + "\n");
        bw.write(0 + "\n");
        bw.flush();
        bw.close();
    }
}