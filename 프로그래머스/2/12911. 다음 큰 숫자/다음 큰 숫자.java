class Solution {
    public int solution(int n) {
        int target = countOnes(n);
        int next = n + 1;

        while (true) {
            if (countOnes(next) == target) {
                return next;
            }
            next++;
        }
    }

    // n의 이진수에서 1의 개수 세기
    private int countOnes(int n) {
        int count = 0;

        while (n > 0) {
            if (n%2 == 1) {
                count++;
            }
            
            n /= 2;
        }

        return count;
    }
}
