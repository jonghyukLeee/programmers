package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2 {
    static int [][] computers;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        computers = new int[n][3];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                computers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(n,computers));
    }
    static int solution(int n, int[][] computers) {
        int answer = 0;
        isVis = new boolean[n];

        for(int i = 0; i < n; ++i)
        {
            if(!isVis[i])
            {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int idx)
    {
        isVis[idx] = true;
        for(int i = 0; i < computers[0].length; ++i)
        {
            if(idx != i && computers[idx][i] == 1 && !isVis[i])
            {
                dfs(i);
            }
        }
    }
}
