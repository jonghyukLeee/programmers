package lv12;

import java.util.*;

class Tangerine {
    int size, count;

    public Tangerine(int size, int count) {
        this.size = size;
        this.count = count;
    }
}
public class Q138476 {

    static  int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int t: tangerine) hm.put(t, hm.getOrDefault(t, 0) + 1);

        Queue<Tangerine> q = new PriorityQueue<>(new Comparator<Tangerine>() {
            @Override
            public int compare(Tangerine t1, Tangerine t2) {
                return t2.count - t1.count;
            }
        });

        for (int key: hm.keySet()) {
            q.add(new Tangerine(key, hm.get(key)));
        }
        int pick = k;
        while (pick > 0) {
            answer++;
            Tangerine cur = q.poll();

            pick -= cur.count;
        }
        return answer;
    }
}
