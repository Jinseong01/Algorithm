import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 1열은 기본키. 값 중복 X
        // 테이블 행들을 col번째 컬럼 값 기준 오름차순 정렬 (동일하면 1번째 값 기준 내림차순 정렬)
        // S_i 정의 : i번째 행의 각 컬럼 값을 i로 나눈 나머지들의 합
        // row_begin ~ row_end에 해당하는 i의 모든 S_i끼리 XOR연산한 값을 반환
        
        // 1. 정렬
        Arrays.sort(data, (d1, d2) -> {
            if (d1[col-1] != d2[col-1]) {
                return Integer.compare(d1[col-1], d2[col-1]);
            }
            
            return Integer.compare(d2[0], d1[0]);
        });
        
        // 2.
        // row_begin ~ row_end 범위에 해당하는 행에 대해서만 S_i를 계산
        // S_i끼리 XOR 연산
        int answer = 0;
        for (int i=row_begin; i<=row_end; i++) {
            int si = 0;

            // S_i는 i번째 행의 각 컬럼 값을 i로 나눈 나머지들의 합
            for (int value : data[i-1]) {
                si += value % i;
            }

            answer ^= si;
        }
        
        return answer;
    }
}