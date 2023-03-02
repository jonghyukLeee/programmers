package lv12;

import java.util.*;

public class Q12941 {
    public static void main(String[] args) {
        int [] A = {1,2};
        int [] B = {3,4};
        System.out.println(solution(A,B));
    }
    static int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        Queue<Integer> lowQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < size; i++) {
            lowQ.add(A[i]);
            maxQ.add(B[i]);
        }

        while(!lowQ.isEmpty()) {
            answer += (lowQ.poll() * maxQ.poll());
        }

        return answer;
    }
}
