import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // step0 -> 4 (2^2)
        // step1 -> 9 (3^3) [+1]
        // step2 -> 25 (5^2) [+2]
        // step3 -> 25 + 20 + 36 = 81 (9^2) [+4]
        // step4?? -> 17^2 [+8]
        // step5?? -> 33^2 [+16]
        
        // stepN -> (2^N + 1) ^ 2

        System.out.println((int) Math.pow(Math.pow(2, N) + 1, 2));
    }
}