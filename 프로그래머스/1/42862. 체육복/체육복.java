import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];

        // 1. 초기화
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        // 2. 잃어버린 사람
        for (int l : lost) {
            clothes[l]--;
        }

        // 3. 여벌 있는 사람
        for (int r : reserve) {
            clothes[r]++;
        }

        // 4. 빌려주기
        for (int i = 1; i <= n; i++) {
            // 잃어버린 사람
            if (clothes[i] == 0) {
                // 앞번호 확인
                if (i > 1 && clothes[i-1] == 2) {
                    clothes[i-1]--;
                    clothes[i]++;
                }
                // 뒷번호 확인
                else if (i < n && clothes[i+1] == 2) {
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }
        }

        // 5. 결과
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}