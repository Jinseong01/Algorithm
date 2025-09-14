import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}