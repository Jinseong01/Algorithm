class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        // 1. 초기화
        int[][] board = new int[rows][columns];

        int num = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                board[i][j] = num++;
            }
        }

        // 2. 각 회전 쿼리 수행
        int[] answer = new int[queries.length];
        for (int q=0; q<queries.length; q++) {
            // 0-based
            int x1 = queries[q][0]-1;
            int y1 = queries[q][1]-1;
            int x2 = queries[q][2]-1;
            int y2 = queries[q][3]-1;
            
            // 덮어쓰기 방지를 위해 임시 저장
            int temp = board[x1][y1];
            
            int min = temp;
            // 왼쪽 세로 (아래쪽->위쪽)
            for(int i=x1; i<x2; i++) {
                board[i][y1] = board[i+1][y1];
                min = Math.min(min, board[i][y1]);
            }
            
            // 아래쪽 가로 (오른쪽->왼쪽)
            for(int i=y1; i<y2; i++) {
                board[x2][i] = board[x2][i+1];
                min = Math.min(min, board[x2][i]);
            }
            
            // 오른쪽 세로 (위쪽->아래쪽)
            for(int i=x2; i>x1; i--) {
                board[i][y2] = board[i-1][y2];
                min = Math.min(min, board[i][y2]);
            }
            
            // 위쪽 가로 (왼쪽->오른쪽)
            for(int i=y2; i>y1+1; i--) {
                board[x1][i] = board[x1][i-1];
                min = Math.min(min, board[x1][i]);
            }
            
            // 임시 저장 값 마지막 위치에 삽입
            board[x1][y1+1] = temp;
            
            answer[q] = min;
        }

        return answer;
    }
}