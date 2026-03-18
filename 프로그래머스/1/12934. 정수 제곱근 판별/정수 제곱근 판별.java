class Solution {
    public long solution(long n) {
        // n이 양의 정수 x의 제곱 -> x+1의 제곱
        // n이 양의 정수 x의 제곱 X -> -1
    
        long x = (long) Math.sqrt(n);
        
        if ((long) Math.pow(x, 2) == n) {
            return (long) Math.pow(x+1, 2);
        }
        
        return -1;
        
        // for (long x=1; x*x<=n; x++) {
        //     if (x*x == n) {
        //         return (x+1) * (x+1);
        //     }
        // }
        // return -1;
    }
}