package lv12;

public class Q49994 {
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }
    static int solution(String dirs) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][][][] isVisited = new boolean[11][11][11][11];

        int x = 5, y = 5;
        for (char dir: dirs.toCharArray()) {
            int moveIdx = getIdxByChar(dir);
            int mx = x + dx[moveIdx];
            int my = y + dy[moveIdx];

            if (isValid(mx, my)) {
                if (!isVisited[x][y][mx][my]) {
                    isVisited[x][y][mx][my] = true;
                    isVisited[mx][my][x][y] = true;
                    answer++;
                }
                x = mx;
                y = my;
            }
        }
        return answer;
    }
    static int getIdxByChar(char c) {
        switch (c) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'R': return 3;
        }
        return 0;
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x <= 10 && y <= 10;
    }
}
