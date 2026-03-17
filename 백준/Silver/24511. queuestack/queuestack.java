import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 각 큐의 원소가 1개씩 -> 하나의 Deque로 관리
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                queue.add(B[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            // 스택은 입력값을 그대로 통과시키기 때문에 무시
            // 입력값 -> 가장 앞에 존재하는 큐에 저장
            // 출력값 -> 가장 뒤에 존재하는 큐의 기존값을 사용
            int c = Integer.parseInt(st.nextToken());

            // 큐가 X = 모든 자료구조가 스택 -> 입력값 그대로 출력
            if (queue.isEmpty()) {
                sb.append(c);
            }
            // 큐가 존재함 -> 마지막 큐의 값을 출력, 입력값은 첫 번째 큐에 저장
            else {
                sb.append(queue.pollLast());
                queue.addFirst(c);
            }
            sb.append(" ");
        }

        System.out.print(sb);
    }
}