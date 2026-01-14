class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 1. ▲ & ▼ 이동 비용 계산
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            // 순서대로 ▲ 조작 횟수 & ▼ 조작 횟수
        }

        // 2. ◀ & ▶ 이동 비용 계산
        int move = n - 1; // 끝까지 오른쪽으로만 이동

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            // 연속된 A 구간 찾기
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // ▶ 갔다가 ◀ 돌아오는 경우
            int goRightThenBack = i * 2 + (n - next);

            // ◀ 갔다가 ▶ 돌아오는 경우
            int goBackThenRight = (n - next) * 2 + i;

            move = Math.min(move, Math.min(goRightThenBack, goBackThenRight));
        }

        return answer + move;
    }
}