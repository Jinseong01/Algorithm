import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 빈칸0 뱀1 사과2
        int[][] arr = new int[N][N];

        // 뱀
        arr[0][0] = 1;

        // 사과
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y-1][x-1] = 2;
        }

        // 방향 전환
        int L = Integer.parseInt(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            map.put(key, st.nextToken());
        }


        // 2. 이동
        int dir = 1;  // 상0 우1 하2 좌3
        int time = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.addLast(new int[]{0, 0});

        while (true) {
            time++;

            // 1. 머리 다음 칸
            int[] head = snake.peekLast();
            int ny = head[0], nx = head[1];
            if (dir == 0) ny--;      // 상
            else if (dir == 1) nx++; // 우
            else if (dir == 2) ny++; // 하
            else if (dir == 3) nx--; // 좌


            // 2. 벽 또는 자기 몸 충돌
            if (ny < 0 || ny >= N || nx < 0 || nx >= N || arr[ny][nx] == 1) {
                System.out.println(time);
                break;
            }


            // 3. 사과 확인
            // 사과있는 경우 - 머리 이동&꼬리 유지
            if (arr[ny][nx] == 2) {
                arr[ny][nx] = 1;
                snake.addLast(new int[]{ny, nx});
            }
            // 사과 없는 경우 - 머리 이동&꼬리 이동
            else {
                arr[ny][nx] = 1;
                snake.addLast(new int[]{ny, nx});

                int[] tail = snake.pollFirst();
                arr[tail[0]][tail[1]] = 0;
            }

            // 4. 방향 전환
            if (map.containsKey(time)) {
                String turn = map.get(time);
                if (turn.equals("L")) dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;
            }
        }

    }
}