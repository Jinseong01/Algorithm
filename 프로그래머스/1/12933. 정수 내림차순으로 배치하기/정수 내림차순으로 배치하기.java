import java.util.*;

class Solution {
    public long solution(long n) {
        String number = String.valueOf(n);
        char[] arr = number.toCharArray();
        
        Arrays.sort(arr);
        
        return Long.parseLong(new StringBuilder(new String(arr))
                              .reverse()
                              .toString());
    }
}