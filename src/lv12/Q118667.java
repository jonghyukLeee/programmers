package lv12;

import java.util.LinkedList;
import java.util.Queue;

public class Q118667 {
    public static void main(String[] args) {

    }
    static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> leftQ = new LinkedList<>();
        Queue<Integer> rightQ = new LinkedList<>();

        long sumLeft = 0, sumRight = 0;

        for (int n : queue1) {
            leftQ.add(n);
            sumLeft += n;
        }

        for (int n : queue2) {
            rightQ.add(n);
            sumRight += n;
        }

        long sum = sumLeft + sumRight;

        // 홀수면 무조건 불가능
        if (sum % 2 != 0) return -1;

        int limit = leftQ.size() * 2;

        sum /= 2; // 최종 결괏값

        int left = 0, right = 0;
        while(left <= limit && right <= limit) {
            if (sumLeft == sum) return left + right;

            if (sumLeft > sum) {
                // 왼쪽이 크면
                int tmp = leftQ.poll();
                sumLeft -= tmp;
                sumRight += tmp;
                rightQ.add(tmp);
                left++;
            }
            else {
                int tmp = rightQ.poll();
                sumRight -= tmp;
                sumLeft += tmp;
                leftQ.add(tmp);
                right++;
            }
        }
        // 반복문 벗어나면 limit
        return -1;
    }
}
