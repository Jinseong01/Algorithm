import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        HashSet<Integer> set = new HashSet<>();
        int[] sumArr = new int[n];

        // 초기 길이 1인 부분합을 준비
        for (int i = 0; i < n; i++) {
            sumArr[i] = elements[i];
            set.add(sumArr[i]);
        }
        
        // 길이 2 ~ n까지 부분합 누적
        for (int length = 1; length < n; length++) {
            for (int i = 0; i < n; i++) {
                sumArr[i] += elements[(i + length) % n];
                set.add(sumArr[i]);
            }
        }
        
        return set.size();
    }
}
