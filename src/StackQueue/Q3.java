package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Truck
{
    int weight, time = 0;
    public Truck(int weight)
    {
        this.weight = weight;
    }
}
public class Q3 {
    static int [] trucks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int weight_lim = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        trucks = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(length,weight_lim,trucks));
    }
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        for(int i : truck_weights)
        {
            q.add(new Truck(i));
        }
        while(!q.isEmpty())
        {
            Truck cur = q.poll();
            if(bridge(cur))
            {

            }

        }
        return answer;
    }
    static boolean bridge(Truck truck)
    {

    }
}
