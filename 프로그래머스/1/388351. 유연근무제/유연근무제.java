class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 일주일 동안 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트
        // {자신이 설정한 출근 희망 시각 + 10분}까지 출근 (토요일, 일요일 제외)
        // 모든 시각은 {시에 100을 곱하고 분을 더한 정수}로 표현
        // 상품을 받을 직원의 수 구하기
        
        int answer = 0;
        for(int i=0; i<schedules.length; i++) {
            int start = schedules[i];  // ex. 958
            int endMin = (start / 100) * 60 + (start % 100) + 10;  // ex. 9*60 + 58+10 = 608
            int end = (endMin / 60) * 100 + (endMin % 60);  // ex. 1008
            boolean notLate = true;
            
            for(int j=0; j<7; j++) {
                // j는 0, weekday는 5(금요일)
                // j는 1, weekday는 6(토요일)
                // j는 2, weekday는 7(일요일)
                // ...
                int weekday = (startday-1 + j) % 7 + 1;

                if (weekday!=6 && weekday!=7 && timelogs[i][j] > end) {
                    notLate = false;
                    break;
                }
            }
            
            if(notLate) {
                answer++;
            }
        }
        
        return answer;
    }
}