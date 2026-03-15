import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        for (int j : queue2) {
            q2.add(j);
            sum2 += j;
        }

        long total = sum1+sum2;
        long half = total/2;

        int count = 0;
        int limit = queue1.length*3;
        while (count <= limit) {

            if (sum1 == sum2) {
                return count;
            }

            if (sum1>half) {
                if (q1.isEmpty()) {
                    return -1;
                }

                int x = q1.poll();
                sum1 -= x;
                sum2 += x;
                q2.add(x);
            }
            else {
                if (q2.isEmpty()) {
                    return -1;
                }

                int x = q2.poll();
                sum2 -= x;
                sum1 += x;
                q1.add(x);
            }

            count++;
        }

        return -1;
    }
}