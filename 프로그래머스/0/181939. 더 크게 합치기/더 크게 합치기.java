class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = String.valueOf(a) + String.valueOf(b);
        String ba = String.valueOf(b) + String.valueOf(a);
        
        answer = Math.max(Integer.parseInt(ab), Integer.parseInt(ba));
        
        return answer;
    }
}