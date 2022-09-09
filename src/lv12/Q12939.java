package lv12;

import java.util.StringTokenizer;

public class Q12939 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            min = Math.min(min, next);
            max = Math.max(max, next);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
