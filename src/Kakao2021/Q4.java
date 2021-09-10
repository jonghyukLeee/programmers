package Kakao2021;

public class Q4 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int [][] map = new int[n+1][n+1];
        for(int i = 1; i <= n; ++i)
        {
            for(int j = 1; j <=n; ++j)
            {
                map[i][j] = 19900001;
            }
            map[i][i] = 0;
        }

        for(int i = 0; i < fares.length; ++i)
        {
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int k = 1; k <= n; ++k)
        {
            for(int i = 1; i <= n; ++i)
            {
                for(int j = 1; j <=n; ++j)
                {
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        answer = Integer.MAX_VALUE;
        int tmp = 0;
        for(int i = 1; i <= n; ++i)
        {
            tmp = map[s][i] + map[i][a] + map[i][b];
            answer = Math.min(answer,tmp);
        }
        return answer;
    }
}
