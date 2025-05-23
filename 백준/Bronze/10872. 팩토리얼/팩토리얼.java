import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}