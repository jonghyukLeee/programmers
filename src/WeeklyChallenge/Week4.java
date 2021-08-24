package WeeklyChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class Max
{
    String lang;
    int point;

    public Max(String lang, int point)
    {
        this.lang = lang;
        this.point = point;
    }
}
public class Week4 {
    static String [] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#",
            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
            "GAME C++ C# JAVASCRIPT C JAVA"},
            languages = {"JAVA", "JAVASCRIPT"};
    static int [] preference = {7,5};

    public static void main(String[] args) {

        System.out.print(solution(table,languages,preference));
    }
    static String solution(String[] table, String[] languages, int[] preference)     {
        String answer = "";
        ArrayList<HashMap<String,Integer>> al = new ArrayList<>();
        ArrayList<Max> tables = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < table.length; ++i)
        {
            al.add(new HashMap<>());
            st = new StringTokenizer(table[i]);
            tables.add(new Max(st.nextToken(),0));
            int tmpPoint = 5;
            while(st.hasMoreTokens())
            {
                String tmpStr = st.nextToken();
                al.get(i).put(tmpStr,tmpPoint--);
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < al.size(); ++i)
        {
            int total = 0;
            for(int j = 0; j < languages.length; ++j)
            {
                String lang = languages[j];
                if(al.get(i).get(lang) != null) total += al.get(i).get(lang) * preference[j];
            }
            if(total >= maxVal)
            {
                maxVal = total;
                tables.get(i).point = maxVal;
            }
        }

        if(tables.size() > 1)
        {
            tables.sort(new Comparator<Max>() {
                @Override
                public int compare(Max o1, Max o2) {
                    if(o1.point == o2.point)
                    {
                        return o1.lang.charAt(0) - o2.lang.charAt(0);
                    }
                    else return o2.point - o1.point;
                }
            });
        }

        answer = tables.get(0).lang;
        return answer;
    }
}
