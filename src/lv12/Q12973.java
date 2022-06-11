package lv12;

import java.util.Stack;

public class Q12973 {
    public static void main(String[] args) {
    }
    static int solution(String s)
    {
        int answer = 1;
        int len = s.length();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if(!stk.isEmpty() && stk.peek() == c) stk.pop();
            else stk.push(c);

        }

        if(!stk.isEmpty()) answer = 0;
        return answer;
    }
}
