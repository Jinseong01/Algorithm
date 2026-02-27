class Solution {
    public int solution(int storey) {
        // -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10^c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼
        // storey -> 0층 가기 위해 필요한 마법의 돌의 최소값
        
        // ex)
        // 16층 -> 0층
        // -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌 7개
        // +1이 적힌 버튼을 4번, -10이 적힌 버튼을 2번 눌러 마법의 돌 6개
        
        int answer = 0;

        while (storey>0) {
            int digit = storey % 10;  // 현재 자릿수
            int nextDigit = (storey/10) % 10;  // 다음 자릿수

            // 올림하는 경우
            if (digit>5 || (digit==5 && nextDigit>=5)) {
                answer += (10-digit);
                storey += 10;
            }
            // 내림하는 경우
            else {
                answer += digit;
            }

            storey /= 10;
        }

        return answer;
    }
}