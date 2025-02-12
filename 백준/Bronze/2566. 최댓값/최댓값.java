import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int max = 0;
        int n = 0;
        int m = 0;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (max < a) {
                    max = a;
                    n = i;
                    m = j;
                }
            }
        }

        bw.write(max + "\n");
        bw.write(String.format("%d %d", n+1, m+1));
        bw.flush();
        bw.close();
    }
}