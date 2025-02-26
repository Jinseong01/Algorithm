import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int answer = 0;
        
        Map<String, Integer> friendsIndex = new HashMap<>();
        for(int i=0; i<n; i++) {
            friendsIndex.put(friends[i], i);
        }
        
        int[] gGift = new int[n]; //준횟수
        int[] rGift = new int[n]; //받은횟수
        int[][] grGift = new int[n][n]; //주고받은횟수
        
        for(int i=0; i<gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            int giver = friendsIndex.get(split[0]); //준사람 인덱스
            int receiver = friendsIndex.get(split[1]); //받은사람 인덱스
            
            gGift[giver]++;
            rGift[receiver]++;
            grGift[giver][receiver]++;
        }
        
        int[] giftScore = new int[n]; //선물지수
        for(int i=0; i<n; i++) {
            giftScore[i] = gGift[i] - rGift[i];
        }
        
        int[] nextGift = new int[n]; //다음달 받을 선물 개수
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int aB = grGift[i][j]; //A가 B에게 준 횟수
                int bA = grGift[j][i]; //B가 A에게 준 횟수
                
                if(aB > bA) {
                    nextGift[i]++;
                }
                else if (aB < bA) {
                    nextGift[j]++;
                }
                else {
                    if(giftScore[i] > giftScore[j]) {
                        nextGift[i]++;
                    }
                    else if (giftScore[i] < giftScore[j]) {
                        nextGift[j]++;
                    }
                }
            }
        }
        
        Arrays.sort(nextGift);
        
        return nextGift[n-1];
    }
}