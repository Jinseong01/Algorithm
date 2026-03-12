import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    boolean[][] visited;
    int rows, cols;
    char[][] map;
    
    public int solution(String[] board) {
        // 시작 -> 목표 정확하게 멈추기 위한 최소 이동횟수
        // 1번 이동 = 상, 하, 좌, 우 중 한 방향으로 장애물이나 가장자리까지 부딪힐 때까지 이동
        // R:로봇 / G:목표 / D:장애물 / .:빈공간
        
        rows = board.length;
        cols = board[0].length();
        visited = new boolean[rows][cols];
        map = new char[rows][cols];
        
        // 초기화 & 시작 위치 찾기
        int startX = 0;
        int startY = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                map[i][j] = board[i].charAt(j);
                
                if (map[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY);
    }
    
    private int bfs(int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if(map[x][y] == 'G') {
                return count;
            }
            
            
            for(int d=0; d<4; d++) {
                int nx = x;
                int ny = y;
                
                // 장애물이나 가장자리까지 부딪힐 때까지 이동
                while (true) {
                    int nextX = nx+dx[d];
                    int nextY = ny+dy[d];
                    
                    if (nextX<0 || nextX>=rows 
                        || nextY<0 || nextY>=cols 
                        || map[nextX][nextY]=='D') {
                        break;
                    }
                    
                    nx = nextX;
                    ny = nextY;
                }
                
                
                if(!visited[nx][ny]) {
                    queue.add(new int[] {nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}