import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String sb = "";
        Scanner scanner = new Scanner(System.in);

        sb = scanner.nextLine();

        for(int i=0; i<sb.length()/2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) {
                System.out.print(0);
                return;
            }
        }

        System.out.print(1);
    }
}