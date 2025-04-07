import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<int []> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // [번호, 이동값] 저장
            deque.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {
            // 선택은 맨 앞에 있는 원소로 진행
            int[] cur = deque.pollFirst();

            sb.append(cur[0]).append(" ");

            int move = cur[1];

            if (deque.isEmpty()) {
                break;
            }

            // 일렬로 생각 (선택은 무조건 맨 앞에 있는거)
            // A, B, C, D

            // 우측 이동해서 선택 (= 앞에 있는걸 뒤로 옮겨야함)
            // 앞의 원소를 뺴서 뒤로 배치
            if (move > 0) {
                // poll하고 난 뒤에 카운트하는 거기 때문에 -1 해주어야 함
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
            // 좌측 이동해서 선택 (= 뒤에 있는걸 앞으로 옮겨야함)
            // 뒤의 원소를 뺴서 앞으로 배치
            else {
                // 이미 poll한 거와 상관없음
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.print(sb);
    }
}