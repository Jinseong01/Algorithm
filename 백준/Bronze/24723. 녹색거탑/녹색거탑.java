import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 1 -> 1
        // 2 -> 2*2
        // 3 -> 2*2*2

        System.out.println((int)Math.pow(2, N));
    }
}