package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Car
{
    int in,out;

    public Car(int in, int out)
    {
        this.in = in;
        this.out = out;
    }
}
public class Q5 {
    static int [][] routes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        routes = new int[t][2];

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            routes[i][0] = Integer.parseInt(st.nextToken());
            routes[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(routes));
    }
    static int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Car> q = new PriorityQueue<>(new Comparator<Car>()
        {
            @Override
            public int compare(Car o1, Car o2)
            {
                return o1.out - o2.out;
            }
        });
        for(int [] i : routes)
        {
            q.add(new Car(i[0],i[1]));
        }
        while(!q.isEmpty())
        {
            Car tmp = q.poll();
            answer++;
            int val = tmp.out;
            while(!q.isEmpty())
            {
                if(val >= q.peek().in)
                {
                    q.poll();
                }
                else break;
            }
        }
        return answer;
    }
}
