package lv3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Road {
    int x, y;
    int dir;
    int price;

    public Road(int x, int y, int dir, int price) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.price = price;
    }
}

public class Q67259 {
    static int N;
    static boolean[][] map;
    static int[][][] isVisited;
    static int[] dx = {-1, 0, 1, 0}; //상 좌 하 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
//        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int [][] board = {{0,1,0},{0,0,0},{1,0,0}};
        System.out.println(solution(board));
    }

    static int solution(int[][] board) {
        N = board.length;
        map = new boolean[N][N];
        isVisited = new int[4][N][N];
        Queue<Integer> answerQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    //true 면 벽
                    map[i][j] = true;
                }
            }
        }
        map[0][0] = true;

        Queue<Road> q = new LinkedList<>();
        for (int idx = 2; idx < 4; idx++) {
            int x = dx[idx];
            int y = dy[idx];
            if (!map[x][y]) {
                q.add(new Road(x, y, idx, 100));
                isVisited[idx][x][y] = 100;
            }
        }

        while (!q.isEmpty()) {
            Road cur = q.poll();

            if ((cur.x == N - 1) && (cur.y == N - 1)) {
                answerQ.add(cur.price);
                continue;
            }

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];
                int tmpDir = cur.dir;
                int tmpPrice = cur.price + 100;

                // 유효성 검증
                if (!isValid(mx, my) || map[mx][my]) continue;

                // 방향 체크
                if (tmpDir != idx) {
                    tmpDir = idx;
                    tmpPrice += 500;
                }

                // 방문처리
                if ((isVisited[tmpDir][mx][my] == 0) || isVisited[tmpDir][mx][my] > tmpPrice) {
                    isVisited[tmpDir][mx][my] = tmpPrice;
                    q.add(new Road(mx, my, tmpDir, tmpPrice));
                }
            }
        }
        return answerQ.poll();
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}
