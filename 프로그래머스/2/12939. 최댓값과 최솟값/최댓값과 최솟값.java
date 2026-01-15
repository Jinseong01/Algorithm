class Solution {
    public String solution(String s) {
        String[] parsed = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String n : parsed) {
            int num = Integer.parseInt(n);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return min + " " + max;
    }
}