import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        
        while(n > 0) {
            int now = n % 10;
            sum += now;
            
            n /= 10;
        }
        
        return sum;
    }
}