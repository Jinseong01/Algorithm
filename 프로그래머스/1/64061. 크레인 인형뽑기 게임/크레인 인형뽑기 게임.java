import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 1. 장바구니
        Stack<Integer> stack = new Stack<>();
        
        // 2. moves배열은 board배열의 (열idx+1) 값임
        int count = 0;
        for (int i : moves) {
            int doll = chooseDoll(board, i);
            
            if(doll!=0) {
                // 최근 장바구니에 담은거랑 중복
                if (!stack.isEmpty() && stack.peek()==doll) {
                    stack.pop();
                    count += 2;
                }
                // 장바구니에 담기
                else {
                    stack.push(doll);
                }
            }    
        }
        
        return count;
    }
    
    // board에서 해당하는 값 선택
    private int chooseDoll(int[][] board, int idx) {
        for(int i=0; i<board.length; i++) {
            if(board[i][idx-1] != 0) {
                int tmp = board[i][idx-1];
                board[i][idx-1] = 0;
                return tmp;
            }
        }
        return 0;
    }
}