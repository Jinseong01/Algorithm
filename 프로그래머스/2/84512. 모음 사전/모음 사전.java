class Solution {
    
    private static String[] vowels = {"A", "E", "I", "O", "U"};
    private static int answer;
    private static int count;
    private static String target;
    
    public int solution(String word) {
        // _ _ _ _ _ (A E I O U)
        // 1자리씩 선택하면서 탐색
        
        answer = 0;
        count = 0;
        target = word;
        
        dfs("");
        
        return answer;
    }
    
    private void dfs(String current) {       
        // 종료 조건 (타겟 단어)
        if (current.equals(target)) {
            answer = count;
            return;
        }
        
        if (current.length() == 5) return;
        
        for(String s : vowels) {
            count++;
            dfs(current+s);
        }
    }
}