package lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q42898 {
    static int [][] map;
    static int M,N;
    static int [] dx = {0,-1};
    static int [] dy = {-1,0};
    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}}));
    }
    static int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        map = new int[N][M];
        for (int [] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;

            //웅덩이 -1
            map[y][x]--;
        }

        map[0][0] = 1;
        int num = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 웅덩이가 아닐 때
                if (map[i][j] >= 0) {
                    // 좌, 상 더함
                    for (int idx = 0; idx < 2; idx++) {
                        int mx = i + dx[idx];
                        int my = j + dy[idx];
                        if (isValid(mx, my) && map[mx][my] > 0) {
                            map[i][j] += (map[mx][my] % num);
                        }
                    }
                }
            }
        }
        return (map[N - 1][M - 1] % num);
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
