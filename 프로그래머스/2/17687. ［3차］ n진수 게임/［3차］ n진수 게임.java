
class Solution {
    public String solution(int n, int t, int m, int p) {
        // n : 진법
        // t : 구해야 되는 숫자의 개수
        // m : 게임 참가인원
        // p : 주인공 순서
        
        int number = 0; // 변환 이전의 10진법 숫자
        int turn = 0;   // 게임 차례
        StringBuilder sb = new StringBuilder(); // 주인공이 말해야 되는 숫자들
        
        while (sb.length() < t) {
            // n진법으로 숫자 변환
            String convert = convertNumber(number, n);
                
            // 각 숫자를 순회
            for (char c : convert.toCharArray()) {
                turn++;
                
                // 주인공의 순서일 때에만
                if (turn%m == p%m) {
                    // 결과에 추가
                    sb.append(c);
                    
                    // t개를 모았다면 종료
                    if (sb.length() == t) {
                        break;
                    }
                }
            }
            
            number++;
        }
        
        return sb.toString().toUpperCase();
    }
    
    
    private String convertNumber(int number, int base) {
        // 조기반환
        if (number == 0) {
            return "0";
        }
        
        String digits = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        
        while (number>0) {
            int remain = number % base;
            sb.append(digits.charAt(remain));
            
            number /= base;
        }

        return sb.reverse().toString();
    }
}