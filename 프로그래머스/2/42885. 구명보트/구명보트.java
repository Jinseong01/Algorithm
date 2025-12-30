import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 보트 태우기 (최대 2명)
        int count = 0;
        
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            // 2명이 같이 타는 경우
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            // 무거운 사람 혼자
            else {
                right--;
            }
            count++;
        }
        
        return count;
    }
}