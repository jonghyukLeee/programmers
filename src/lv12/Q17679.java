package lv12;

import java.util.ArrayList;
import java.util.List;

class Block {
    int x, y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Q17679 {
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 1, 0};
    static int M, N;
    static char[][] map;
    static boolean[][] isVisited;
    static int answer;
    public static void main(String[] args) {
        System.out.println(solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    static int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = board[i].toCharArray();
        }

        while (boom()) {
            down();
        }
        return answer;
    }
    static void down() {
        for (int i = 0; i < N; i++) {
            for (int j = M -1; j >= 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            char tmp = map[k][i];
                            map[k][i] = map[j][i];
                            map[j][i] = tmp;
                            break;
                        }
                    }
                }
            }
        }
    }
    static boolean boom() {
        isVisited = new boolean[M][N];
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isBlock(i, j, map[i][j])) {
                    list.add(new Block(i, j));
                }
            }
        }

        int cnt = 0;
        for (Block block : list) {
            for (int idx = 0; idx < 4; idx++) {
                int mx = block.x + dx[idx];
                int my = block.y + dy[idx];

                if (map[mx][my] != '.') {
                    map[mx][my] = '.';
                    cnt++;
                }
            }
        }
        answer += cnt;
        return cnt > 0;
    }

    static boolean isBlock(int x, int y, char name) {
        for (int idx = 0; idx < 4; idx++) {
            int mx = x + dx[idx];
            int my = y + dy[idx];

            if (!isValid(mx, my) || map[mx][my] != name) return false;
        }
        return true;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
