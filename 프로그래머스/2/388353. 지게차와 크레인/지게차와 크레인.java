import java.util.*;

class Solution {
    
    char[][] storageMap;
    int rows, cols;
    int[] dx = {-1, 1, 0, 0};  // 상하좌우
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        // char[][] 초기화
        // requests 순회
        //    지게차 요청
        //      1. BFS 1번 -> 외부 연결된 컨테이너('0') 갱신 (boolean[][] 관리)
        //      2. 이중 for문 -> 테두리이거나 외부 연결 '0'에 인접한 타겟 제거
        //    크레인 요청
        //      1. 이중 for문 -> 해당 컨테이너 전부 제거
        
        // 초기화
        rows = storage.length;
        cols = storage[0].length();
        storageMap = new char[rows][cols];
        for(int i=0; i<rows; i++) {
            storageMap[i] = storage[i].toCharArray();
        }
        
        // 요청 확인
        for(String request : requests) {
            char target = request.charAt(0);
            
            // 지게차
            if(request.length()==1) {
                // 외부와 연결된 '0' 탐색
                boolean[][] connected = bfs();
                
                for(int i=0; i<rows; i++) {
                    for(int j=0; j<cols; j++) {
                        if(storageMap[i][j] == target) {
                            // 테두리 타겟
                            boolean removable = (i==0 || i==rows-1 || j==0 || j==cols-1);
                            
                            // 외부와 연결된 타겟
                            for(int d=0; d<4; d++) {
                                int nx = i+dx[d];
                                int ny = j+dy[d];
                                
                                if(nx>=0 && nx<rows && ny>=0 && ny<cols && connected[nx][ny]) {
                                    removable = true;
                                }
                            }
                            
                            // 꺼낼 수 있는 타겟이라면
                            if(removable) {
                                storageMap[i][j] = '0';
                            }
                        }
                    }
                }
            }
            // 크레인
            else {
                for(int i=0; i<rows; i++) {
                    for(int j=0; j<cols; j++) {
                        // 타겟 전부 제거
                        if(storageMap[i][j] == target) {
                            storageMap[i][j] = '0';
                        }
                    }
                }
            }
        }
        
        // 남은 컨테이너 카운트
        int answer = 0;
        for(char[] row : storageMap) {
            for(char c : row) {
                if(c != '0') {
                    answer++;
                }
            }
        }

        return answer;
    }
    
    private boolean[][] bfs() {
        boolean[][] connected = new boolean[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        
        // 테두리에 존재하는 '0'을 시작점으로 설정
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if((i==0 || i==rows-1 || j==0 || j==cols-1) && storageMap[i][j] == '0') {
                    queue.add(new int[]{i, j});
                    connected[i][j] = true;
                }
            }
        }
        
        // BFS로 외부와 연결된 '0' 전부 탐색
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // 범위 벗어나면 패스
                if(nx<0 || nx>=rows || ny<0 || ny>=cols) {
                    continue;
                }
                
                // 미방문 '0'이면 큐에 추가
                if(storageMap[nx][ny]=='0' && !connected[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    connected[nx][ny] = true;
                }
            }
        }
        
        return connected;
    }
}