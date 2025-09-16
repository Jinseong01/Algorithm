import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove_order = new Stack<Integer>();
        
        int table_size = n;
        
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            
            // 아래로 이동
            if(c=='D') {
                k+=Integer.parseInt(cmd[i].substring(2));   
            }
            
            // 위로 이동
            else if(c=='U') {
                k-=Integer.parseInt(cmd[i].substring(2));
            }
            // 현재 행 삭제 후, 바로 아래 행 선택
            else if(c=='C') {
                remove_order.add(k);
                table_size--;
                // 가장 마지막 행이었으면, 윗 행 선택
                if(k==table_size) {
                    k--;   
                }
            }
            else if(c=='Z') {
                // 복구한 행의 번호 <= 현재 행 번호
                if(remove_order.pop()<=k) {
                    k++;
                }
                table_size++;
            }
        }
        
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<table_size; i++) {
            builder.append("O");            
        }

        while(!remove_order.isEmpty()) {
            builder.insert(remove_order.pop(), "X");
        }
        

        return builder.toString();
    }
}