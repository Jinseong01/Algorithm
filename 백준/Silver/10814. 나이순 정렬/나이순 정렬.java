import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(members, (a, b) -> a.age - b.age);

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }

    private static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        String[][] members = new String[N][2];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            members[i][0] = st.nextToken();
//            members[i][1] = st.nextToken();
//        }
//
//        Arrays.sort(members, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
//
//        StringBuilder sb = new StringBuilder();
//        for (String[] member : members) {
//            sb.append(member[0]).append(" ").append(member[1]).append("\n");
//        }
//
//        System.out.println(sb);
//    }
//}