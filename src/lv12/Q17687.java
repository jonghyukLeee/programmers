package lv12;

import java.util.ArrayList;
import java.util.List;

public class Q17687 {
    static int MAX_LEN;
    public static void main(String[] args) {

    }
    static String solution(int n, int t, int m, int p) {
        String answer = "";
        MAX_LEN = t * m;

        List<Character> map = new ArrayList<>();
        int start = 0;
        while (map.size() < MAX_LEN) {
            String next = Integer.toString(start, n);
            int nextSize = next.length();
            for (int i = 0; i < nextSize; i++) {
                map.add(next.charAt(i));
            }
            start++;
        }

        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            answer += map.get(idx);
            idx += m;
        }
        return answer.toUpperCase();
    }
}
