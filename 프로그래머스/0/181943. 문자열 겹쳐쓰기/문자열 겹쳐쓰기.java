class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] c = my_string.toCharArray();
        
        for(int i=s; i<s+overwrite_string.length(); i++) {
            c[i] = overwrite_string.charAt(i-s);
        }
        
        return new String(c);
        
        // return my_string.substring(0, s)
        //         + overwrite_string
        //         + my_string.substring(s + overwrite_string.length());
    }
}