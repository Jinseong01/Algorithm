import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 각 인수별로 오큰수 구하기
        // 이중For문 -> 백만^2 -> Wow
        // ex) 1번째 for문(0 ~ N-1까지 각 idx 순회) -> 2번째 for문(idx+1 ~ N-1 순회)
        // -> 해당 인수가 오큰수를 못 찾은 인수들에 대한 해답이 되는지 판단
        // ex) for문(0 ~ N-1까지 각 idx 순회) -> 오큰수 못 찾은 인수들을 별도로 저장해둔뒤, 현 idx가 오큰수가 되어 줄 수 있는지 판단

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            // 현재 arr[i]가 arr[스택 top]보다 크면 오큰수
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }

            stack.push(i); // 오큰수를 못 찾은 인수의 인덱스 저장
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}