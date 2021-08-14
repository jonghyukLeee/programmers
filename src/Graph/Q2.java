package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Match
{
    int wCnt, lCnt;

    public Match(int wCnt, int lCnt)
    {
        this.wCnt = wCnt;
        this.lCnt = lCnt;
    }
}
public class Q2 {
    static int [][] results;
    static ArrayList<Match> wlCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int mResults = Integer.parseInt(st.nextToken());

        results = new int[mResults][2];

        for(int i = 0; i < mResults; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; ++j)
            {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution(n,results));

    }
    static int solution(int n, int[][] results) {
        int answer = 0;
        boolean [] isVis;
        ArrayList<ArrayList<Integer>> mResults = new ArrayList<>();
        wlCnt = new ArrayList<>();
        for(int i = 0; i <= n; ++i)
        {
            mResults.add(new ArrayList<>());
            wlCnt.add(new Match(0,0));
        }

        for(int i = 0; i < results.length; ++i)
        {
            mResults.get(results[i][0]).add(results[i][1]);
        }

        for(int i = 1; i <= n; ++i)
        {
            isVis = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            isVis[i] = true;

            while(!q.isEmpty())
            {
                int node = q.poll();

                for(int lose : mResults.get(node))
                {
                    if(isVis[lose]) continue;
                    isVis[lose] = true;
                    q.add(lose);
                    wlCnt.get(i).wCnt++;
                    wlCnt.get(lose).lCnt++;
                }
            }
        }
        answer = rank(n);
        return answer;
    }
    static int rank(int n)
    {
        int cnt = 0;
        for(Match i : wlCnt)
        {
            if(i.wCnt + i.lCnt == n-1) cnt++;
        }
        return cnt;
    }
}
