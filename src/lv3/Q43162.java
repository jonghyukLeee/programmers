package lv3;

public class Q43162 {
    static int [] parents;
    static boolean [] isVisited;
    public static void main(String[] args) {

    }

    /**
     * 유니온 파인드 풀이
     */
    static int solution_unionFind(int n, int[][] computers) {
        int answer = 0;
        int rows = computers.length;
        int cols = computers[0].length;
        parents = new int[n];

        // 자기자신을 부모로 초기화
        for (int i = 0; i < n; i++) parents[i] = i;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (computers[i][j] > 0) {
                    if (getParents(j) != j) {
                        setParents(j, i);
                    }
                    else {
                        setParents(i, j);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) answer++;
        }
        return answer;
    }
    static void setParents(int parent, int child) {
        int p = getParents(parent);
        int c = getParents(child);
        parents[c] = p;
    }
    static int getParents(int child) {
        return parents[child] == child ? child : getParents(parents[child]);
    }
    /**
            DFS 풀이
     */
    static int solution(int n, int[][] computers) {
        int answer = 0;
        int rows = computers.length;
        isVisited = new boolean[n];
        for (int i = 0; i < rows; i++) {
            if (!isVisited[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }
        return answer;
    }
    static void dfs(int root, int n, int [][] computers) {
        isVisited[root] = true;
        for (int i = 0; i < n; i++) {
            if (computers[root][i] > 0 && !isVisited[i]) {
                dfs(i, n, computers);
            }
        }
    }
}