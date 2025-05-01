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

            int total = 0;

            total += 1; // 시작 여백

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '0') {
                    total += 4;
                }
                else if (c == '1') {
                    total += 2;
                }
                else {
                    total += 3;
                }

                total += 1; // 다음 숫자와의 여백 or 마자믹인 경우 끝 여백
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}