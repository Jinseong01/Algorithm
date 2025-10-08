import java.util.*;

class Solution {
    
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 최소 비용 그래프를 구축하기        
        // 1. 최소 비용 다리 선택
        // 2. 연결되지 않은 노드와 연결하기 위한 최소 비용의 다리 선택
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int cost = 0;
        for (int[] bridge : costs) {
            // 연결되지 않은 다리인지 체크 & 선택
            if(find(bridge[0]) != find(bridge[1])) {
                union(bridge[0], bridge[1]);
                cost += bridge[2];
            }
        }
        
        return cost;
    }
    
    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}