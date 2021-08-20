package Kakao2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Info
{
    String apply,level,food,grade;

    public Info(String apply, String level, String food, String grade)
    {
        this.apply = apply;
        this.level = level;
        this.food = food;
        this.grade = grade;
    }
}
public class Q3 {
    static HashMap<String, ArrayList<Info>> hm;
    public static void main(String[] args) {
        String [] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100","- and - and - and - 150"};
        for(int i : solution(info,query)) System.out.print(i+" ");
    }
    static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx = 0;
        hm = new HashMap<>();
        hm.put("java",new ArrayList<>());
        hm.put("cpp",new ArrayList<>());
        hm.put("python",new ArrayList<>());

        for(String str : info)
        {
            StringTokenizer st = new StringTokenizer(str);

            String lang = st.nextToken();
            String apply = st.nextToken();
            String level = st.nextToken();
            String food = st.nextToken();
            String grade = st.nextToken();

            hm.get(lang).add(new Info(apply,level,food,grade));
        }

        for(String str : query)
        {
            int cnt = 0;
            str = str.replace(" and","");
            StringTokenizer st = new StringTokenizer(str);
            HashMap<String,String> qualification = new HashMap<>();

            qualification.put("lang",st.nextToken().trim());
            qualification.put("apply",st.nextToken().trim());
            qualification.put("level",st.nextToken().trim());
            qualification.put("food",st.nextToken().trim());
            qualification.put("grade",st.nextToken().trim());

            if(qualification.get("lang").equals("-"))
            {

            }
            if(check(qualification)) cnt++;
            if(lang.equals("-"))
            {
                for(String key: hm.keySet())
                {
                    for(Info in : hm.get(key))
                    {

                    }
                }
            }
            if(tmpGrade.equals("-"))
            {
                grade = Integer.MAX_VALUE;
            }
            else grade = Integer.parseInt(tmpGrade);

            for(Info in : hm.get(lang))
            {
                if(!apply.equals("-") && !apply.equals(in.apply)) continue;
                if(!apply.equals("-") && !level.equals(in.level)) continue;
                if(!apply.equals("-") && !food.equals(in.food)) continue;
                if(grade != Integer.MAX_VALUE && grade > in.grade) continue;
                cnt++;
            }
            answer[idx++] = cnt;
        }

        return answer;
    }
    static boolean check(HashMap<String,String> qualification)
    {
        for(Info in : hm.get(qualification.get("lang")))
        {

        }
    }
}
