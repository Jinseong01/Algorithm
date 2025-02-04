import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        for(int i=1; i<=count; i++) {

            // 공백 출력 (4번 -> 3번 -> 2번 -> 1번 -> 0번)
            for(int j=1; j<=count-i; j++) {
                System.out.print(" ");
            }

            // * 출력 (1번 -> 3번 -> 5번 -> 7번 -> 9번)
            for (int k=1; k <= 2*i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1; i<=count-1; i++) {

            // 공백 출력 (1번 -> 2번 -> 3번 -> 4번)
            for(int j=1; j<=i; j++) {
                System.out.print(" ");
            }

            // * 출력 (7번 -> 5번 -> 3번 -> 1번)
            for (int k=1; k <= (2*count-1)-2*i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}