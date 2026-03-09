import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B
        // 두 집합의 대칭 차집합의 원소의 개수
        // 대칭 차집합 : (A-B)와 (B-A)의 합집합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < sizeB; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (int i : aSet) {
            if (!bSet.contains(i)) {
                result++;
            }
        }

        for (int i : bSet) {
            if (!aSet.contains(i)) {
                result++;
            }
        }

        System.out.println(result);
    }
}