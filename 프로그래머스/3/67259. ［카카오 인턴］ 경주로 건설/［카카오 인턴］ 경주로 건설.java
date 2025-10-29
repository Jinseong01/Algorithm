import java.util.*;

public class Solution {

    // 상우하좌
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    // 직선,코너
    private static final int STRAIGHT = 100;
    private static final int CORNER = 600;

    public int solution(int[][] board) {
        // 1. 초기화
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int[][] arr2D : cost) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, Integer.MAX_VALUE);
            }
        }

        // 오름차순 우선순위큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[3], b[3]));

        // 시작점에서의 초기 설정 우(1), 하(2)) 방향 초기화
        // 큐에는 (x, y, 상하좌우 방향, 누적된 cost)순으로 넣음
        pq.add(new int[]{0, 0, 1, 0});
        pq.add(new int[]{0, 0, 2, 0});
        cost[0][0][1] = 0;
        cost[0][0][2] = 0;
        
    
        // 2. 최소비용 구하기
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];
            int c = cur[3];

            // 도착
            if (y == n - 1 && x == n - 1) {
                return c;
            }

            // 상우하좌 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;   // 범위 벗어나면
                if (board[ny][nx] == 1) continue;   // 벽이면

                // 기존과 동일한 방향으로의 이동이면 직선도로 / 다른 방향으로의 이동이면 코너
                int newCost = c + ((dir == i) ? STRAIGHT : CORNER);

                // 더 적은 비용으로 이동 가능하면 갱신
                if (cost[ny][nx][i] > newCost) {
                    cost[ny][nx][i] = newCost;
                    pq.add(new int[]{ny, nx, i, newCost});
                }
            }
        }
        
        return 0;
    }
}