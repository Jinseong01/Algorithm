class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        
        for(int i=0; i<k; i++) {
            for(int j=0; j<my_string.length(); j++) {
                answer += my_string.charAt(j);
            }
        }
        
        return answer;
    }
}