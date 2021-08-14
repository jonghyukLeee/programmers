package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class toss_Q2 {
    static int [] requests;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int server = 2;
        boolean sticky = true;

        int n = Integer.parseInt(br.readLine());
        requests = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            requests[i] = Integer.parseInt(st.nextToken());
        }

        for(int [] i : solution(server,sticky,requests))
        {
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    static int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][requests.length/2];
        ArrayList<ArrayList<Integer>> answerAl = new ArrayList<>();

        for(int i = 0; i < servers; ++i)
        {
            answerAl.add(new ArrayList<>());
        }

        if(sticky) // sticky is true
        {
            boolean [] isVis = new boolean[Integer.MAX_VALUE-5];
            int [] idxLog = new int[10000];
            int serverCnt = 0;
            for(int req : requests)
            {
                if(isVis[req])
                {
                    answerAl.get(idxLog[req]).add(req);
                    continue;
                }
                isVis[req] = true;
                if(serverCnt == servers) serverCnt = 0;
                answerAl.get(serverCnt).add(req);
                idxLog[req] = serverCnt;
                serverCnt++;
            }
        }
        else
        {
            int serverCnt = 0;
            for(int req : requests)
            {
                if(serverCnt == servers) serverCnt = 0;
                answerAl.get(serverCnt).add(req);
                serverCnt++;
            }
        }
        for(int i = 0; i < answerAl.size(); ++i)
        {
            for(int j = 0; j < answerAl.get(i).size(); ++j)
            {
                answer[i][j] = answerAl.get(i).get(j);
            }
        }
        return answer;
    }
}
