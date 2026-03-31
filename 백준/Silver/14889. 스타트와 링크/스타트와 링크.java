import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] S;

    static boolean[] isStartTeam;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // N명을 N/2씩 두 팀으로 나눌 때, 두 팀의 능력치 차이의 최솟값 구하기
        // 팀 능력치 = 같은 팀의 모든 (i, j) 쌍에 대해 S[i][j] + S[j][i] 합

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        isStartTeam = new boolean[N + 1];

        S = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 탐색
        dfs(1, 0);

        // 3. 출력
        System.out.println(minDiff);
    }

    private static void dfs(int start, int count) {
        // 스타트팀 인원이 N/2명이면 종료
        if (count == N/2) {
            minDiff = Math.min(minDiff, calcDiff());
            return;
        }

        // 스타트팀 조합 구성
        for (int i = start; i <= N; i++) {
            // 스타트팀으로 i번 사람 추가
            isStartTeam[i] = true;

            // 다음 사람 탐색
            dfs(i+1, count+1);

            // 스타트팀에서 i번 사람 제거 (백트래킹)
            isStartTeam[i] = false;
        }
    }

    private static int calcDiff() {
        int startScore = 0, linkScore = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                // 스타트팀 능력치
                if (isStartTeam[i] && isStartTeam[j]) {
                    startScore += S[i][j];
                }

                // 링크팀 능력치
                if (!isStartTeam[i] && !isStartTeam[j]) {
                    linkScore += S[i][j];
                }
            }
        }

        return Math.abs(startScore - linkScore);
    }
}