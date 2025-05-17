import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            boolean flag = true;

            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("yes\n");
            }
            else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}