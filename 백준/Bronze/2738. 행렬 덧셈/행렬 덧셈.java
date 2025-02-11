import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] a1 = new int[n][m];
        int[][] a2 = new int[n][m];

        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                a1[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                a2[i][j] = Integer.parseInt(input[j]);
                bw.write(a1[i][j] + a2[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}