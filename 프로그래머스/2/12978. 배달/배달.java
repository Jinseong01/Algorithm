import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 각 마을을 잇는 도로가 존재 & 도로별로 소요시간(가중치)이 다름
        // 1번 마을로부터 K시간 이하로 배달 가능한 마을의 개수
        // => 다익스트라
        
        // 1. 그래프(무방향 그래프) 초기화
        ArrayList<int[]>[] adjList = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge: road) {
            adjList[edge[0]].add(new int[]{edge[1], edge[2]});
            adjList[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        
        // 2. 각 마을까지의 최소시간 & 방문여부 초기화
        int[] times = new int[N+1];
        Arrays.fill(times, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];
        
        
        // 3. 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        times[1] = 0;
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if(visited[now[0]]) {
                continue;
            }
            
            visited[now[0]] = true;
            
            for(int[] next : adjList[now[0]]) {
                if(times[next[0]] > now[1] + next[1]) {
                    times[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], times[next[0]]});
                }
            }
        }
        
        
        // 4. K시간 이하 마을 카운트 (1번 마을 포함)
        int count = 0;
        for(int time : times) {
            if (time <= K) {
                count++;
            }
        }
        
        return count;
    }
}