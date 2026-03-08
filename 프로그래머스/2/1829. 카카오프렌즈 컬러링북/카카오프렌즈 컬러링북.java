import java.util.*;

class Solution {

    int m, n;
    int[][] picture;
    boolean[][] visited;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        // 영역의 개수와 가장 큰 영역의 넓이
        // 색칠된 영역을 기준으로 동일 색상만 탐색
        
        this.m = m;
        this.n = n;
        this.picture = picture;
        this.visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // 미방문이고 색칠된 영역이면 탐색
                if (!visited[i][j] && picture[i][j]!=0) {
                    int size = bfs(i, j);
                    
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int x, int y) {
        int color = picture[x][y];
        int size = 1;
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d=0; d<4; d++) {
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];

                if (nx>=0 && nx<m && ny>=0 && ny<n
                    && !visited[nx][ny] && picture[nx][ny]==color) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    
                    size++;
                }
            }
        }
        
        return size;
    }
}