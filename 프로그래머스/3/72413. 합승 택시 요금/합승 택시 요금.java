import java.util.*;

class Solution {
    
    private static List<int[]>[] adjList;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 최소비용 + 가중치 = 다익스트라
        // 시작점~i + i~A + i~B 합의 최소값
        
        // 1. 초기화
        // 그래프 초기화 (1-based)
        adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            adjList[fare[0]].add(new int[] {fare[1], fare[2]});
            adjList[fare[1]].add(new int[] {fare[0], fare[2]});
        }
        
        // 거리 초기화
        int[] distS = new int [n+1];
        int[] distA = new int [n+1];
        int[] distB = new int [n+1];
        
        Arrays.fill(distS, Integer.MAX_VALUE);
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        
        
        // 2. 다익스트라
        dijkstra(s, distS);
        dijkstra(a, distA);
        dijkstra(b, distB);
        
        // 3. S->i + i~A + i~B 의 최소값 구하기
        // (i가 S인 경우가 최소라면 아예 합승하지 않는 것)
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            int sum = distS[i] + distA[i] + distB[i];
            if(min > sum) {
                min = sum;
            }
        }
        
        return min;
    }
    
    private void dijkstra(int start, int[] dist) {
        boolean[] visited = new boolean[dist.length];
        
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if(visited[now[0]]) {
                continue;
            }
            
            visited[now[0]] = true;
            
            for(int[] next : adjList[now[0]]) {
                if(dist[next[0]] > now[1] + next[1]) {
                    dist[next[0]] = now[1] + next[1];
                    pq.add(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
}