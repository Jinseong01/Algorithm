import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수
        // ex) 666, 1666, 2666, ...
        // N번째 종말의 수 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int num = 666;
        while (count != N) {
            num++;

            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num );
    }
}