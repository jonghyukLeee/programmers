package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Num
{
    int cnt, val;
    public Num(int cnt, int val)
    {
        this.cnt = cnt;
        this.val = val;
    }
}
public class Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        System.out.print(solution(n,number));

    }
    static int solution(int N, int number) {
        int answer = Integer.MAX_VALUE; // 5 12
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(1,N));
        while(!q.isEmpty())
        {
            Num tmp = q.poll();
            int val = tmp.val;
            if(tmp.cnt > 8) break;
            if(val == number)
            {
                answer = Math.min(answer,tmp.cnt);
                continue;
            }
            for(int i = 0; i < 5; ++i) // + - / *
            {
                switch(i)
                {
                    case 0:
                    {
                        q.add(new Num(tmp.cnt+1,val+N));
                        break;
                    }
                    case 1:
                    {
                        q.add(new Num(tmp.cnt+1,val-N));
                        break;
                    }
                    case 2:
                    {
                        q.add(new Num(tmp.cnt+1,val/N));
                        break;
                    }
                    case 3:
                    {
                        q.add(new Num(tmp.cnt+1,val*N));
                        break;
                    }
                    case 4:
                    {
                        if(val/10 == 0)
                        {
                            q.add(new Num(tmp.cnt+1,val*11));
                        }
                        break;
                    }
                }
            }
        }
        return answer > 8 ? -1 : answer;
    }

}
