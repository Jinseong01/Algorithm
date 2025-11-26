import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 6@10, 10@6 -> 6 / 10
        // 10@2, 2@10 -> 2 / 10
        String[] list = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순
        Arrays.sort(list, (a, b) -> (b+a).compareTo(a+b));
        
        if(list[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}