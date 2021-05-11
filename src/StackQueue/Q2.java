package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Print
{
    int priority,loc;

    public Print(int priority, int loc)
    {
        this.priority = priority;
        this.loc = loc;
    }
}
public class Q2 {
    static int [] priorities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        priorities = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            priorities[i] = Integer.parseInt(st.nextToken());
        }
        int question = Integer.parseInt(br.readLine());
        System.out.print(solution(priorities,question));
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; ++i)
        {
            q.add(new Print(priorities[i],i));
        }
        int cnt = 0;
        while(!q.isEmpty())
        {
            int tmp = q.peek().priority;
            boolean flag = false;
            for(Print i : q)
            {
                if(tmp < i.priority)
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                q.add(q.poll());
            }
            else
            {
                Print res = q.poll();
                cnt++;
                if(res.loc == location)
                {
                    answer = cnt;
                    break;
                }
            }

        }
        return answer;
    }
}
