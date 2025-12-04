class Solution {
    public int[] solution(String s) {
        int changeCount = 0;
        int removedZeros = 0;
        
        while(!s.equals("1")) {
            changeCount++;
            
            // 1. 0 제거
            int originLength = s.length();
            s = s.replace("0", "");
            
            removedZeros += originLength - s.length();
            
            // 2. 길이를 2진법 변환
            s = toBinary(s.length());
        }
        
        return new int[]{changeCount, removedZeros};
    }
    
    
    private static String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}