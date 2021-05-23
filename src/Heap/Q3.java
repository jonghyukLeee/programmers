package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3 {
    static String [] operations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
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
        int[] answer = {};
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; ++i)
        {

        }
        return answer;
    }
}
