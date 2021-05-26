package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2 {
    static int [] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int numbers_cnt = Integer.parseInt(br.readLine());
        numbers = new int[numbers_cnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numbers_cnt; ++i)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(numbers));
    }
    static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<String> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : numbers)
        {
            String tmp = i+"";
            if(tmp.length() > 1)
            {
                String [] tmpArr = tmp.split("");
                q.addAll(Arrays.asList(tmpArr));
            }
            else q.add(tmp);
        }
        while(!q.isEmpty())
        {
            answer.append(q.poll());
        }
        return answer.toString();
    }
}
