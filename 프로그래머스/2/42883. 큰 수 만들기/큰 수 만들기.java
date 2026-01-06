class Solution {
    public String solution(String number, int k) {
        int length = number.length();
        int selectCount = length - k;
        
        StringBuilder answer = new StringBuilder();
        int startIndex = 0;
        
        // selectCount개의 숫자를 선택
        for (int i = 0; i < selectCount; i++) {
            char maxChar = '0';
            int maxIndex = startIndex;
            
            // 선택 가능한 범위에서 가장 큰 숫자 찾기
            // (끝범위를 제한하여 이후 선택을 보장)
            
            int endIndex = length - selectCount + i;
            for (int j = startIndex; j <= endIndex; j++) {
                if (number.charAt(j) > maxChar) {
                    maxChar = number.charAt(j);
                    maxIndex = j;
                }
            }
            
            // 정답에 이어붙이고 다음 탐색위치를 해당 숫자 뒤로 업데이트
            answer.append(maxChar);
            startIndex = maxIndex + 1;
        }
        
        return answer.toString();
    }
}