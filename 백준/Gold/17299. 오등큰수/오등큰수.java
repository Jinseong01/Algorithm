import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 수열 A
        HashMap<Integer, Integer> map = new HashMap<>(); // {수열 A의 원소 : 빈도수}
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 2. 오등큰수 구하기
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer [stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}