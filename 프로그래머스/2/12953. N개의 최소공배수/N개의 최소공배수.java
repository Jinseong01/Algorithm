class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for (int num : arr) {
            answer = lcm(answer, num);
        }
        
        return answer;
    }
    
    // a*b = lcm(a,b) * gcd(a*b)
    // ex)
    // 2 * 6 = lcm(2,6) * gcd(2,6)
    //    12 = 6 * 2 
    
    // 최소공배수
    // = (a*b) / gcd(a, b)
    private int lcm(int a, int b) {
        return (a*b) / gcd(a,b);
    }
    
    // 최대공약수
    // 유클리드 호제법 개념 : a,b와 (a-b)는 동일한 최대공약수를 갖는다
    // 48 - 18 
    // = (d × a) - (d × b)
    // = d × (a - b)
    private int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        
        return gcd(b, a%b);
    }
}