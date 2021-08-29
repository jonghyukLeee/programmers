package Kakao2020;

public class Q1 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.print(solution(s));

    }
    static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length()/2; ++i)
        {
            StringBuilder sb = new StringBuilder();
            System.out.println(i);
            answer = Math.min(compress(s,sb,i),answer);
        }
        return answer;
    }
    static int compress(String origin, StringBuilder cur,int len) // 원본문자열, 압축문자열, 길이
    {
        String pre = origin.charAt(0)+"";
        int cnt = 0;
        for(int i = 0; i < origin.length(); i+=len)
        {
            if(i+len > origin.length())
            {
                cur.append(origin.substring(i,origin.length()));
                break;
            }
            String cut = origin.substring(i,i+len);
            System.out.printf("cur %d ~ %d => %s\n",i,i+len,cut);
            if(pre.equals(cut))
            {
                cnt++;
                if(i+len == origin.length()) cur.append(cnt).append(pre);
            }
            else
            {
                if(cnt > 1)
                {
                    cur.append(cnt).append(pre);
                }
                else
                {
                    cur.append(pre);
                }
                pre = cut;
                cnt = 1;
            }
        }
        System.out.println(cur.toString());
        return cur.length();
    }
}
