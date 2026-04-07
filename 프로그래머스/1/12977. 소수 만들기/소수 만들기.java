import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // 1. 최대 합까지 소수 판별 배열
        int max = 3000;
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        
        // isPrime[0] = false;
        // isPrime[1] = false;

        for (int i=2; i*i<=max; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=max; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2. 3개 조합 (i < j < k)
        int n = nums.length;

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime[sum]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}