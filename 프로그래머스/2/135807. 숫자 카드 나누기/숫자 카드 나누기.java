class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 조건1 or 조건2 만족하는 가장 큰 양수 a
        // 조건1) arrayA 숫자들의 최대 공약수이며, arrayB의 모든 숫자를 나눌 수 없음
        // 조건2) arrayB 숫자들의 최대 공약수이며, arrayA의 모든 숫자를 나눌 수 없음
        
        // 1. 각 배열의 GCD 구하기
        int gcdA = arrayA[0];
        for (int i=1; i<arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i=1; i<arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        // 2. 상대 배열 검증
        for (int num : arrayB) {
            // 나눠지면 0 처리
            if (num%gcdA == 0) {
                gcdA = 0;
                break;
            }
        }
        
        for (int num : arrayA) {
            // 나눠지면 0 처리
            if (num%gcdB == 0) {
                gcdB = 0;
                break;
            }
        }
        
        return Math.max(gcdA, gcdB);
    }
    
    public int gcd(int a, int b) {
        if (b==0) return a;
        
        return gcd(b, a%b);
    }
}