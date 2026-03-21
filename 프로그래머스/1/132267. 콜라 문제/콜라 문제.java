class Solution {
    public int solution(int a, int b, int n) {
        // 마트에 주어야 하는 병 수 a / 마트가 주는 콜라 병 수 b
        // 가지고 있는 빈 병의 개수 n
        // 받을 수 있는 콜라의 병 개수 구하기
        
        // ex) 20병(n) 가짐 & 마트는 2병(a) 주면 1병(b) 돌려줌
        // 1) 20병 중 20병 내고 10병 받음
        // 2) 10병 중 10병 내고  5병 받음
        // 3)  5병 중  4병 내고  2병 받음
        // 4)  3병 중  2병 내고  1병 받음
        // 5)  2병 중  2병 내고  1병 받음
        
        int answer = 0;
        
        while(n>=a) {
            int plus = (n/a) * b;
            
            answer += plus;
            
            n = (n%a) + plus;
        }
        
        return answer;
    }
}