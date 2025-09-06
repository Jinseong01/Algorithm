class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬 곱 (arr1의 행길이 & arr2의 열길이로 구성된 결과 나옴)
        int [][] res = new int[arr1.length][arr2[0].length];
        
        // 2. arr1은 행 기준 arr2은 열 기준 순회하되, 각각을 +1씩 진행
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2[0].length; j++) {
                for (int k=0; k<arr1[0].length; k++) {
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return res;
    }
}