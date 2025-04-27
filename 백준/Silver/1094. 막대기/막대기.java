import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int stick = 64;
        int count = 0;

        while (X > 0) {
            if (X >= stick) {
                X -= stick;
                count++;
            }
            stick /= 2;
        }
    
        System.out.println(count);
    }
}