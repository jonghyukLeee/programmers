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
    static Queue<Truck> bridge;
    static int length;
    static int answer,lim;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bridge = new LinkedList<>();
        length = Integer.parseInt(br.readLine());
        int weight_lim = Integer.parseInt(br.readLine());
        lim = 0;
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
        answer = 0;
        Queue<Truck> q = new LinkedList<>();
        for(int i : truck_weights)
        {
            q.add(new Truck(i));
        }
        while(!q.isEmpty())
        {
            if(bridge.isEmpty())
            {
                bridge.add(q.poll());
                bridge();
            }
            Truck tmp = q.peek();
            if(!q.isEmpty() && tmp.weight + bridge.peek().weight <= weight)
            {
                bridge.add(q.poll());
            }
            bridge();
        }
        while(!bridge.isEmpty())
        {
            bridge();
        }
        return answer+1;
    }
    static void bridge()
    {
            answer++;
            for(Truck tmp : bridge)
            {
                tmp.time++;
            }
            if(!bridge.isEmpty() && bridge.peek().time == length)
            {
                bridge.poll();
            }
    }
}
