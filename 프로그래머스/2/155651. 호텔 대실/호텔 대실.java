import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        // 1. 시간을 분 단위로 변환 (종료시간은 청소 10분 포함)
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinute(book_time[i][0]);
            times[i][1] = toMinute(book_time[i][1]) + 10;
        }

        // 2. 입실시간 기준 오름차순 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 3. 우선순위 큐 (퇴실시간 저장)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            // 가장 빠른 퇴실시간 <= 현재 입실시간 (= 방 추가X)
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            // 현재 퇴실시간을 큐에 추가 (= 방 추가)
            pq.offer(end);
        }

        // 4. 객실 수
        return pq.size();
    }

    // HH:MM -> 분으로 변환
    private int toMinute(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
}