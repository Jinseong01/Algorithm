class Solution {
public int solution(String dirs) {
        // 1. 세팅
        // 좌표 : 11x11 배열 + 4방향 : [0:U,1:D,2:R,3:L]
        boolean[][][] visited = new boolean[11][11][4];
    
        // 시작점 중앙 (0,0 → 배열로는 5,5)
        int x = 5, y = 5;
        int distance = 0;
    
        // 이동 및 거리 계산
        for (char c : dirs.toCharArray()) {
            // 이동 예정인 곳의 좌표
            int nx = x;
            int ny = y;
            // 이동 방향과 반대 방향
            int d = 0;
            int o = 0;
            
            // 이동 예정인 곳 계산
            switch (c) {
                case 'U':
                    // 배열상으로는 위로 이동 시 더 작은 숫자로 이동을 의미
                    ny--; d=0; o=1;
                    break;
                case 'D':
                    ny++; d=1; o=0;
                    break;
                case 'R':
                    nx++; d=2; o=3;
                    break;
                case 'L':
                    nx--; d=3; o=2;
                    break;
            }
            
            // 이동 예정인 곳이 범위를 벗어나면 패스
            if (nx>10 || nx<0 || ny>10 || ny<0) {
                continue;
            }
            
            // 처음인 곳에 대해서만 이동 적용 (행이 y / 열이 x)
            if (!visited[y][x][d]) {
                // 현재 좌표 기준으로 이동 방향 방문처리
                visited[y][x][d] = true;
                // 이동 예정 좌표 기준으로 반대 방향 방문처리
                visited[ny][nx][o] = true;
                distance++;
            }
            
            x = nx;
            y = ny;
        }

        
        return distance;
    }
}