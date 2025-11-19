class Solution {
    
    private static int[] apeach;
    private static int[] ryan;
    private static int[] answer;
    private static int maxDiff;

    public int[] solution(int n, int[] apeach) {
        this.apeach = apeach;
        ryan = new int[11];
        maxDiff = 0;
        
        dfs(0, n);
        
        return (answer!=null) ? answer : new int[]{-1};
    }

    private void dfs(int idx, int arrowsLeft) {
        // 종료조건 (0점까지 다 봤거나 전체 화살 소모)
        if (idx==11 || arrowsLeft==0) {
            // 0점까지 다 봤는데 화살이 남은 경우
            if (arrowsLeft > 0) {
                ryan[10] += arrowsLeft;
            }
            
            // 점수 차이 계산
            int diff = calcDiff(ryan, apeach);
            
            // 점수 차이 업데이트
            if (diff>0 && (diff>maxDiff || (diff==maxDiff && lowScore(ryan, answer)))) {
                maxDiff = diff;
                answer = ryan.clone();
            }
            
            // 0점에 넣은 화살 원상복구
            if (arrowsLeft>0) {
                ryan[10] -= arrowsLeft;
            }
            
            return;
        }

        // 이번 점수를 얻는다
        if (arrowsLeft>apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(idx+1, arrowsLeft-ryan[idx]);
            ryan[idx] = 0; // 복원
        }

        // 이번 점수를 포기한다
        dfs(idx+1, arrowsLeft);
    }

    private int calcDiff(int[] r, int[] a) {
        int rScore=0, aScore=0;
        
        for (int i=0; i<11; i++) {
            int point = 10-i;
            
            // 둘 다 X
            if (r[i]==0 && a[i]==0) continue;
            
            // 라이언 승리
            if (r[i]>a[i]) {
                rScore += point;
            }
            // 어피치 승리
            else {
                aScore += point;
            }
        }
        
        return rScore-aScore;
    }
    
    private boolean lowScore(int[] r, int[] b) {
        // 처음 비교 시
        if (b==null) {
            return true;
        }

        for (int i=10; i>=0; i--) {
            if (r[i]!=b[i]) {
                return r[i]>b[i];
            }
        }
        
        return false;
    }
}