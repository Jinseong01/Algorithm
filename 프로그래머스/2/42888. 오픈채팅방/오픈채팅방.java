import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // Enter -> uid + "들어옴"
        // Leave -> uid + "나감"
        // Change -> uid별 닉네임 관리
        
        // 최종 uid별 닉네임에 맞게 입/퇴장 문구 출력
        
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> member = new HashMap<>();
        
        for(String s : record) {
            String[] tokens = s.split(" ");
            String command = tokens[0];
            String uid = tokens[1];
            
            if(command.equals("Enter")) {
                member.put(uid, tokens[2]);
                list.add(uid + ":Enter");
            }
            else if(command.equals("Leave")) {
                list.add(uid + ":Leave");
            }
            else if(command.equals("Change")) {
                member.put(uid, tokens[2]);
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(String log : list) {
            String[] parts = log.split(":");
            String uid = parts[0];
            String nickname = member.get(uid);
            String action = parts[1];

            if(action.equals("Enter")) {
                result.add(nickname + "님이 들어왔습니다.");
            }
            else {
                result.add(nickname + "님이 나갔습니다.");
            }
        }
        
        return result.stream().toArray(String[]::new);
    }
}