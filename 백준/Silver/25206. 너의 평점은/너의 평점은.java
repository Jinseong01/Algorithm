import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Double totalScore = 0.0;
        Double totalCredit = 0.0;
        Map<String, Double> gradeScore = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+", 3.5,
                "B0", 3.0,
                "C+", 2.5,
                "C0", 2.0,
                "D+", 1.5,
                "D0", 1.0,
                "F", 0.0
        );

        for(int i=0; i<20; i++) {
            String[] input = br.readLine().split(" ");

            String subject= input[0]; //과목명
            Double credit = Double.parseDouble(input[1]); //학점
            String grade = input[2]; //등급

            if(!grade.equals("P")) {
                totalScore += credit * gradeScore.get(grade);
                totalCredit += credit;
            }
        }

        bw.write(String.format("%.4f\n", totalScore / totalCredit));
        bw.flush();
        bw.close();
    }
}