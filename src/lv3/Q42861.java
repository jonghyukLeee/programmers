package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
    int n, cost;

    public Edge(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }
}

public class Q42861 {
    public static void main(String[] args) {

    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Edge>> map = new ArrayList<>();

        for (int i = 0; i < n; i++) map.add(new ArrayList<>());

        for (int [] cost: costs) {
            map.get(cost[0]).add(new Edge(cost[1], cost[2]));
            map.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }

        Edge start = new Edge(0, 0);
        Queue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(start);
        boolean [] isSelected = new boolean[n];

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (!isSelected[cur.n]) {
                isSelected[cur.n] = true;

                answer += cur.cost;

                for (Edge e: map.get(cur.n)) {
                    if (!isSelected[e.n]) q.add(e);
                }
            }
        }
        return answer;
    }
}
