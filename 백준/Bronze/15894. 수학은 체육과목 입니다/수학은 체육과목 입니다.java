import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 -> 4 = 2 + 2
        // 2 -> 8 = 2*2 + 4
        // 3 -> 12 = 2*3 + 6
        // 4 -> 16 = 2*4 + 8

//        int n = Integer.parseInt(br.readLine());
//        1 ≤ n ≤ 10^9이므로 4*n은 40억까지도 가능
//        int는 32비트(=약 40억개) -> 약 -20억 ~ 20억
//        long(=64비트)을 사용해야 함

        long n = Long.parseLong(br.readLine());

        bw.write(Long.toString(n*4));
        bw.flush();
        bw.close();
    }
}