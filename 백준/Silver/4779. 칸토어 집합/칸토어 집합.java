import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line.trim());
            int length = (int) Math.pow(3, N);
            char[] arr = new char[length];
            for (int i = 0; i < length; i++) arr[i] = '-';
            buildCantor(arr, 0, length);
            System.out.println(new String(arr));
        }
    }

    private static void buildCantor(char[] arr, int start, int len) {
        if (len < 3) return;
        int t = len / 3;
        for (int i = start + t; i < start + 2 * t; i++) arr[i] = ' ';
        buildCantor(arr, start, t);
        buildCantor(arr, start + 2 * t, t);
    }
}
