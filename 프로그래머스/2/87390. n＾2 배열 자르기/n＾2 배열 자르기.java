class Solution {
    public int[] solution(int n, long left, long right) {
        int idx=0;
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        for (long i = left; i <= right; i++) {
            long y = i / n;
            long x = i % n;
            
            long value = Math.max(y+1, x+1);
            
            answer[idx++] = (int)value;
        }
        
        return answer;
    }
}