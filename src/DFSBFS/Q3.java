package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3 {
    static String begin,target;
    static String [] words;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        begin = br.readLine();
        target = br.readLine();
        len = begin.length();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < t; ++i)
        {
            words[i] = st.nextToken();
        }
        System.out.print(solution(begin,target,words));
    }
    static int solution(String begin, String target, String[] words) {
        int answer = 0;
        ArrayList<String> al = new ArrayList<>();
        return answer;
    }
}
