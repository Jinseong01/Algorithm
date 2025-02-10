import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            boolean[] m = new boolean[26];
            boolean groupWord = true;

            for(int j = 0; j < input.length(); j++){
                // 이전 글자와 다름 + 이미 나온 적이 있음
                if(j > 0 && input.charAt(j) != input.charAt(j-1) && m[input.charAt(j)-'a']) {
                    groupWord = false;
                    break;
                }

                // 이전 글자와 같음
                else {
                    m[input.charAt(j) - 'a'] = true;
                }
            }

            if(groupWord) {
                sum++;
            }
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}