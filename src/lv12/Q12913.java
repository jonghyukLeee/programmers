package lv12;

import java.util.*;

class LandPoint {
    int idx, point;

    public LandPoint(int idx, int point) {
        this.idx = idx;
        this.point = point;
    }
}
public class Q12913 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land));
    }
    static int solution(int[][] land) {
        int answer = 0;
        int n = land.length;

        if (n < 2) {

            for (int i = 0; i < 4; i++) answer = Math.max(answer, land[0][i]);
            return answer;
        }

        List<LandPoint> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                list.add(new LandPoint(j, land[i - 1][j]));
            }

            list.sort(new Comparator<LandPoint>() {
                @Override
                public int compare(LandPoint o1, LandPoint o2) {
                    return o2.point - o1.point;
                }
            });

            for (int j = 0; j < 4; j++) {
                int point = list.get(0).idx != j ? list.get(0).point : list.get(1).point;
                land[i][j] += point;
            }
            list.clear();
        }

        for (int i = 0; i < 4; i++) answer = Math.max(answer, land[n - 1][i]);

        return answer;
    }
}
