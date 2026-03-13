import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // A팀 출전 순서 공개 -> B팀이 최대 승점 구하기
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        
        int bIdx = 0;
        for (int i=0; i<A.length; i++) {
            // A팀의 숫자보다 큰 B팀의 숫자 찾기
            while (bIdx<B.length && B[bIdx]<=A[i]) {
                bIdx++;
            }
            
            // B팀 인원이 끝나지 않았다면
            if (bIdx<B.length) {
                answer++;
                bIdx++;
            }
        }
        
        return answer;
    }
}