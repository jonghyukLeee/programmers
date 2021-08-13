package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {
    static int [][] results;
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

        System.out.print(solution(n,results));

    }
    static int solution(int n, int[][] results) {
        int answer = 0;

        return answer;
    }
}
