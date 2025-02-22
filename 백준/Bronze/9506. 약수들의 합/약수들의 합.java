import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }


            int[] arr = new int[n];
            int sum = 0;
            int count = 0;


            for (int i = 1; i < n; i++) {
                if ((n % i) == 0) {
                    arr[count++] = i;
                    sum += i;
                }
            }


            sb.append(n);
            if(n == sum) {
                sb.append(" = ").append(arr[0]);
                for (int i = 1; i < count; i++) {
                    sb.append(" + ").append(arr[i]);
                }
                sb.append("\n");
            }
            else {
                sb.append(" is NOT perfect.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}