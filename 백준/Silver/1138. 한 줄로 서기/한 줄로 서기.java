import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] left = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 자신의 왼쪽에 서 있던 자신보다 키가 큰 사람 수 (키가 작은 사람부터 입력)
        for (int i = 0; i < N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();

        // 키가 큰 사람부터 left[i]를 idx로 하여 리스트에 삽입
        // left[i]가 1이다 -> idx 1에 삽입 = 왼쪽에 자신보다 키 큰 사람 1명
        // 키 큰 사람부터 삽입하는 이유 -> 앞에 작은 사람이 추가되더라도 left[i]를 만족함
        for (int i = N; i > 0; i--) {
            line.add(left[i - 1], i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line.get(i) + " ");
        }
    }
}