package lv3;

import java.util.Arrays;

public class Q12987 {
    public static void main(String[] args) {

    }
    static int solution(int[] A, int[] B) {
        int answer = 0;
        int arraySize = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        int BIdx = arraySize - 1;

        for (int i = arraySize - 1; i >= 0; i--) {
            if (A[i] < B[BIdx]) {
                BIdx--;
                answer++;
            }
        }
        return answer;
    }
}
