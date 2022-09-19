package lv12;

import java.util.*;

public class Q17680 {
    public static void main(String[] args) {

    }
    static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 0일때 예외
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        List<String> list = new ArrayList<>();

        for (String next : cities) {
            next = next.toUpperCase();
            // 캐시에 존재하면 +1하고 다시 담음
            if (list.remove(next)) {
                answer++;
                list.add(next);
            }
            else {
                answer += 5;
                //꽉찼으면 하나 삭제
                if (cacheSize == list.size()) {
                    list.remove(0);
                }
                list.add(next);
            }
        }
        return answer;
    }
}
