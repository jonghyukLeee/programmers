package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1 {
    static int [] progresses, speeds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            progresses[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : solution(progresses,speeds))
        {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }
    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < progresses.length; ++i)
        {
            stack.push(progresses[i]);
        }
        while(stack.isEmpty())
        {

        }
        return answer;
    }
}
