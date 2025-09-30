class Solution {
    public int solution(int n, int a, int b) {   
        int answer = 1;
        
        while(true) {
            // 1. 현재 번호 비교
            if ((a + 1) / 2 == (b + 1) / 2) {
                break;
            }

            // 2. 다음 라운드로
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        
        return answer;
    }
}