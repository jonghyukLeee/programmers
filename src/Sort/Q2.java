package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        ArrayList<String> al = new ArrayList<>();
        for(int i : numbers)
        {
            al.add(String.valueOf(i));
        }
        Collections.sort(al, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(String tmp : al)
        {
            answer.append(tmp);
        }
        return answer.toString();
    }
}
