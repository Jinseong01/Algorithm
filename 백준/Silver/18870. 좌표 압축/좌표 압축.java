import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] copy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            copy[i]= origin[i];
        }

        // 크기대로 정렬  (ex. -10 -9 2 4 4)
        Arrays.sort(copy);

        // 크기 비교해서 카운트 & 중복 판단 필요
        // -> Map에 중복 고려하여 idx를 같이 넣음으로써, 크기 비교해서 카운트까지 해결
        // (idx가 자신보다 작은 숫자 개수)
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i : copy) {
            if(!map.containsKey(i)) {
                map.put(i, idx++);
            }
        }

        // 결과 출력 시에는 origin으로 중복되는 요소 반복 출력
        StringBuilder sb = new StringBuilder();
        for (int i : origin) {
            sb.append(map.get(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}