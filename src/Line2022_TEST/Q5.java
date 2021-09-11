package Etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q5 {
    static int [] parents;
    public static void main(String[] args) {
       String [] nicks = {"99polico", "99policd"};
       String [] emails = {"687ufq687@aaa.xx.yyy", "587ufq687@aaa.xx.yyy"};
        System.out.println(solution(nicks,emails));
    }
    static int solution(String[] nicks, String[] emails) {
        int answer = 0;
        parents = new int[nicks.length];
        for(int i = 0; i < parents.length; ++i) parents[i] = i;
        for(int i = 0; i < nicks.length; ++i)
        {
            String curNick = nicks[i], curEmail = emails[i];
            for(int j = i+1; j < nicks.length; ++j)
            {
                if(isSameNick(curNick,nicks[j]) && isSameEmail(curEmail,emails[j]))
                {
                    parents[j] = getParent(i);
                }
            }
        }
        for(int i = 0; i < parents.length; ++i)
        {
            if(i == parents[i]) answer++;
        }
        return answer;
    }
    static int getParent(int child)
    {
        if(parents[child] == child) return child;
        else
        {
            return getParent(parents[child]);
        }
    }
    static boolean isSameNick(String fstNick,String secNick)
    {
        String large,small;
        if(fstNick.length() >= secNick.length())
        {
            large = fstNick;
            small = secNick;
        }
        else
        {
            small = fstNick;
            large = secNick;
        }
        String tmpSmall = small;
        String tmpLarge = large;
        int sLen = tmpSmall.length(), lLen = tmpLarge.length();

        for(int i = 0; i < sLen; ++i)
        {
            large = large.replaceFirst("["+tmpSmall+"]","");
        }
        for(int i = 0; i < lLen; ++i)
        {
            small = small.replaceFirst("["+tmpLarge+"]","");
        }

        int len = small.length()+large.length();
        return len <= 2;
    }
    static boolean isSameEmail(String fstEmail,String secEmail)
    {
        String [] fst = fstEmail.split("@");
        String [] sec = secEmail.split("@");

        String fstId = fst[0], fstServe = fst[1], secId = sec[0], secServe = sec[1];
        if(!fstServe.equals(secServe)) return fstId.equals(secId);

        String large,small;
        if(fstId.length() >= secId.length())
        {
            large = fstId;
            small = secId;
        }
        else
        {
            large = secId;
            small = fstId;
        }
        String tmpSmall = small;
        String tmpLarge = large;
        for(int i = 0; i < tmpSmall.length(); ++i)
        {
            large = large.replaceFirst("["+tmpSmall+"]","");
        }
        for(int i = 0; i < tmpLarge.length(); ++i)
        {
            small = small.replaceFirst("["+tmpLarge+"]","");
        }
        int len = large.length() + small.length();
        return len <= 1;
    }
}
