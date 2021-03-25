package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IDrec {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        System.out.print(solution(new_id));
    }
    static String solution(String id)
    {
        String answer = id;
        for(int i = 1; i < 8; ++i)
        {
            System.out.printf("%d단계 입니다.",i);
            answer = func(answer,i);
        }
        return answer;
    }
    static String func(String s, int n)
    {
        StringBuilder sb = new StringBuilder();
        String tmpStr;
        switch(n)
        {
            case 1:
            {
                return s.toLowerCase();
            }
            case 2:
            {
                char tmp;
                for(int i = 0; i < s.length(); ++i)
                {
                    tmp = s.charAt(i);
                    if(check(tmp)>0 || tmp=='-' || tmp == '_' || tmp == '.')
                    {
                        sb.append(tmp);
                    }
                }
                tmpStr = sb.toString();
                sb.delete(0,sb.length());
                return tmpStr;
            }
            case 3:
            {
                char tmp;
                boolean check = true;
                for(int i = 0; i < s.length(); ++i)
                {
                    tmp = s.charAt(i);
                    if(tmp == '.' && check)
                    {
                        sb.append(tmp);
                        check= false;
                    }
                    else
                    {
                        sb.append(tmp);
                        check = true;
                    }
                }
                tmpStr = sb.toString();
                sb.delete(0,sb.length());
                return tmpStr;
            }
            case 4:
            {
                sb.append(s);
                if(sb.charAt(0) == '.') sb.deleteCharAt(0);
                if(sb.charAt(s.length()-1) == '.') sb.deleteCharAt(s.length()-1);
                tmpStr = sb.toString();
                sb.delete(0,sb.length());
                return tmpStr;
            }
            case 5:
            {
                if(s.isEmpty()) return "a";
            }
            case 6:
            {
                sb.append(s);
                if(s.length()>15)
                {
                    sb.delete(15,s.length());
                    if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
                }
                tmpStr = sb.toString();
                sb.delete(0,sb.length());
                return tmpStr;
            }
            case 7:
            {
                sb.append(s);
                if(sb.length() <= 2)
                {
                    while(sb.length()<3)
                    {
                        sb.append(sb.charAt(sb.length()-1));
                    }
                }
                tmpStr = sb.toString();
                sb.delete(0,sb.length());
                return tmpStr;
            }
            default:
            {
                return "";
            }
        } // end of switch
    }
    static int check(char c)
    {
        int tmp = (int)c;
        if((tmp >= 97 && tmp <= 122) || (tmp >= 48 && tmp <= 57))
        {
            return 1;
        }
        else return -1;
    }
}
