import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "";
        int maxTime = 0;
        
        m = replaceSharp(m);
        
        for(String musicinfo : musicinfos) {
            // 1. 파싱 및 정리
            String[] info = musicinfo.split(",");
            
            String start = info[0];
            String end = info[1];
            String title = info[2];
            String sheet = info[3];
            
            sheet = replaceSharp(sheet);
            
            
            // 2. 실제 재생된 악보 구하기 (반복재생, 일시정지, 그대로)
            int during = calcTime(start, end);
            String real = getRealSheet(during, sheet);;
            
            
            // 3. 실제 재생된 악보와 네오가 들은 악보 비교
            if (real.contains(m) && during > maxTime) {
                answer = title;
                maxTime = during;
            }
        }
        
        return answer.equals("")? "(None)" : answer;
    }
    
    private static String replaceSharp(String s) {
        return s.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f").replace("G#", "g")
                .replace("A#", "a").replace("B#", "b");
    }
    
    private static int calcTime(String s, String e) {
        String[] start = s.split(":");
        String[] end = e.split(":");
        
        int startH = Integer.parseInt(start[0]);
        int startM = Integer.parseInt(start[1]);
        
        int endH = Integer.parseInt(end[0]);
        int endM = Integer.parseInt(end[1]);
        
        return (endH-startH) * 60 + (endM - startM);
    }
    
    private static String getRealSheet(int during, String originSheet) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < during) {
            sb.append(originSheet);
        }
        
        return sb.substring(0, during);
    }
}