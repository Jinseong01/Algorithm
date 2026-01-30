

class Solution {
    public long[] solution(long[] numbers) {   
        // 2개 이하의 비트만 변경하여 가장 작은 수 구하기
        
        // 짝수) ex) 2 - 010
        // 0으로 끝나므로, 그 0을 1로 바꿈 (= 그냥 기존 10진수에 +1한 결과)
        
        // 홀수) ex) 3 - 011
        // 1로 끝나므로, 가장 마지막에 존재하는 0을 1로 바꾸고, 그 다음 비트에 존재하는 1을 0으로 바꿈
        // -> 011 같은 경우, 실제로는 0을 붙이지 않으므로, 임의로 붙여주어야 함
        
        long[] answer = new long[numbers.length];
        int idx = 0;
        
        for (long number : numbers) {
            // 짝수
            if (number%2 == 0) {
                answer[idx++] = number+1;
                continue;
            }
            // 홀수
            else {
                // 비트 변환
                String x = Long.toString(number, 2);
                // 임의로 0 1개를 붙임
                x = "0" + x;
                
                // 가장 마지막에 존재하는 0의 인덱스
                int zeroIndex = x.lastIndexOf("0");
                
                // 각각의 비트를 변환 (0->1 / 1->0)
                char[] arr = x.toCharArray();
                arr[zeroIndex] = '1';
                arr[zeroIndex+1] = '0';
                
                answer[idx++] = Long.parseLong(new String(arr), 2);
            }            
        }
        
        return answer;
    }
}