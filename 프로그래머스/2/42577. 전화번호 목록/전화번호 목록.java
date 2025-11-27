import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
       HashSet<String> set = new HashSet<>();

        // 모든 번호 저장
        for (String number : phone_book) {
            set.add(number);
        }

        // 각 번호의 접두사 검사
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}