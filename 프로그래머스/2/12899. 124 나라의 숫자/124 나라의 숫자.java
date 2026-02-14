import java.util.*;

class Solution {
    public String solution(int n) {
        // n을 124 나라의 규칙에 맞게 변환한 값
        
        // 3진법이지만
        // 나머지가 1이면 → 1
        // 나머지가 2이면 → 2
        // 나머지가 0이면 → 4 (대신 몫을 -1)
        
        // ex) n = 6
        // step1) 6/3 = 2 ... 0 -> 나머지 0을 4로 변환
        // step2) 몫을 -1하여 2가 아닌 1로 계산 -> 1/3 = 0 ... 1
        // 14
        
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 1) {
                sb.append("1");
            }
            else if (remainder == 2) {
                sb.append("2");
            }
            else {
                sb.append("4");
                n--;    
            }
        }

        return sb.reverse().toString();
    }
}