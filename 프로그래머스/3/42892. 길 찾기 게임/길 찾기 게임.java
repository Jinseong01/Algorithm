import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        // 1. 트리 -1로 초기화
        // (1번 노드를 0으로 표현하기 때문에 -1이 비어있는 상태를 의미)
        int n = nodeinfo.length;
        int[][] tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i][0] = -1;
            tree[i][1] = -1;
        }
        
        
        // 2. 루트 노드의 인덱스 구하기 (y좌표가 가장 큰 노드)
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            order.add(i);
        }
        order.sort((a,b) -> nodeinfo[b][1] - nodeinfo[a][1]);
        
        int root = order.get(0);
        
        
        // 3. 트리 삽입
        for(int i=1; i<n; i++) {
            insert(tree, root, order.get(i), nodeinfo);
        }
        
        
        // 4. 전위순회 & 후위순회 결과
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preorder(tree, root, preList);
        postorder(tree, root, postList);

        int[][] answer = new int[2][];
        answer[0] = preList.stream().mapToInt(x -> x + 1).toArray();
        answer[1] = postList.stream().mapToInt(x -> x + 1).toArray();

        return answer;
    }
    
    private void insert(int[][] tree, int prevIdx, int newIdx, int[][] nodeinfo) {
        // left
        if (nodeinfo[prevIdx][0] > nodeinfo[newIdx][0]) {
            // 비었다면 바로 삽입
            if (tree[prevIdx][0] == -1) {
                tree[prevIdx][0] = newIdx;
            }
            // 이미 있다면 그 노드 기준으로 left/right 재판단
            else {
                insert(tree, tree[prevIdx][0], newIdx, nodeinfo);
            }
        }
        
        // right
        else {
            // 비었다면 바로 삽입
            if (tree[prevIdx][1] == -1) {
                tree[prevIdx][1] = newIdx;
            }
            // 이미 있다면 그 노드 기준으로 left/right 재판단
            else {
                insert(tree, tree[prevIdx][1], newIdx, nodeinfo);
            }
        }
    }
    
    private void preorder(int[][] tree, int node, List<Integer> res) {
        if (node == -1) {
            return;
        }
        
        res.add(node);
        preorder(tree, tree[node][0], res);
        preorder(tree, tree[node][1], res);
    }

    private void postorder(int[][] tree, int node, List<Integer> res) {
        if (node == -1) {
            return;
        }
        postorder(tree, tree[node][0], res);
        postorder(tree, tree[node][1], res);
        res.add(node);
    }
}