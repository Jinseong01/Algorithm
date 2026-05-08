import java.util.*;

class Solution {
    
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(1, 2, 3, n);
        
        return list.toArray(new int[list.size()][]);
    }
    
    private void hanoi(int from, int tmp, int to, int n) {
        if (n==1) {
            list.add(new int[]{from, to});
            return;
        }
        
        // 1. 대상 원판 위에 있는 원판들 옮기기
        hanoi(from, to, tmp, n-1);
        
        // 2. 대상 원판 옮기기
        hanoi(from, tmp, to, 1);
        
        // 3. 치워둔 원판들 옮기기
        hanoi(tmp, from, to, n-1);
    }
}