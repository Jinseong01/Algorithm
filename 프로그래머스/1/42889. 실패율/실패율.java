import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자수 정리 (스테이지 클리어한 사람 제외)
        int[] challenger = new int[N];
        for (int i : stages) {
            if (i<=N) {
                challenger[i-1]++;   
            }
        }
        
        // 2. 스테이지별 실패율
        Map<Integer, Double> failure = new HashMap<>();
        double fail = 0;
        double member = stages.length;
        for (int i=0; i<N; i++) {
            if (member == 0) {
                fail = 0;
            }
            else {
                fail = challenger[i] / member;
                member -= challenger[i];
            }
            failure.put(i+1, fail);
        }
        
        // 3. 실패율 내림차순
        List<Integer> list = new ArrayList<>(failure.keySet());
        // list.sort((a,b) -> {
        //     int tmp = failure.get(b).compareTo(failure.get(a));
        //     if (tmp == 0) {
        //         return a - b;
        //     }
        //     return tmp;
        // });
        list.sort((a,b) -> failure.get(b).compareTo(failure.get(a)));
        
        // 4. 스테이지 번호 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}