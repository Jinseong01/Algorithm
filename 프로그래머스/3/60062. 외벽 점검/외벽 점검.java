import java.util.*;

class Solution {
    private int weakLen;
    private int[] extendedWeak;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.weakLen = weak.length;
        
        // [전제] 1->10과 10->1은 동일하기 때문에 반시계방향 이동은 고려하지 않고 모두 시계방향으로 생각
        // weak 배열을 2배로 확장
        // 10->1의 경우, 숫자 비교로는 이동 칸을 고려하기 힘들기 때문에 확장한 배열로 10->13으로 생각
        this.extendedWeak = new int[weakLen * 2];
        for (int i = 0; i < weakLen; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + weakLen] = weak[i] + n;
        }
        
        // dist 내림차순 정렬
        Arrays.sort(dist); // 오름차순 정렬
        reverseArray(dist);
        
        // 친구 수를 1명부터 시도
        for (int count = 1; count <= dist.length; count++) {
            boolean[] used = new boolean[dist.length]; // 사용 여부 체크
            int[] selected = new int[count]; // 선택된 친구의 이동 거리
            
            // 순열 생성 및 검사
            if (permutation(dist, selected, used, 0)) {
                return count; // 최소 친구 수 반환
            }
        }
        
        return -1; // 모든 경우 실패
    }
    
    // 순열 생성 및 검사
    private boolean permutation(int[] dist, int[] selected, boolean[] used, int depth) {
		    // 종료조건 (순열 완성 / depth는 현재까지 선택한 친구 수)
        if (depth == selected.length) {
            // 각 시작점 별로 커버 가능한지 확인
            for (int start = 0; start < weakLen; start++) {
                if (canCover(selected, start)) { 
                    return true;
                }
            }
            return false;
        }
        
        for (int i = 0; i < dist.length; i++) {
		        // 아직 선택되지 않은 친구라면
            if (!used[i]) {
                used[i] = true;
                selected[depth] = dist[i];
                
                if (permutation(dist, selected, used, depth + 1)) {
                    return true; // 하위 재귀 성공 시 true 반환
                }
                
                used[i] = false; // 백트래킹
            }
        }
        
        return false;
    }
    
    // 특정 시작점에서 모든 취약점 커버 가능한지 확인
    private boolean canCover(int[] friends, int start) {
        int covered = 0; // 커버한 취약점 개수
        int position = extendedWeak[start]; // 친구 시작 위치 (=초기에는 취약점 위치)
        
        for (int distance : friends) {
            int reach = position + distance; // reach는 커버 가능 범위
            
            // 취약점이 남았고 reach가 남은 취약점의 위치까지 커버 가능하다면
            while (covered < weakLen && extendedWeak[start + covered] <= reach) {
                covered++;
            }
            
            // 모든 취약점 커버 성공
            if (covered >= weakLen) return true;
            
            // 다음 친구 시작 위치
            position = extendedWeak[start + covered];
        }
        
        return false;
    }
    
    // 배열 역순 정렬
    private void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}