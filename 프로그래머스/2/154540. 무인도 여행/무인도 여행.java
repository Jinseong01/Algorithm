import java.util.*;

class Solution {
    
    ArrayList<Integer> answer = new ArrayList<>();
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int rows, cols;
    char[][] map;
    boolean[][] visited;

    public int[] solution(String[] maps) {
        
        rows = maps.length;
        cols = maps[0].length();
        
        map = new char[rows][cols];
        for (int i=0; i<rows; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(map[i][j]!='X' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        // Collections.sort(answer);
        // return answer.stream().mapToInt(Integer::intValue).toArray();
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    private void bfs(int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        int total = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            total += map[x][y] - '0';
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx<0 || nx>=rows || ny<0 || ny>=cols) {
                    continue;
                }
                
                if(map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }
                
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        answer.add(total);
    }
}