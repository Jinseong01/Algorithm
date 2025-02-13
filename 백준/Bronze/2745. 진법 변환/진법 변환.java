import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

//        36진수일때, zzzzz
//        z = 35 * 36^0
//        zㅁ = 35 * 36^1
//        zㅁㅁ = 35 * 36^2
//        zㅁㅁㅁ = 35 * 36^3
//        zㅁㅁㅁㅁ = 35 * 36^4

        int num;
        int result=0;
        int idx = 0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);

            // 숫자인 경우
            if('0' <= c && c <= '9'){
                num = c - '0';
            }

            // 문자인 경우
            else {
                num = c - 'A' + 10;
            }

            result += (int) (num * Math.pow(n, idx++));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
    }
}