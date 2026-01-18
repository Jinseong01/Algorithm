class Solution {
    public int solution(int[] money) {
        // 원형 -> 선형 으로 생각
        // 첫집 선택 O -> 원형이기 때문에 마지막집 선택 무조건 불가
        // 첫집 선택 X -> 원형이기 때문에 마지막집 선택 가능 (무조건 X)
        
        int n = money.length;
        
        
        // dp1[i]는 첫번째 집을 털며 각 집을 순차적으로 진행할 때, i번째 집까지의 최대 누적 금액
        int[] dp1 = new int[n];
        dp1[0] = money[0]; // 첫번째 선택
        dp1[1] = money[0]; // 두번째 선택 X (But, 첫번째 집으로 인한 누적)
        
        
        // dp2[i]는 첫번째 집을 털지 않으며 각 집을 순차적으로 진행할 때, i번째 집까지의 최대 누적 금액
        int[] dp2 = new int[n];
        dp2[0] = 0; // 첫번째 선택 X
        dp2[1] = money[1]; // 두번째 선택
        
        
        for (int i=2; i<n; i++) {
            // i번째 집을 턴다 vs i번째 집을 털지 않는다
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }

        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}