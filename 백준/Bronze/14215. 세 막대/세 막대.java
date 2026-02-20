import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = {a, b, c};
        Arrays.sort(arr);

        a = arr[0];
        b = arr[1];
        c = arr[2];

        if (c < a + b) {
            System.out.println(a+b+c);
        }
        else {
            System.out.println(a + b + (a + b - 1));
        }
    }
}