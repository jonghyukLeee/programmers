package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4 {
    static int [] prices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        prices = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        for(int i : solution(prices))
        {
            System.out.printf("%d ",i);
        }
    }
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : prices)
        {
            al.add(i);
        }
        for(int i = 0; i < al.size(); ++i)
        {
            int cnt = 0;
            int tmp = al.get(i);
            for(int j = i+1; j < al.size(); ++j)
            {
                cnt++;
                if(tmp > al.get(j))
                {
                    break;
                }
            }
            res.add(cnt);
        }
        for(int i = 0; i < answer.length; ++i)
        {
            answer[i] = res.get(i);
        }
        return answer;
    }
}
