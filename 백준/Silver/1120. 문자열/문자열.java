import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String A = input.split(" ")[0];
        String B = input.split(" ")[1];

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }

        System.out.println(result);
    }
}