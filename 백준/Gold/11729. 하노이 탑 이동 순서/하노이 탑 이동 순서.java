import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // n개를 from->to로 이동 (tmp 이용)
        int count = hanoi(N, 1, 3, 2);

        System.out.println(count);
        System.out.print(sb);
    }

    private static int hanoi(int n, int from, int to, int tmp) {
        // 원판 1개 -> 바로 이동
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return 1;
        }

        // 위에서 (n-1)개 치움
        int before = hanoi(n - 1, from, tmp, to);

        // 큰 원판 이동
        sb.append(from).append(" ").append(to).append("\n");

        // 치웠던 (n-1)개 이동
        int after = hanoi(n - 1, tmp, to, from);

        return before + 1 + after;
    }
}