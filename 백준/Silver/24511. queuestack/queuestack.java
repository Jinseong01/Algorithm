import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 자료구조 형태 (0이면 큐, 1이면 스택)
        int [] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        // 자료구조 원소
        int [] arrB = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }


        int M = Integer.parseInt(br.readLine());

        // 입력값
        int [] arrC = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        // 스택의 경우, 입력값 삽입 -> 원소 pop하면 입력값이 다시 나옴
        // = 변화 없음
        // 큐의 경우, 입력값 삽입 -> 원소 pop하면 다른값이 나옴
        // = 변화 있음
        // -> 큐만 고려
        
        // ex)
        // 0 1 1 0은 [큐 스택 스택 큐] 인 상황으로
        // 첫번째 입력값 -> 첫번째 큐의 값 / 첫번째 큐의 값 -> 두번째 큐의 값
        // 결과 : 두번째 큐의 값 인 것
        // 결국 입력값이 순서대로 돌아가며 큐의 값을 순차적으로 1칸씩 밀어낸다고 생각하면 됨

        Queue<Integer> queue = new LinkedList<>();

        for (int i = N - 1; i >= 0; i--) {
            if (arrA[i] == 0) {
                queue.add(arrB[i]);
            }
        }

        for (int i = 0; i < M; i++) {
            queue.add(arrC[i]);
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb);
    }
}