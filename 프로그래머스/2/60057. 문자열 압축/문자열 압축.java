class Solution {
    public int solution(String s) {

        // 최소 압축 길이
        int answer = s.length();

        // 1. 자를 단위를 1 ~ 문자열 절반까지 시도
        for (int size=1; size<=s.length(); size++) {
            // 2. 현재 단위로 압축한 문자열 길이
            int compressedLength = 0;

            // 3. 현재 단위의 시작 조각
            String prev = s.substring(0, size);
            int count = 1;

            // 4. size 단위로 남은 문자열 탐색
            for (int i=size; i<s.length(); i+=size) {

                // 현재 조각 추출
                String current;

                // 현재 조각 범위가 문자열 길이를 넘으면 끝까지 자르기
                if (i+size > s.length()) {
                    current = s.substring(i);
                }
                else {
                    current = s.substring(i, i+size);
                }

                // 이전 조각과 같으면
                if (current.equals(prev)) {
                    count++;
                } 
                // 이전 조각과 다르면
                else {
                    // 반복 횟수 길이 추가
                    if (count>1) {
                        compressedLength += String.valueOf(count).length();
                    }
                    // 이전 문자열 길이 추가
                    compressedLength += prev.length();

                    // 갱신
                    prev = current;
                    count = 1;
                }
            }

            // 5. 마지막 조각 처리
            if (count>1) {
                compressedLength += String.valueOf(count).length();
            }
            compressedLength += prev.length();

            // 6. 최소 길이 갱신
            answer = Math.min(answer, compressedLength);
        }

        return answer;
    }
}