import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int totalWeight = 0;
        int idx = 0;

        // 초기화
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }

        while(!bridge.isEmpty()) {
            // 1초마다 맨 앞 트럭 빠짐
            totalWeight -= bridge.poll(); 
            time++;

            if(idx < truck_weights.length) {
                // 무게제한 넘지 않으면 트럭을 다리에 올림
                if(totalWeight + truck_weights[idx] <= weight) {
                    bridge.add(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                }
                // 무게제한 넘으면 빈칸을 다리에 올림
                else {
                    bridge.add(0);
                }
            }
        }

        return time;
    }
}