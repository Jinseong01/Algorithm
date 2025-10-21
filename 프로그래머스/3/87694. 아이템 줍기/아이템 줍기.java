import java.util.*;

class Solution {
    
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 가장 짧은 거리 => BFS
        // 미로찾기처럼 진행하되, 다음 좌표가 [사각형의 테두리에 위치 O & 사각형의 내부에 위치 X]
        
        // 좌표 2배 (테두리를 따르지 않고 점프하는 경우를 위해)
        for(int i=0; i<rectangle.length; i++) {
            rectangle[i][0] = rectangle[i][0]*2;
            rectangle[i][1] = rectangle[i][1]*2;
            rectangle[i][2] = rectangle[i][2]*2;
            rectangle[i][3] = rectangle[i][3]*2;
        }
        characterX *= 2; characterY *= 2;
        itemX *= 2; itemY *= 2;
        
        
        boolean[][] visited = new boolean[101][101]; // 좌표 범위 1~50 (x2)
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            // 도착
            if (x==itemX && y==itemY){
                return count / 2;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 방문하지 않았는지 && 이동경로 상의 좌표인지
                if(1<=nx && nx<=100 && 1<=ny && ny<=100
                    && !visited[nx][ny]
                   && check(nx, ny, rectangle)) {
                    dq.add(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1; // 임의의 값
    }
    
    private static boolean check(int x, int y, int[][] rectangle) {
        // 모든 사각형에 대해 내부인지 확인
        for (int i=0; i<rectangle.length; i++) {
            if(isInside(x, y, rectangle[i]))    return false;
        }
        
        // 사각형 테두리에 있는지 확인
        for (int i=0; i<rectangle.length; i++) {
            if(isBorder(x, y, rectangle[i]))    return true;
        }
        
        return false;
    }
    
    // 테두리에 있는지 확인
    private static boolean isBorder(int x, int y, int[] rectangle) {
        int lx = rectangle[0];
        int ly = rectangle[1];
        int rx = rectangle[2];
        int ry = rectangle[3];

        return (x==lx || x==rx) && (ly<=y && y<=ry) ||
            (y==ly || y==ry) && (lx<=x && x<=rx);
    }
    
    // 내부에 있는지 확인
    private static boolean isInside(int x, int y, int[] rectangle) {
        int lx = rectangle[0];
        int ly = rectangle[1];
        int rx = rectangle[2];
        int ry = rectangle[3];

        return (lx<x && x<rx && ly<y && y<ry);
    }
}