import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String result = "";
        
        for(int i=0; i<a.length(); i++) {
            char s = a.charAt(i);
            
            if(Character.isUpperCase(s)) {
                result += Character.toLowerCase(s);
            }
            else {
                result += Character.toUpperCase(s);
            }
        }
        
        System.out.print(result);
    }
}