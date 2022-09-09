package lv3;

import java.util.Arrays;

public class Q12938 {
    public static void main(String[] args) {
        for (int i : solution(2, 1)) {
            System.out.println(i);
        }
    }
    static int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int [] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (s / n);
        }

        for (int i = 0; i < (s % n); i++) {
            answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
