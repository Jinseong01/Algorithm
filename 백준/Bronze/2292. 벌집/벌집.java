import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // From 1
        // To 2~7(=6개) -> 2개
        // To 8~19(=12개=6*2) -> 3개
        // To 20~37(=18개=6*3) -> 4개
        // To 38~61(=24개=6*4) -> 5개
        // To 62~... -> 6개

        int i = 1;
        int range = 1;
        while (n > range) {
            range += 6 * i++; //6개, 12개, 18개, ...
        }

        bw.write(String.valueOf(i));
        bw.flush();
        bw.close();
    }
}