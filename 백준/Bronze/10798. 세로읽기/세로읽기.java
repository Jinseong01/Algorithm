import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] chars = new char[5][15];
        int max = 0;

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            if (max < s.length()) {
                max = s.length();
            }
            for(int j=0; j<s.length(); j++) {
                chars[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<max; i++) {
            for(int j=0; j<5; j++) {
                if(chars[j][i] != '\0') {
                    sb.append(chars[j][i]);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}