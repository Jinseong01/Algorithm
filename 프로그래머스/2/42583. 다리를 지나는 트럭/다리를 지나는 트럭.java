import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int sum = 0;    // 다리 위 트럭 무게 총합
		int time = 0;   // 총 시간 (다리에 오르고 내리는 작업이 동시에 발생하기 때문에, 시간 카운트는 최근에 다리에 올라간 트럭 기준)

		for(int i = 0; i < truck_weights.length; i++) {
            // 순서대로 각 트럭의 무게
			int truck = truck_weights[i];

            // i번째 트럭이 다리에 올라가면 break
			while(true) {
				// 다리가 비었으면 트럭+1 & 시간+1
				if(deque.isEmpty()) { 
					deque.add(truck);
					sum += truck;
					time++;
					break;
				}
                // 다리가 꽉 참
                else if(deque.size() == bridge_length) {
                    // 가장 앞에 트럭 나감
					sum -= deque.poll();
				}
                // 다리 여유있음
                else  {
                    // 무게제한을 넘지 않는다면 트럭+1 & 시간+1
					if(sum + truck <= weight) {
						deque.add(truck);
						sum += truck;
						time++;
						break;
					}
                    // 무게제한 넘는다면 기존 트럭을 1칸 이동 & 시간+1
                    else {
						deque.add(0);
						time++;
					}
				}
			}
		}

        // 마지막 트럭이 올라가면 반복문 종료
        // -> 해당 트럭이 다리 건너는거 계산
		return time + bridge_length; 
    }
}