class Solution {
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        return (long) (min+max) * (max-min+1) / 2;
    }
}

// class Solution {
//     public long solution(int a, int b) {
//         int min = Math.min(a, b);
//         int max = Math.max(a, b);
        
//         return (long) (min+max) * (max-min+1) / 2;
//     }
// }