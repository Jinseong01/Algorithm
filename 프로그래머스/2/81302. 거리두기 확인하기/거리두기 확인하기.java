import java.util.*;

class Solution {

    // 상 우 하 좌
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {

        int[] answer = new int[places.length];

        for (int room=0; room<places.length; room++) {

            boolean flag = true;

            for (int x=0; x<5 && flag; x++) {
                for (int y=0; y<5 && flag; y++) {

                    // 현재 위치가 사람이 아니면 패스
                    if (places[room][x].charAt(y) != 'P') {
                        continue;
                    }

                    // BFS 거리두기 검사
                    if (!bfs(places[room], x, y)) {
                        flag = false;
                    }
                }
            }

            answer[room] = flag? 1 : 0;
        }

        return answer;
    }

    private boolean bfs(String[] room, int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        // x, y, 거리
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 거리 2까지만 탐색
            if (dist>=2) {
                continue;
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 밖이거나 이미 방문했거나 파티션이면 패스
                if (nx<0 || nx>=5 || ny<0 || ny>=5 ||
                    visited[nx][ny] || room[nx].charAt(ny)=='X') {
                    continue;
                }

                // 다른 사람이 있으면 거리두기 위반
                if (room[nx].charAt(ny)=='P') {
                    return false;
                }

                // 빈 테이블이면 계속 탐색
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist+1});
            }
        }

        return true;
    }
}