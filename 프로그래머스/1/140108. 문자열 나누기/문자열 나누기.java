class Solution {    
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char x = ' ';

        for (int i=0; i<s.length(); i++) {
            // 매 시작 단계
            if (same == 0) {
                x = s.charAt(i);
                same++;
            }
            // 이후 단계
            else {
                // x와 같은 글자라면
                if (s.charAt(i) == x) same++;
                
                // x와 다른 글자라면
                else diff++;
            }
            
            // 각 횟수가 같아지면
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }

        // 마지막에 남은 경우
        return same>0 ? answer+1 : answer;
    }
}