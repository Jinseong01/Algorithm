import java.util.*;

class Solution {
    public String[] solution(String[] files) {        
        // 1차 정렬 - HEAD 사전순 정렬 (대소문자 구분 X)
        // 2차 정렬 - NUMBER 숫자 정렬 (숫자 앞의 0은 무시)
        
        Arrays.sort(files, (s1, s2) -> {
            // s1 파싱
            String[] parts1 = parseFile(s1);
            String head1 = parts1[0];
            int number1 = Integer.parseInt(parts1[1]);
            
            // s2 파싱
            String[] parts2 = parseFile(s2);
            String head2 = parts2[0];
            int number2 = Integer.parseInt(parts2[1]);
            
            // 1차 정렬 - 대소문자 구분 없이 HEAD 사전순 정렬 (오름차순)
            int headCompare = head1.toLowerCase().compareTo(head2.toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }
            
            // 2차 정렬 - NUMBER 정렬 (오름차순)
            return Integer.compare(number1, number2);
        });

        return files;
    }
    
    // 파일명을 [HEAD, NUMBER] 배열로 분리
    private static String[] parseFile(String filename) {
        int i = 0;
        
        // HEAD(숫자가 아닌 문자) 찾기
        while (i<filename.length() && !Character.isDigit(filename.charAt(i))) {
            i++;
        }
        String head = filename.substring(0, i);
        
        // NUMBER 찾기 (연속된 숫자 & 최대 5자리)
        int start = i;
        while (i<filename.length()
               && Character.isDigit(filename.charAt(i))
               && ((i-start)<5)) {
            i++;
        }
        String number = filename.substring(start, i);
        
        return new String[]{head, number};
    }
}