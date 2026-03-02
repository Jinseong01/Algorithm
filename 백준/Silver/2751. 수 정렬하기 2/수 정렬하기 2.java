import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // -1,000,000 ~ 1,000,000
        boolean[] exist = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            exist[num + 1000000] = true;  // 음수 고려
        }

        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.print(sb);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(arr[i]).append("\n");
//        }
//        System.out.println(sb);
//    }
//}