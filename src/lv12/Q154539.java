package lv12;

import java.util.Stack;

public class Q154539 {
    public static void main(String[] args) {
    }
    static int[] solution(int[] numbers) {
        Stack<Integer> stk = new Stack<>();
        int size = numbers.length;
        int [] answer = new int[size];

        stk.push(0);
        for (int i = 1; i < size; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                answer[stk.pop()] = numbers[i];
            }

            stk.push(i);
        }

        while (!stk.isEmpty()) answer[stk.pop()] = -1;

        return answer;
    }
}
