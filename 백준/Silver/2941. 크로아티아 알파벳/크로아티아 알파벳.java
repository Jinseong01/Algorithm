import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int[] n = new int[8];
        int total = 0;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(i < input.length()-1) {
                if (c == 'c') {
                    if (input.charAt(i+1) == '=') {
                        i++;
                    }
                    else if (input.charAt(i+1) == '-') {
                        i++;
                    }
                }
                else if (c == 'd') {
                    if (i<input.length()-2 && input.charAt(i+1) == 'z' && input.charAt(i+2) == '=') {
                        i+=2;
                    }
                    else if (input.charAt(i+1) == '-') {
                        i++;
                    }
                }
                else if (c == 'l') {
                    if (input.charAt(i+1) == 'j') {
                        i++;
                    }
                }
                else if (c == 'n') {
                    if (input.charAt(i+1) == 'j') {
                        i++;
                    }
                }
                else if (c == 's') {
                    if (input.charAt(i+1) == '=') {
                        i++;
                    }
                }
                else if (c == 'z') {
                    if (input.charAt(i+1) == '=') {
                        i++;
                    }
                }
            }

            total++;
        }

        // BufferedWriter에서 정수 출력하려면 String으로 변환 필요
        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }
}