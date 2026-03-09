import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> hear = new HashSet<>(N);
        for(int i = 0; i < N; i++){
            hear.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String see = br.readLine();
            if(hear.contains(see)){
                result.add(see);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(String name : result){
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}