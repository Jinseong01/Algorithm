import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] N = br.readLine().toCharArray();

        Arrays.sort(N);

        StringBuilder sb = new StringBuilder();
        for (int i = N.length - 1; i >= 0; i--) {
            sb.append(N[i]);
        }

        System.out.println(sb);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] arr = br.readLine().split("");
//
//        Arrays.sort(arr, Collections.reverseOrder());
//
//        System.out.println(String.join("", arr));
//    }
//}