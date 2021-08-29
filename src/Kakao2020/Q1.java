package Kakao2020;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        String s = "a";
        System.out.print(solution(s));

    }
    static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() < 2) return 1;
        for(int i = 1; i <= s.length()/2; ++i)
        {
            StringBuilder sb = new StringBuilder();
            answer = Math.min(compress(s,sb,i),answer);
        }
        return answer;
    }
    static int compress(String origin, StringBuilder cur,int len)
    {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < origin.length(); i+=len)
        {
            if(i+len > origin.length()) al.add(origin.substring(i));
            else al.add(origin.substring(i,i+len));
        }
        String pre = al.get(0);
        int cnt = 1;
        for(int i = 1; i < al.size(); ++i)
        {
            if(pre.equals(al.get(i))) cnt++;
            else
            {
                if(cnt > 1)
                {
                    cur.append(cnt).append(pre);
                    pre = al.get(i);
                    cnt = 1;
                }
                else
                {
                    cur.append(pre);
                    pre = al.get(i);
                }
            }
        }
        if(cnt > 1) cur.append(cnt).append(pre);
        else cur.append(pre);

        return cur.length();
    }
}
