import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 종말의 수가 커지면 6660 ~ 6666 같은 구간이 생기기 때문에 규칙으로 하기는 어렵다

        int count = 1;
        int number = 666;

        while(count != N) {
            number++;
            if(String.valueOf(number).contains("666")) {
                count++;
            }
        }
        
        bw.write(String.valueOf(number));
        bw.flush();
        bw.close();
    }
}