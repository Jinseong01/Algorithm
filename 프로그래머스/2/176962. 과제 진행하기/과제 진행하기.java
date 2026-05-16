import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();
        
        // 시작시간 기준 정렬
        Arrays.sort(plans, (a,b) -> toMin(a[1]) - toMin(b[1]));

        for (int i=0; i<plans.length-1; i++) {
            String name = plans[i][0];
            int start = toMin(plans[i][1]);
            int time = Integer.parseInt(plans[i][2]);
            
            int nextStart = toMin(plans[i+1][1]);

            // 현재 과제 ~ 다음 과제 사이 시간
            int betweenTime = nextStart - start;
            
            // 시간 충분 => 현재 과제 끝내고, 남는 시간은 stack 처리
            if(betweenTime>=time) {
                answer.add(name);
                
                int remain = betweenTime - time;
                
                while (remain>0 && !stack.isEmpty()) {
                    String[] paused = stack.pop();
                    String pausedName = paused[0];
                    int pausedTime = Integer.parseInt(paused[1]);

                    // 남은시간으로 중단된 과제 완료 가능 
                    if (remain>=pausedTime) {
                        answer.add(pausedName);
                        remain -= pausedTime;
                    }
                    // 남는시간으로 중단된 과제 완료 불가능
                    else {
                        stack.push(new String[]{pausedName, String.valueOf(pausedTime-remain)});
                        remain = 0;
                    }
                }
                
            }
            
            // 시간 부족 => 현재 과제 남은 시간을 줄이고 stack에 넣음
            else {
                stack.push(new String[]{name, String.valueOf(time-betweenTime)});

            }
        }
        
        // 마지막 과제
        answer.add(plans[plans.length-1][0]);
        
        // 중단된 과제
        while(!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        return answer.toArray(String[]::new);
    }
    
    private int toMin(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}