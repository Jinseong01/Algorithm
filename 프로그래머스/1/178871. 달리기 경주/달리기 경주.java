import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        // <선수 이름, 현재 인덱스>
        Map<String, Integer> indexMap = new HashMap<>();

        // 1. 초기 인덱스 세팅
        for (int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }

        // 2. 호출 처리
        for (String name : callings) {
            int curIdx = indexMap.get(name);
            int frontIdx = curIdx - 1;

            // 앞 선수 이름
            String frontPlayer = players[frontIdx];

            // 배열에서 자리 교환
            players[frontIdx] = name;
            players[curIdx] = frontPlayer;

            // 인덱스 맵 갱신
            indexMap.put(name, frontIdx);
            indexMap.put(frontPlayer, curIdx);
        }

        return players;
    }
}