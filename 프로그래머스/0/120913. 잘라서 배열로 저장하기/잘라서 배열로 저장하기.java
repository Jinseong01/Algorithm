class Solution {
    public String[] solution(String my_str, int n) {
        // 1. 문자열 배열 초기화
        int count, length = my_str.length();
        if (length%n == 0) {
            count = length/n;
        }
        else {
            count = length/n + 1;
        }
        String[] list = new String[count];
        
        // 2. 문자열 잘라서 배열에 넣기
        for (int i=0; i<count; i++) {
            int start = i*n;
            int end = Math.min(start+n, my_str.length());
            list[i] = my_str.substring(start, end);
        }
        
        // 3. 반환
        return list;
    }
}