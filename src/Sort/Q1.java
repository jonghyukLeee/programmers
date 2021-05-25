package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1 {
    static int [] array;
    static int [][] commands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr_len = Integer.parseInt(br.readLine());
        array = new int[arr_len];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr_len; ++i)
        {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int cmd_cnt = Integer.parseInt(br.readLine());
        commands = new int[cmd_cnt][3];
        for(int i = 0; i < cmd_cnt; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                commands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i : solution(array,commands))
        {
            System.out.print(i+" ");
        }
    }
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : array)
        {
            al.add(i);
        }

        for(int i = 0; i < commands.length; ++i)
        {
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int target = commands[i][2]-1;

            ArrayList<Integer> tmpAl = new ArrayList<>();
            for(int j = start; j <= end; ++j)
            {
                tmpAl.add(al.get(j));
            }
            Collections.sort(tmpAl);
            answer[i] = tmpAl.get(target);
        }
        return answer;
    }
}
