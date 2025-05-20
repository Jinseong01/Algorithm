import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int X = Integer.parseInt(input.split(" ")[0]);
        int Y = Integer.parseInt(input.split(" ")[1]);

        System.out.println(Rev(Rev(X) + Rev(Y)));
    }

    private static int Rev(int n) {
        String tmp = String.valueOf(n);
        String reverse = new StringBuilder(tmp).reverse().toString();
        return Integer.parseInt(reverse);
    }
}