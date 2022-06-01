package lv12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q42586 {
    public static void main(String[] args) {
        int [] a = {20, 99, 93, 30, 55, 10};
        int [] b = {5, 10, 1, 1, 30, 5};
        for(int i : solution(a,b)) System.out.println(i);
    }
    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> answerAl = new ArrayList<>();
        int pSize = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < pSize; i++) {
            int speed = speeds[i];
            int diff = 100 - progresses[i]; // 남은 작업량

            int day = (diff / speed);
            // 나누어 떨어지지 않으면 +1
            if ((diff % speed) != 0) day++;

            q.add(day);
        }

        while(!q.isEmpty()) {
            int maxValue = q.poll();
            int cnt = 1;
             while (!q.isEmpty()) {
                 if(q.peek() <= maxValue) {
                     cnt++;
                     q.poll();
                 }
                 else break;
             }
             answerAl.add(cnt);
        }
        int alSize = answerAl.size();
        answer = new int[alSize];
        for (int i = 0; i < alSize; i++) answer[i] = answerAl.get(i);

        return answer;
    }
}
