package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3 {
    static String begin,target;
    static String [] words;
    static int answer;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        begin = br.readLine();
        target = br.readLine();
        int t = Integer.parseInt(br.readLine());
        words = new String[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < t; ++i)
        {
            words[i] = st.nextToken();
        }
        System.out.print(solution(begin,target,words));
    }
    static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        isVis = new boolean[words.length];
        dfs(0,begin);
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    static void dfs(int cnt, String cur)
    {
        if(cur.equals(target))
        {
            answer = Math.min(answer,cnt);
            return;
        }
        for(int i = 0; i < words.length; ++i)
        {
            if(isVis[i]) continue;
            int diff_cnt = 0;
            for(int j  = 0; j < cur.length(); ++j)
            {
                if(cur.charAt(j) == words[i].charAt(j)) diff_cnt++;
            }
            if(diff_cnt == cur.length()-1)
            {
                isVis[i] = true;
                dfs(cnt+1,words[i]);
                isVis[i] = false;
            }
        }
    }
}
