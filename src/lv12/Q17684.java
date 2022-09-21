package lv12;

import java.util.*;

public class Q17684 {
    static int[] solution(String msg) {
        int[] answer;
        int msgLen = msg.length();

        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < msgLen; i++) {
            q.add(msg.charAt(i)+"");
        }

        Map<String, Integer> dic = new HashMap<>();

        for (int i = 65; i <= 90; i++) {
            dic.put((char)i+"", i - 64);
        }

        List<Integer> result = new ArrayList<>();
        String curString = "";
        while(!q.isEmpty()) {

            while (!q.isEmpty() && dic.containsKey(curString + q.peek())) {
                curString = curString.concat(q.poll());
            }
            // 색인 번호
            result.add(dic.get(curString));
            // 아직 입력이 남았으면,
            if (!q.isEmpty()) {
                dic.put(curString.concat(q.peek()), dic.size() + 1);
            }
            // 초기화
            curString = "";
        }

        int resultSize = result.size();
        answer = new int[resultSize];

        for (int i = 0; i < resultSize; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
