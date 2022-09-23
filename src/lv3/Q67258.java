package lv3;

import java.util.*;

public class Q67258 {
    public static void main(String[] args) {

    }
    static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        int start = 0;
        int len = Integer.MAX_VALUE;
        int tmpStart = 1;
        for (String gem : gems) {
            hm.put(gem, hm.getOrDefault(gem, 0) + 1);

            q.add(gem);

            while (true) {
                // 중복 제거
                String oldGem = q.peek();
                // 두개 이상이면
                if (hm.get(oldGem) > 1) {
                    // 값 줄이고 목록에서 제거, start++
                    hm.put(oldGem, hm.get(oldGem) - 1);
                    q.poll();
                    tmpStart++;
                }
                else break;
            }

            // 보석 종류의 개수가 같고, 이전보다 길이가 짧을 때
            if (hm.size() == set.size() && q.size() < len) {
                start = tmpStart;
                len = q.size();
            }
        }

        return new int[]{start, start + len - 1};
    }
}
