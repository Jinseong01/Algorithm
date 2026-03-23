import java.io.*;
import java.util.*;

public class Main {

    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }

            int N = Integer.parseInt(line);
            int length = (int) Math.pow(3, N);
            result = new char[length];

            Arrays.fill(result, '-');

            cantor(0, length-1);

            sb.append(String.valueOf(result)).append("\n");
        }

        System.out.println(sb);
    }

    static void cantor(int left, int right) {
        if (left == right) {
            return;
        }

        int size = (right-left+1) / 3;
        int midStart = left + size;
        int midEnd = midStart + size - 1;

        cantor(left, midStart-1);

        for (int i=midStart; i<=midEnd; i++) {
            result[i] = ' ';
        }

        cantor(midEnd+1, right);
    }
}