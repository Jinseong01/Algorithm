class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int position = 1;  // 현재 확인할 아파트 위치
        int stationIdx = 0;  // 현재 확인할 기지국 인덱스
        
        // 1. 순서대로 확인
        while (position <= n) {
            
            // 2. 기지국이 있는지 & 현재 position이 기지국 범위에 속하는지 확인
            // 속한다면 -> 기지국의 우측 범위 다음 위치로 이동 & 다음 기지국으로 패스
            if (stationIdx < stations.length &&
                position >= stations[stationIdx] - w) {
                position = stations[stationIdx] + w + 1;
                stationIdx++;
            } 
            // 속하지 않는다면 -> 새 기지국 설치 & 커버 범위만큼 다음 위치로 이동
            else {
                answer++;
                position += (2 * w + 1);
            }
        }
        
        return answer;
    }
}