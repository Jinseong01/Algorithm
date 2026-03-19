class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            
            // 약수 개수(=공격력) 구하기
            int count = 0;
            for (int j=1; j*j<=i; j++) {
                if (i%j == 0) {
                    count++;
                    
                    if (j*j != i) {
                        count++;
                    }
                }
            }
            
            // limit과 비교해서 최종 결정
            answer += count > limit ? power : count;
        }
        
        return answer;
    }
}