import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}


//public class Main {
//
//    static String s;
//    static Set<String> set;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        s = br.readLine();
//        set = new HashSet<>();
//        for(int i = 0; i < s.length(); i++) {
//            dfs(i, "");
//        }
//
//        System.out.println(set.size());
//    }
//
//    private static void dfs(int idx, String current) {
//        if (idx == s.length()) {
//            return;
//        }
//
//        current += s.charAt(idx);
//        set.add(current);
//
//        dfs(idx + 1, current);
//    }
//}