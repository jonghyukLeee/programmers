package Kako2022_TEST;

import java.util.ArrayList;
import java.util.Arrays;

public class Q5 {
    static ArrayList<ArrayList<Integer>> al;
    static boolean [] isVis;
    static int [] dp;
    public static void main(String[] args) {
        int [] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int [][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.print(solution(info,edges));
    }
    static int solution(int[] info, int[][] edges) {
        al = new ArrayList<>();
        isVis = new boolean[info.length];
        dp = new int[info.length];

        for(int i = 0; i < info.length; ++i) al.add(new ArrayList<>());

        for(int [] i : edges)
        {
            al.get(i[0]).add(i[1]);
            al.get(i[1]).add(i[0]);
        }
        dp[0] = 1;
        dfs(info,0,1,0);
        Arrays.sort(dp);

        return dp[dp.length-1];
    }
    static void dfs(int [] info,int cur,int sheep,int wolf)
    {
        if(dp[cur] < sheep)
        {
            dp[cur] = sheep;
        }
        for(int next : al.get(cur))
        {
            if(dp[next] < dp[cur])
            {
                if(info[next] == 1)
                {
                    if(wolf + 1 >= dp[cur]) continue;
                    dfs(info,next,dp[cur],wolf+1);
                }
                else
                {
                    dfs(info,next,dp[cur],wolf);
                }
            }
        }
    }
}
