package Kakao2021;

import java.util.Locale;

public class Q1 {
    public static void main(String[] args) {
        String str = "=.=";
        System.out.print(solution(str));
    }
    static String solution(String new_id) {
        String answer;
        //1단계
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());

        //2단계
        answer = sb.toString();
        answer = checkSign(answer);
        sb = new StringBuilder(answer);

        //3단계
        for(int i = 0; i < sb.length(); ++i)
        {
            if(sb.charAt(i) == '.')
            {
                int cnt = 1;
                for(int j = i+1; j < sb.length(); ++j)
                {
                    if(sb.charAt(j) != '.') break;
                    cnt++;
                }
                if(cnt > 1)
                {
                    StringBuilder tmpSb = new StringBuilder();
                    for(int t = 0; t < cnt; ++t)
                    {
                        tmpSb.append(".");
                    }
                    int end = i + cnt;
                    sb.replace(i,end,".");
                }
            }
        }

        //4단계
        if(sb.length() > 0)
        {
            if(sb.charAt(0) == '.')
            {
                sb.deleteCharAt(0);
            }
        }
        if(sb.length() > 0)
        {
            if(sb.charAt(sb.length()-1) == '.')
            {
                sb.deleteCharAt(sb.length()-1);
            }
        }

        //5단계
        if(sb.length() < 1) sb.append("a");
        //6단계
        if(sb.length() >= 16)
        {
            sb.delete(15,sb.length());
            if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }

        //7단계
        if(sb.length() <= 2)
        {
            char c = sb.charAt(sb.length()-1);
            while(sb.length() < 3)
            {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    static String checkSign(String str)
    {
        String answer= str;
        for(int i = 0; i < answer.length(); ++i)
        {
            int tmpChar = answer.charAt(i);
            // 소문자
            if(tmpChar >= 97 && tmpChar <= 122) continue;
            // 숫자
            if(tmpChar >= 48 && tmpChar <= 57) continue;
            // - _ .
            if(tmpChar == 45 || tmpChar == 46 || tmpChar == 95) continue;
            answer = answer.replace(answer.charAt(i)+"","");
            i--;
        }
        return answer;
    }
}

