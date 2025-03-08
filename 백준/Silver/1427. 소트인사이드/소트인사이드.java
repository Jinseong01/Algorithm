import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] N = br.readLine().toCharArray();

        Arrays.sort(N);

        StringBuilder sb = new StringBuilder();
        for (int i = N.length-1; i >= 0; i--) {
            sb.append(N[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}