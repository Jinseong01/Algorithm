import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // i=1 -> n-1
        // i=2 -> n-2
        // ...
        // i=n-1 -> 1

        System.out.println((long) (n-1) * n / 2);
        System.out.println(2);
    }
}