class Solution {
    public int solution(int [][]board) {
        int row = board.length;
        int col = board[0].length;
        
        int[][] dp = new int[row][col];
        // dp[i][j]는 i,j를 우측하단으로 하는 정사각형의 한변의 길이
        
        int answer = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                // 해당 칸의 숫자가 1이라면
                if(board[i][j] == 1) {
                    // 첫 행 or 첫 열
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    
                    // 나머지
                    else {
                        dp[i][j] =
                            Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer * answer;
    }
}