import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {    
        // 1. 우박수열
        List<Integer> list = new ArrayList<>();
        list.add(k);  // 초항 저장
        
        while(k>1) {
            // 짝수
            if (k%2 == 0) {
                k /= 2;
            }
            // 홀수
            else {
                k = k*3 + 1;
            }
            
            list.add(k);
        }
        
    
        // 2. 정적분
        double[] answer = new double[ranges.length];
        int n = list.size()-1;
        for(int i=0; i<ranges.length; i++) {
            
            int[] range = ranges[i];
            int a = range[0];
            int b = range[1];
            
            double res = -1;
            
            // 정적분
            if (a <= n+b) {
                res = definiteIntegral(list, a, n+b);
            }
            
            answer[i] = res;
        }
        
        return answer;
    }
    
    private double definiteIntegral(List<Integer> list, int start, int end) {
        double sum = 0;
        
        for(int x=start; x<end; x++) {
            int y1 = list.get(x);
            int y2 = list.get(x+1);
            
            sum += (y1+y2) / 2.0;
        }
        
        return sum;
    }
}