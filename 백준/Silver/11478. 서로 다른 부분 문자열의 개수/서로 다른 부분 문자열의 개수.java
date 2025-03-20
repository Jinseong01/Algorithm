import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < S.length(); i++) {
            for(int j = i+1; j <= S.length(); j++) {
                set.add(S.substring(i, j)); //substring i부터 j 직전까지의 문자열
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}