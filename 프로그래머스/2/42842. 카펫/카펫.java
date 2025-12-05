class Solution {
    public int[] solution(int brown, int yellow) {
        // 상황)
        // 중앙 노란색 & 테두리 갈색인 카펫
        // 각각 노란색&갈색 타일 개수를 주면 => 카펫 가로&세로 구하기
        
        // 조건)
        // 가로 길이 >= 세로 길이 => 정사각형 or 가로로 긴 직사각형
        
        int sum = brown + yellow;
        
        // 카펫 세로 길이의 최소는 3
        for(int h = 3; h <= sum/h; h++) {
        
            // 현재 카펫 세로 길이가 카펫 넓이의 약수
            if(sum % h == 0) {
            
                int w = sum / h;
                
                // (카펫가로-2)*(카펫세로-2)가 yellow와 동일
                if((w-2) * (h-2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        
        return null;
    }
}