import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 아래 -> 위 로 재료가 쌓임
        // 아래) 빵 - 야채 - 고기 - 빵 (위
        // 1 : 빵 / 2 : 야채 / 3 : 고기
        
        int[] stack = new int[ingredient.length];
        int top = 0;
        int answer = 0;

        for (int x : ingredient) {
            stack[top++] = x;

            // 햄버거 O
            if (top >= 4 &&
                stack[top-4] == 1 &&
                stack[top-3] == 2 &&
                stack[top-2] == 3 &&
                stack[top-1] == 1) {

                top -= 4;
                answer++;
            }
        }
        
        return answer;
    }
}