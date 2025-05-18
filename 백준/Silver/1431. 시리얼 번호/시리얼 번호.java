import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                // 길이 비교
                if (o1.length() != o2.length()) {
                   return o1.length() - o2.length();
                }

                // 숫자 합 비교
                int sumA = 0, sumB = 0;
                for (char c : o1.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sumA += c - '0';
                    }
                }
                for (char c : o2.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sumB += c - '0';
                    }
                }
                if (sumA != sumB) {
                    return sumA - sumB;
                }

                // 사전 순 비교
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}