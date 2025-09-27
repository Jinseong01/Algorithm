import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 1. orders의 각 문자열을 course의 각 길이에 맞게 다양한 조합으로 자름 (+map에서 개수를 관리)
        // 2. course의 각 길이별로 map에서 Top1을 선별


        // 1번
        Map<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            // order 정렬
            char[] sorted = order.toCharArray();
            Arrays.sort(sorted);

            for (int i : course) {
                // 메뉴조합 s에서 i개만큼의 다양한 조합을 선택
                combie(sorted, 0, i, new StringBuilder(), map);
            }
        }


        // 2번
        List<String> result = new ArrayList<>();
        for (int len : course) {

            // 최대 주문횟수 구하기 (최소 2이상)
            int max = 0;
            for (String menu : map.keySet()) {
                int count = map.get(menu);
                if (menu.length() == len && count >= 2) {
                    if (count > max) {
                        max = count;
                    }
                }
            }

            // 최대 주문횟수와 같은 조합만 추가
            for (String menu : map.keySet()) {
                int count = map.get(menu);
                if (menu.length() == len && count >= 2 && count == max) {
                    result.add(menu);
                }
            }
        }

        // 3. 결과
        Collections.sort(result);
        return result.toArray(String[]::new);
    }

    
    
    private void combie(char[] chars, int start, int targetLen, StringBuilder comb, Map<String, Integer> map) {
        if (comb.length() == targetLen) {
            String key = comb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            comb.append(chars[i]);
            combie(chars, i + 1, targetLen, comb, map);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}