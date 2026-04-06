import java.util.*;

class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n+1];
        
        // 2~n을 소수라고 가정
        Arrays.fill(isPrime, true);

        // i가 소수라면 i의 배수는 전부 소수가 X
        // (n 이하의 모든 합성수는 루트n 이하의 소인수를 반드시 가지므로, 루트n까지만 확인)
        for (int i=2; i*i<=n; i++) {
            if (isPrime[i]) {
                // i*i 미만의 배수는 앞선 단계에서 지워짐
                for (int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2~n 중 소수 카운트
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
        
//         for(int i=2; i<=n; i++) {
//             if(isPrime(i)) answer++;
//         }
        
//         return answer;
//     }
    
//     private boolean isPrime(int num) {
//         if (num <= 1) return false;
        
//         if (num == 2) return true;
        
//         if (num%2 == 0) return false;

//         for (int i=3; i*i<=num; i+=2) {
//             if (num%i == 0) return false;
//         }

//         return true;
//     }
// }