package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4 {
    static int [][] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        costs = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        int cost = 0;
        return answer;
    }
}
