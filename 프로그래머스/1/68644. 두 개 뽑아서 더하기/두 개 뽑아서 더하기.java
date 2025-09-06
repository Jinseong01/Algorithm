import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 1. Set 초기화
        Set<Integer> set = new HashSet<>();

        // 2. 가능한 합들 구하기 (중복 X)
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 3. 오름차순 int 배열 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}