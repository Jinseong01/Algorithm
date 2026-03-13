import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // 각 원소의 합이 S & 각 원소의 곱을 최대로
        
        if (s<n) {
            return new int[]{-1};
        }
        
        int share = s/n;
        int remainder = s%n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, share);
        
        for (int i=n-remainder; i<n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}