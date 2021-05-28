package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3 {
    static int [] citations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        citations = new int[t];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            citations[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(citations));
    }
    static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; ++i)
        {
            int h = citations.length-i;

            if(h <= citations[i])
            {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
