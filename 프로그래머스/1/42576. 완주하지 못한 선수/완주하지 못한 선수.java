import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // leo, leo -> leo
        // leo, leo -> leo, leo
        // 를 구분해야함.
        // 즉, completion에 해당 이름이 몇명인지를 기억하고, 해시를 이용해서 빠르게 확인
        // set으로는 불가 -> map
        
        // 1. completion 명단을 해시맵으로 확인 (동명이인 고려)
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String c : completion) {
            // key에 해당하는 값이 존재하면 값+1 / 없으면 1
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        
        // 2. participant 명단을 순서대로 확인하며, completion에 있는지 확인
        for(String p : participant) {
            // 애초에 해시맵에 없었거나 or 동명이인으로 인해서 있긴하지만 0명
            if(!hashMap.containsKey(p) || hashMap.get(p) == 0) {
                return p;
            }
            hashMap.put(p, hashMap.get(p)-1);
        }
     
        return "";
    }
}