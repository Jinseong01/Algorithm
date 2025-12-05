class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // 상황)
        // 0,0에서 시작
        // keyinput에 따라서 최종 이동한 좌표
        
        // 조건)
        // 0,0은 board의 정중앙에 위치
        
        int x = 0, y = 0;
        int limitX = board[0]/2, limitY = board[1]/2;
        
        for(String key : keyinput) {
            switch(key) {
                case "up" -> y = Math.min(y + 1, limitY);
                case "down" -> y = Math.max(y - 1, -limitY);
                case "left" -> x = Math.max(x - 1, -limitX);
                case "right" -> x = Math.min(x + 1, limitX);
            }
        }
        
        return new int[]{x, y};
    }
}