import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        // 1 - ax + by = c
        // 2 - dx + ey = f
        // 연립방정식 정리하면
        // x = (ce-bf)/(ae-bd)
        // y = (cd-af)/(bd-ae)

        int x = (c*e-b*f)/(a*e-b*d);
        int y = (c*d-a*f)/(b*d-a*e);
        bw.write(x + " " + y + "\n");
        bw.flush();
        bw.close();
    }
}