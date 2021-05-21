package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Job
{
    int start,end;
    public Job(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

public class Q2 {
    static int [][] jobs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        jobs = new int[t][2];
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; ++j)
            {
                jobs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(jobs));
    }
    static int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Job> list = new LinkedList<>();

        PriorityQueue<Job> q = new PriorityQueue<>(new Comparator<Job>()
        {
            @Override
            public int compare(Job j1, Job j2)
            {
                return j1.end - j2.end;
            }
        });

        for(int [] i : jobs)
        {
            list.add(new Job(i[0],i[1]));
        }
        list.sort(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                if (j1.start == j2.start) return j1.end - j2.end;
                return j1.start - j2.start;
            }
        });

        int cTime = 0;
        int cnt = 0;

        while(cnt < jobs.length)
        {
            while(!list.isEmpty() && list.peek().start <= cTime)
            {
                q.add(list.poll());
            }
            if(!q.isEmpty())
            {
                Job tmp = q.poll();
                cTime += tmp.end;
                answer += cTime - tmp.start;
                cnt++;
            }
            if(!list.isEmpty() && list.peek().start > cTime) cTime++;
        }
        return answer / cnt;
    }
}
