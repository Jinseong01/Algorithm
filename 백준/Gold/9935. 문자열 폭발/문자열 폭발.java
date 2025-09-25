import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String explode = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);

            // 끝부분이 폭발 문자열과 같으면 지우기
            if (sb.length() >= explode.length() && sb.substring(sb.length() - explode.length()).equals(explode)) {
                sb.delete(sb.length() - explode.length(), sb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
