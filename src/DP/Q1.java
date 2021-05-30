package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n =0 , number =0;
        for(int i =0; i < 2; ++i)
        {
            n = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(n,number));

    }
    static int solution(int N, int number) {
        int answer = 0;

        return answer;
    }
}
