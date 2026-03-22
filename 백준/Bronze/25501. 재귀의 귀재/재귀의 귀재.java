import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            int[] res = isPalindrome(s, 0, s.length()-1);

            sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] isPalindrome(String s, int l, int r) {
        // 문자열 길이가 0 or 1
        if (l>=r) {
            return new int[]{1, 1};
        }

        // 양 끝 문자가 다름
        if (s.charAt(l) != s.charAt(r)) {
            return new int[]{0, 1};
        }

        // 양 끝 문자가 같으면 안쪽 재귀호출
        int[] res = isPalindrome(s, l+1, r-1);

        return new int[]{res[0], res[1]+1};
    }
}