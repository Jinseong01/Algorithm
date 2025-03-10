import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }


        Arrays.sort(arr, (str1, str2) -> {
            if(str1.length() == str2.length()) {
                return str1.compareTo(str2);
                // compareTo가 객체 간의 크기를 비교
                // String일 때에는 사전순서 비교
            }
            else {
                return str1.length() - str2.length();
            }
        });

        Set<String> set = new LinkedHashSet<>(Arrays.asList(arr));
        // HashSet은 순서 보장 X

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}