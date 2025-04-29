import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();

            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);

                if (c == 'F' && ((i + j) % 2 == 0)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}