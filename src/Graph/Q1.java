package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Q1 {
    static ArrayList<ArrayList<Integer>> al;
    static int [][] edge;
    static boolean [] isVis;
    static int answer;
    static ArrayList<Integer> nextNodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edge = new int[m][2];
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n,edge));
    }
    static int solution(int n, int[][] edge) {
        answer = 0;
        al = new ArrayList<>();
        isVis = new boolean[n+1];
        for(int i = 0; i <=n; ++i)
        {
            al.add(new ArrayList<>());
        }

        for (int[] i : edge) {
            int fst = i[0], sec = i[1];
            al.get(fst).add(sec);
            al.get(sec).add(fst);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVis[1] = true;
        while(true)
        {
            nextNodes = new ArrayList<>();
            while(!q.isEmpty())
            {
               int cur = q.poll();
               for (int node : al.get(cur))
               {
                    if (isVis[node]) continue;
                    isVis[node] = true;
                 nextNodes.add(node);
               }
            }
            if(nextNodes.isEmpty()) break;
            answer = nextNodes.size();
            q.addAll(nextNodes);
        }
        return answer;
    }

}
