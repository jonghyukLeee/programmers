package lv12;

import java.util.LinkedList;
import java.util.Queue;

class Area
{
    int x,y;

    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Q1829 {
    static int M,N,max;
    public static void main(String[] args) {
    }
    static int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        max = Integer.MIN_VALUE;
        Queue<Area> q = new LinkedList<>();
        boolean [][] visited = new boolean[m][n];
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        int areaCnt = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(picture[i][j] > 0 && !visited[i][j])
                {
                    areaCnt++;
                    int tmpSize = 1,curColor = picture[i][j];
                    visited[i][j] = true;
                    q.add(new Area(i,j));
                    while(!q.isEmpty())
                    {
                        Area cur = q.poll();
                        for(int idx = 0; idx < 4; idx++)
                        {
                            int mx = cur.x + dx[idx];
                            int my = cur.y + dy[idx];

                            if(!isValid(mx,my) || picture[mx][my] != curColor || visited[mx][my]) continue;
                            visited[mx][my] = true;
                            tmpSize++;
                            q.add(new Area(mx,my));
                        }
                    }
                    max = Math.max(max,tmpSize);
                }
            }
        }
        return new int[] {areaCnt,max};
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
