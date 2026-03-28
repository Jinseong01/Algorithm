import java.io.*;
import java.util.*;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] ope = new int[4];
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // N개의 수(순서 고정) 사이에 N-1개의 연산자를 배치해 최대/최솟값 구하기
        // +, -, *, /의 우선순위 무시, 앞에서부터 계산
        // 음수를 양수로 나눌 때는 양수로 바꿔 몫 구하고 음수로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ope[i] = Integer.parseInt(st.nextToken());
        }

        // arr[0]을 초기값으로, 다음 탐색은 1번 인덱스에서 시작
        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int value) {
        if (depth == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ope[i] > 0) {
                // 연산자 사용
                ope[i]--;

                // 이전까지의 값과 현재 값 계산
                dfs(depth + 1, calc(i, value, arr[depth]));

                // 백트래킹
                ope[i]++;
            }
        }
    }

    private static int calc(int operator, int op1, int op2) {
        switch (operator) {
            case 0:
                return op1 + op2;
            case 1:
                return op1 - op2;
            case 2:
                return op2 * op1;
            case 3:
                return (op1 < 0) ? -((-op1) / op2) : op1 / op2;
        }

        return 0;
    }
}