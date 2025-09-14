class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        // 배열 크기만큼 반복
        for (int i = 0; i < n; i++) {
            // 각 인덱스에 대해서 떨어지지 않은 시간 판단
            for (int j = i + 1; j < n; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }

        return answer;
    }
}