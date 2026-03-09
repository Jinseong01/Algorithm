class Solution {
    public int solution(int n, int w, int num) {
        int rows = (n+w-1) /w;
        int cols = w;
        int[][] map = new int[rows][cols];
        
        int box = 1;
        int numX = 0;
        int numY = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols && box<=n; j++) {
                
                int col = (i%2==0) ? j : cols-1-j;
                
                if (box==num) {
                    numX = i;
                    numY = col;
                }
                
                map[i][col] = box++;
            }
        }
        
        int answer = 0;
        while(numX<rows && map[numX][numY]!=0) {
            numX++;
            answer++;
        }
        
        return answer;
    }
}