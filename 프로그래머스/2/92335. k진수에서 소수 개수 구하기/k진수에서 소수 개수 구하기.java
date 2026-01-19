import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        // 1. k진수 구하기
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int mod = n % k;
            sb.append(mod);
            
            n /= k;
        }
        
        sb.reverse();

        
        // 2. 조건에 맞는 소수 찾기
        String[] answer = sb.toString().split("0");
        
        return (int) Arrays.stream(answer)
            .filter(x -> !x.isEmpty())
            .filter(x -> isPrime(x))
            .count();
    }

    // 소수 : 1과 자기 자신만을 약수
    private boolean isPrime(String x) {
        long num = Long.parseLong(x);
        
        if (num<2) {
            return false;
        }
        
        for (long i=2; i*i<=num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        
        return true;
    }
}