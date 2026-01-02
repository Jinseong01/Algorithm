import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 1. 끝점 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = 0;
        int lastCamera = Integer.MIN_VALUE;  // 마지막 카메라 위치
        
        // 2. 각 구간을 순회하면서 카메라 설치
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            // 현재 카메라로 이 구간을 커버할 수 없으면
            if (lastCamera < start) {
                camera++;
                lastCamera = end;
            }
        }
        
        return camera;
    }
}