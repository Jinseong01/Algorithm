import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {        
        // 판매 이익의 90%는 자신이 / 나머지는 나를 추천해준 추천인에게
        // -> 내가 참여'시킨' 사람의 판매 이익 10%는 나에게
        // (10%가 1원 미만이라면 분배 X)
        
        // enroll 판매원 명단
        // referral 다단계 추천인
        // referral[i]은 enroll[i]를 다단계에 참여시킴, 혼자 참여한 사람은 referral[i]가 '-'
        
        // seller 판매량 집계 데이터의 판매원 이름
        // amount판매량 집계 데이터의 판매 수량
        
        // 칫솔 1개의 판매 이익은 100원
        
        int[] answer = new int [enroll.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;

            while (!name.equals("-") && money > 0) {
                int give = money / 10;
                int mine = money - give;

                answer[map.get(name)] += mine;

                name = referral[map.get(name)];
                money = give;
            }
        }
        
        
        return answer;
    }
}