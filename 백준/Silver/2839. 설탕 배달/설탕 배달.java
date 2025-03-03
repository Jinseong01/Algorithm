import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N > 0 ) {
            if (N < 3) {
                count = -1;
                break;
            }

            //5kg으로 해결
            if (N % 5 == 0) {
                count += N / 5;
                break;
            }
            //5kg으로 해결 안되면
            else {
                N -= 3;
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}