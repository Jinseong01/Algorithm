import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU로 cacheSize개 만큼의 데이터를 기록해야 함 (※ LRU를 위해 순서까지 알아야 함)
        // -> LinkedHashSet
        
        // 1. 조기종료
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        // 2. 실행시간 계산
        int time = 0;
        Set<String> cache = new LinkedHashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();

            // 캐시에 있다면
            if (cache.contains(city)) {
                time += 1;
                cache.remove(city); // 순서 갱신을 위해 해당 도시를 임시 삭제
            }
            // 캐시에 없다면
            else {
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(cache.iterator().next()); // 가장 앞에꺼(=오래된거)를 삭제
                }
            }

            cache.add(city); // 캐시에 해당 도시 추가
        }

        return time;
    }
}