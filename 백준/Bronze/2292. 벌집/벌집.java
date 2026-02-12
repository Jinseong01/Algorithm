import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 가운데 1 (1개)
        // layer1 -> 2~7 (6개)
        // layer2 -> 8~19 (12개)
        // layer3 -> 20~37 (18개)

        // N이 속하는 layerA 구하기 -> A+1

        int layer = 0;
        int range = 1;

        while (N > range) {
            layer++;
            range = range + (6 * layer);
        }

        System.out.println(layer+1);
    }
}