import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1차 정렬 - 장르 정렬 : 속한 노래가 많이 재생된 순
        // 2차 정렬 - 노래 정렬 : 많이 재생된 순 (재생횟수가 같으면 고유번호가 낮은 순 정렬)
        // 장르별 Top2 (1개면 1개만)      
        
        
        // 1. 1차 정렬 결과 구하기
        // {장르 : total 재생횟수}
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // total 재생횟수 기준으로 장르 내림차순 정렬
        ArrayList<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a,b) -> map.get(b) - map.get(a));
        
            
        // 2. 2차 정렬 결과 구하기
        // { 장르 : List<[고유번호, 재생횟수]>}
        HashMap<String, List<int[]>> map2 = new HashMap<>();
        for (int i=0; i<genres.length; i++) {  
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = plays[i];
            
            if (!map2.containsKey(genres[i])) {
                map2.put(genres[i], new ArrayList<>());
            }
            map2.get(genres[i]).add(arr);
        }
        
        
        // 재생횟수 기준으로 노래 내림차순 정렬 (동일하면 고유번호 오름차순)
        for (String genre : map2.keySet()) {
            List<int[]> songs = map2.get(genre);
        
            songs.sort((a, b) -> {
                // 재생횟수 다르면
                if (a[1] != b[1]) {
                    // 재생횟수 내림차순
                    return b[1] - a[1]; 
                }
                // 재생횟수 같으면
                else {
                    // 고유번호 오름차순
                    return a[0] - b[0];
                }
            });
        }
        
        
        
        // 3.최종 결과
        List<Integer> answer = new ArrayList<>();
        // 1차 정렬된 장르 순서대로 조회
        for (String genre : genreList) {  
            
            // 2차 정렬된 노래 순서대로 Top2 구하기
            List<int[]> songs = map2.get(genre);
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}