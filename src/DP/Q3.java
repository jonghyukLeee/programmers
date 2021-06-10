package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
    int x,y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q3 {
    static int [][] puddles;
    static int [] dx = {1,0};
    static int [] dy = {0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        puddles = new int[m][n];

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            puddles[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }
        System.out.print(solution(m,n,puddles));
    }
    static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));

        while(!q.isEmpty())
        {
            Point tmp = q.poll();
            if(tmp.x == m-1 && tmp.y == n-1)
            {
                answer++;
                continue;
            }
            for(int i  = 0; i < 2; ++i)
            {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                if(!isValid(x,y)) continue;
                if(puddles[x][y] == 1) continue;
                q.add(new Point(x,y));
            }
        }
        return answer;
    }
    static boolean isValid(int x, int y)
    {
        if(x < 0 || x >= puddles.length || y < 0 || y >=puddles[0].length) return false;
        return true;
    }
}
