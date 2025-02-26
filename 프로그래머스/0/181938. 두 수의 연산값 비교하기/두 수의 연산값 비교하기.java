class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String tmp1 = String.valueOf(a) + String.valueOf(b);
        String tmp2 = String.valueOf(2*a*b);
        
        answer = Math.max(Integer.parseInt(tmp1), Integer.parseInt(tmp2));
        
        return answer;
    }
}