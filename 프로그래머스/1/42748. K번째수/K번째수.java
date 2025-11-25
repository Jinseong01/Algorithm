import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int T=0; T<n; T++) {
            int i = commands[T][0] - 1;
            int j = commands[T][1];
            int k = commands[T][2] - 1;
            
            int[] sliced = Arrays.copyOfRange(array, i, j);
            Arrays.sort(sliced);
            
            answer[T] = sliced[k];
        }
        
        return answer;
    }
}