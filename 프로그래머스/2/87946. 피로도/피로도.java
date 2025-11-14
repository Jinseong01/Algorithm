class Solution {
    
    private static int answer;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        // 최소 필요 피로도 & 소모 피로도
        // -> 현재 피로도 < 최소 필요 피로도 BACK
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int count) {
        if(count>answer) {
            answer = count;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k>=dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}