import java.util.*;

class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    
    public int solution(int[][] maps) {
        // 최소경로 탐색 -> DFS
        // maps[n-1][m-1]에 도착했을 때의, count 반환
        
        // 1. 초기화
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        // 2. 시작점 설정
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 1});  //시작점도 이동에 포함
        visited[0][0] = true;
        
        // 3. 미로 찾기 BFS
        while(!deque.isEmpty()) {
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            // 도착
            if (x == n-1 && y == m-1) {
                return count; 
            }
            
            // 이동 가능한 상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx>=0 && nx<n && ny>=0 && ny<m
                    && maps[nx][ny] != 0
                   && !visited[nx][ny]) {
                    deque.add(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
            
        }
        
        return -1;
    }
}