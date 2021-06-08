package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {
    static int [][] dp;
    static int [][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        triangle = new int[t][t];
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; ++j)
            {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(triangle));
    }
    static int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; ++i)
        {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            for(int j = 1; j < i; ++j)
            {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }

        for(int i = 0; i < dp[0].length; ++i)
        {
            answer = Math.max(dp[dp.length-1][i],answer);
        }
        return answer;
    }
}
