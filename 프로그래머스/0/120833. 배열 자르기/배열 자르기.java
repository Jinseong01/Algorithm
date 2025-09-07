class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        
        int idx=0;
        for (int i=0; i<numbers.length; i++) {
            if(num1<=i && i<=num2) {
                answer[idx++] = numbers[i];
            }
        }
        
        return answer;
    }
}