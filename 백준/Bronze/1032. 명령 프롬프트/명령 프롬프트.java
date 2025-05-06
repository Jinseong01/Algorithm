import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input[0].length(); i++) {
            boolean isSame = true;
            char c = input[0].charAt(i);

            for (int j = 1; j < input.length; j++) {
                if (c != input[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                sb.append(c);
            }
            else {
                sb.append('?');
            }
        }

        System.out.println(sb);
        br.close();
    }
}