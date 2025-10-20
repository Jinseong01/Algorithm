import java.util.*;

class Solution {
    
    private static int answer;
    
    public int solution(String begin, String target, String[] words) {
        // hit -> dog
        // hot dot dog lot log cog
        // 최소 몇단계 -> DFS
        
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    private static int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        ArrayDeque<Object[]> dq = new ArrayDeque<>();
        dq.add(new Object[]{begin, 0});
        
        while(!dq.isEmpty()) {
            Object[] now = dq.poll();
            String nowWord = (String)now[0];
            int count = (Integer)now[1];
            
            if (nowWord.equals(target)) {
                return count;
            }
            
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && check(nowWord, words[i])) {
                    visited[i] = true;
                    dq.add(new Object[]{words[i], count+1});
                }
            }
        }
        
        return 0;
    }
    
    private static boolean check(String a, String b) {
        int diff = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return (diff == 1);
    }    
}