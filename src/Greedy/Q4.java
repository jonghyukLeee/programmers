package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q4 {
    static int [][] costs;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        costs = new int[t][3];
        StringTokenizer st;
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(n,costs));
    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];

        for(int i = 0; i < parents.length; ++i)
        {
            parents[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int[] i : costs)
        {
            System.out.printf("%d %d %d\n",i[0],i[1],i[2]);
        }
        for (int[] i : costs) {
            int start = getParent(i[0]);
            int end = getParent(i[1]);
            if (start != end) {
                parents[end] = start;
                answer += i[2];
            }
        }

        return answer;
    }
    static int getParent(int ch)
    {
        return parents[ch] == ch ? ch : parents[ch];
    }
}
