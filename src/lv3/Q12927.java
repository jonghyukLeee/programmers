package lv3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q12927 {
    public static void main(String[] args) {

    }
    static long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;
        for (int work : works) {
            pq.add(work);
            total += work;
        }

        if (total <= n) return 0;

        while (n-- > 0) {
            pq.add(pq.poll() - 1);
        }

        for (int num : pq) {
            answer += Math.pow(num, 2);
        }
        return answer;
    }
}
