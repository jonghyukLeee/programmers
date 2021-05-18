package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1 {
    static int [] scoville;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        scoville = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            scoville[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        System.out.print(solution(scoville,k));
    }
    static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : scoville)
        {
            q.add(i);
        }
        while(!q.isEmpty())
        {
            Integer fst = q.poll();
            if(fst <= K)
            {
                if(q.isEmpty()) return -1;
                Integer sec = q.poll();
                Integer mixFood = fst + (sec*2);
                q.add(mixFood);
                answer++;
            }
        }
        return answer;
    }
}
