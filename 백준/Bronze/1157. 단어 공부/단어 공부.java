import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int maxValue = 0;
        int maxIndex = 0;
        boolean duplicate = false;


        String input = br.readLine().toUpperCase();


        int[] n = new int[26];
        for(char c : input.toCharArray()) {
            n[c-'A']++;
        }


        for(int i = 0; i < 26; i++) {
            if( n[i] > maxValue) {
                maxValue = n[i];
                maxIndex = i;
                duplicate = false;
            }
            else if (n[i] == maxValue) {
                duplicate = true;
            }
        }

        if (duplicate) {
            bw.write("?");
        } else {
            bw.write((char)(maxIndex+'A'));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}