class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // computers[0] = {1, 1, 0} 이라면
        // 순서대로 {자기자신, 1번 컴퓨터, 2번 컴퓨터}와의 네트워크 연결 관계를 표현한 것
        // 각 컴퓨터 순차적으로 탐색 -> 탐색 횟수 반환
        // (※ 같은 네트워크면 방문처리를 통해서 추후 탐색 X므로 횟수에 반영되지 않음)
        
        // 1. 초기화
        int answer = 0;
        visited = new boolean[n];
        
        // 2. i번에 대해서 dfs 탐색 (방문하지 않은 경우에만)
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int start, int[][] computers, int n) {
        visited[start] = true;
    
        for(int i=0; i<n; i++) {
            if(!visited[i] && computers[start][i]==1) {
                dfs(i, computers, n);
            }
        }
    }
}