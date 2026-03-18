class Solution {
    public boolean solution(int x) {
        // 하샤드 수 : 자릿수의 합으로 나누어지는 수
        // ex) 18 - 1+8=9, 18%9=0

        int sum = 0;
        int tmp = x;
        while(tmp>0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        return x%sum == 0;
    }
}