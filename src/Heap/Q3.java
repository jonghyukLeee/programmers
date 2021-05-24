package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3 {
    static String [] operations;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        operations = new String[t];
        for(int i = 0; i < t; ++i)
        {
            operations[i] = br.readLine();
        }
        for(int i : solution(operations))
        {
            System.out.printf("%d ",i);
        }
    }
    static int[] solution(String[] operations) {
        int[] answer = new int [2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; ++i)
        {
            st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int tmp = Integer.parseInt(st.nextToken());

            switch(op)
            {
                case "I" :
                {
                    minQ.add(tmp);
                    maxQ.add(tmp);
                    break;
                }
                case "D" :
                {
                    if(minQ.isEmpty()) break;
                    if(tmp > 0)
                    {
                        Object del = maxQ.poll();
                        minQ.remove(del);
                        break;
                    }
                    else
                    {
                        Object del = minQ.poll();
                        maxQ.remove(del);
                        break;
                    }
                }
            }
        }
        if(minQ.isEmpty())
        {
            answer[0] = 0;
            answer[1] = 0;
        }
        else
        {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}
