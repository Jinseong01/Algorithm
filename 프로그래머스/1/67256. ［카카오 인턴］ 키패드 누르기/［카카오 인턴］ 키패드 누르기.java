class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        // 키패드 위치를 좌표로 생각
        int[][] pos = {
            {3,1},  // 0
            {0, 0}, {0, 1}, {0, 2},  // 1, 2, 3
            {1, 0}, {1, 1}, {1, 2},  // 4, 5, 6
            {2, 0}, {2, 1}, {2, 2}   // 7, 8, 9
        };
        
        // 왼손&오른손의 위치 (초기 : *,#)
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int num : numbers) {
            // 1, 4, 7은 왼손 사용
            if(num==1 || num==4 || num==7) {
                sb.append("L");
                left = pos[num];
            }
            
            // 3, 6, 9는 오른손 사용
            else if (num==3 || num==6 || num==9) {
                sb.append("R");
                right = pos[num];
            }
            
            // 2, 5, 8, 0은 판단 필요
            else {
                // 왼손&오른손 각각 거리 계산
                int distL = calcDist(left, pos[num]);  // 왼손~num 거리
                int distR = calcDist(right, pos[num]);  // 오른손~num 거리
                
                // 왼손이 더 가깝
                if(distL<distR) {
                    sb.append("L");
                    left = pos[num];
                }
                
                // 오른손이 더 가깝
                else if(distL>distR) {
                    sb.append("R");
                    right = pos[num];
                }
                
                // 거리가 동일하기 때문에 어느 손잡이인지에 따라 결정
                else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = pos[num];
                    }
                    else {
                        sb.append("R");
                        right = pos[num];
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    private int calcDist(int[] from, int[] to) {
        return Math.abs(from[0]-to[0]) + Math.abs(from[1]-to[1]);
    }
}