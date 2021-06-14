package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2 {
    static int [][] computers;
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
        int answer = 1;
        ArrayList<Integer> parents = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            parents.add(i);
        }
        for(int i = 0; i < computers.length; ++i)
        {
            for(int j = i+1; j < computers[0].length; ++j)
            {
                if(computers[i][j] > 0)
                {
                    parents.set(j,parents.get(i));
                }
            }
        }
        int tmp = parents.get(0);
        for(Integer i : parents)
        {
            System.out.printf("%d ",i);
            if(tmp != i)
            {
                tmp = i;
                answer++;
            }
        }
        System.out.println();
        return answer;
    }
}
