package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        progresses = new int[t];
        speeds = new int[t];
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
        Stack<Integer> stack = new Stack<>();

        for(int i = progresses.length-1; i >= 0; --i)
        {
            stack.push(progresses[i]);
        }
        // 97
        ArrayList<Integer> al = new ArrayList<>();
       while(!stack.isEmpty())
        {
            int tmp = stack.pop();
            int cnt = 1;
            loop : while(!stack.isEmpty())
            {
                if(stack.peek() >= tmp)
                {
                    tmp = stack.pop();
                    cnt++;
                }
                else
                {
                    break loop;
                }
            }
            al.add(cnt);
        }
       int[] answer = new int[al.size()];
       for(int i = 0; i < answer.length; ++i)
       {
           answer[i] = al.get(i);
       }
        return answer;
    }
}
