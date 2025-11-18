class Solution {
    
    private static int n;
    private static int answer;
    
    public int solution(int n) {
        this.n = n;
        int[] board = new int[n]; // i행에 놓인 퀸의 열 위치
        dfs(0, board);
        return answer;
    }
    
    
    private void dfs(int row, int[] board) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;  // row행 col열 퀸 배치
            
            // 이전 행들의 퀸들과 충돌 확인
            if (isValid(row, board)) {
                dfs(row + 1, board);  // 다음 퀸 배치
            }
        }
    }
    
    private boolean isValid(int row, int[] board) {
        for (int i = 0; i < row; i++) {
            // 같은 열인 경우
            if (board[i] == board[row]) {
                return false;
            }
            
            // 대각선인 경우
            if (Math.abs(board[i] - board[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}