package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_2 {
    static int [] numbers;
    static int answer,target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        numbers = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(br.readLine());
        System.out.print(solution(numbers,target));
    }
    static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers[0],0);
        dfs(-numbers[0],0);
        return answer;
    }
    static void dfs(int num, int idx)
    {
        if(idx == numbers.length-1)
        {
            if(num == target)
            {
                System.out.println(num);
                answer++;
            }
            return;
        }
        dfs(num+numbers[idx+1],idx+1);
        dfs(num-numbers[idx+1],idx+1);
    }
}
