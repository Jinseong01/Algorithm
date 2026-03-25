import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = hanoi(N, 1, 2, 3, sb);

        System.out.println(count);
        System.out.println(sb);
    }

    private static int hanoi(int N, int from, int tmp, int to, StringBuilder sb) {
        // 옮기는 판이 1개 뿐이라면, 곧바로 이동
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return 1;
        }

        // 가장 큰 원판 위의 (N-1)개를 from -> tmp로 이동
        int before = hanoi(N-1, from, to, tmp, sb);

        // 가장 큰 원판을 from -> to로 이동
        sb.append(from).append(" ").append(to).append("\n");

        // tmp로 옮겼던 (N-1)개를 tmp -> to로 이동
        int after = hanoi(N-1, tmp, from, to, sb);

        return before + 1 + after;
    }
}