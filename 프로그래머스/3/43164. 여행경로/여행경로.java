import java.util.*;

class Solution {
    
    private static List<String> answer;
    private static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        // 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로
        // 알파벳 순 정렬 -> DFS
        
        // 초기화
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        // 도착지 알파벳 순서대로 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        // DFS
        answer.add("ICN");
        dfs("ICN", tickets);
        
        return answer.stream().toArray(String[]::new);
    }
    
    private static boolean dfs(String now, String[][] tickets) {   
        if (answer.size() == tickets.length+1) {
            return true;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                // 해당 경로가 정답이었다면
                if (dfs(tickets[i][1], tickets)) {
                    return true;
                }
                
                // 아니라면 백트래킹
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
        
        return false;
    }
}