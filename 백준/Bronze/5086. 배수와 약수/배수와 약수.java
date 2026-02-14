import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0") && input[1].equals("0")) {
                break;
            }

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            if (B % A == 0) {
                sb.append("factor").append("\n");
            }
            else if (A % B == 0) {
                sb.append("multiple").append("\n");
            }
            else {
                sb.append("neither").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}