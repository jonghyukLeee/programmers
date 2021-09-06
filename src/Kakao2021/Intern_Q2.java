package Kakao2021;

import java.util.LinkedList;
import java.util.Queue;

class Point
{
    int x,y,cnt;

    public Point(int x, int y, int cnt)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Intern_Q2 {
    static Queue<Point> q;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static boolean [][] isVis;
    public static void main(String[] args) {

    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int answerIdx = 0;

        next : for(String [] str : places)
        {
            char [][] map = new char[5][5];
            for(int i = 0; i < 5; ++i)
            {
                char [] tmp = str[i].toCharArray();
                System.arraycopy(tmp,0,map[i],0,5);
            }

            for(int i = 0; i < 5; ++i)
            {
                for(int j = 0; j < 5; ++j)
                {
                    if(map[i][j] == 'P')
                    {
                        q = new LinkedList<>();
                        isVis = new boolean[5][5];
                        isVis[i][j] = true;
                        q.add(new Point(i,j,0));
                        if(!bfs(map)) // 안지켰을때 바로 컨티뉴
                        {
                            answer[answerIdx++] = 0;
                            continue next;
                        }
                    }
                }
            }
            answer[answerIdx++] = 1;
        }
        return answer;
    }
    static boolean bfs(char [][] map)
    {
        while(!q.isEmpty())
        {
            Point cur = q.poll();
            if(cur.cnt != 0 && map[cur.x][cur.y] == 'P')
            {
                if(cur.cnt <= 2) return false;
            }
            if(cur.cnt > 2) return true;
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || isVis[mx][my] || map[mx][my] == 'X') continue;
                isVis[mx][my] = true;
                q.add(new Point(mx,my,cur.cnt+1));
            }
        }
        return true;
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }
}
