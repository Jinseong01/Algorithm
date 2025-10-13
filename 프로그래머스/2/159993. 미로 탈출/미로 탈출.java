import java.util.*;

class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] maze;
    private static boolean[][] visited;
    private static int n, m;
    
    public int solution(String[] maps) {
        // 1. 초기화
        n = maps.length;
        m = maps[0].length();
        maze = new char[n][m];
        for(int i=0; i<n; i++) {
            maze[i] = maps[i].toCharArray();
        }
        
        // 2. 각 좌표 구하기
        int startX = -1, startY = -1;
        int leverX = -1, leverY = -1;
        int endX = -1, endY = -1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                else if(maze[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                else if(maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // 3. 미로 탈출 (start->lever + lever+end)        
        int sToL = bfs(startX, startY, leverX, leverY);
        int lToE = bfs(leverX, leverY, endX, endY);
        
        if (sToL==-1 || lToE==-1) {
            return -1;
        }
        return sToL + lToE;
    }
    
    private static int bfs(int fromX, int fromY, int toX, int toY) {
        // 방문여부 초기화 (각 탐색을 독립적으로 하기 위해)
        visited = new boolean[n][m];
        
        // 시작점 설정
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{fromX, fromY, 0});
        visited[fromX][fromY] = true;
        
        // 탐색
        while(!deque.isEmpty()) {
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            // 도착
            if (x == toX && y == toY) {
                return count; 
            }
            
            // 이동 가능한 상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx>=0 && nx<n && ny>=0 && ny<m
                    && maze[nx][ny] != 'X'
                   && !visited[nx][ny]) {
                    deque.add(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}