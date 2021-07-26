package Kakao;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Rank {
    static String [] info;
    static String [] query;
    public static void main(String[] args) {
        info = new String [] {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        query = new String [] {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        for(int i : solution(info,query))
        {
            System.out.print(i+", ");
        }
    }
    static int[] solution(String[] info, String[] query) {
        int[] answer;
        ArrayList<Volunteer> volunteers = new ArrayList<>();
        ArrayList<Volunteer> queries = new ArrayList<>();
        ArrayList<Integer> answerAl = new ArrayList<>();
        for(String tmp : info)
        {
            StringTokenizer st = new StringTokenizer(tmp);
            volunteers.add(new Volunteer(st.nextToken().trim()
                                        ,st.nextToken().trim()
                                        ,st.nextToken().trim()
                                        ,st.nextToken().trim()
                                        ,Integer.parseInt(st.nextToken())));
        }
        for(String tmp : query)
        {
            String tmpStr = tmp.replace(" and","");
            StringTokenizer st = new StringTokenizer(tmpStr);
            queries.add(new Volunteer(st.nextToken().trim()
                    ,st.nextToken().trim()
                    ,st.nextToken().trim()
                    ,st.nextToken().trim()
                    ,Integer.parseInt(st.nextToken())));
        }

        for(Volunteer qualification : queries)
        {
            int cnt = 0;
            for(Volunteer volunteer : volunteers)
            {
                if(compare(volunteer,qualification)) cnt++;
            }
            answerAl.add(cnt);
        }
        answer = new int[answerAl.size()];
        for(int i = 0; i < answer.length; ++i)
        {
            answer[i] = answerAl.get(i);
        }
        return answer;
    }
    static boolean compare(Volunteer volunteer, Volunteer qualification)
    {
        return volunteer.getScore() >= qualification.getScore() &&
            (qualification.getLang().equals("-") || volunteer.getLang().equals(qualification.getLang())) &&
            (qualification.getGroup().equals("-") || volunteer.getGroup().equals(qualification.getGroup())) &&
            (qualification.getCareer().equals("-") || volunteer.getCareer().equals(qualification.getCareer())) &&
            (qualification.getFood().equals("-") || volunteer.getFood().equals(qualification.getFood()));
    }
    static class Volunteer
    {
        String lang, group, career, food;
        int score;

        public Volunteer(String lang, String group, String career, String food, int score)
        {
            this.lang = lang;
            this.group = group;
            this.career = career;
            this.food = food;
            this.score = score;
        }
        public String getLang() {
            return this.lang;
        }

        public String getGroup() {
            return this.group;
        }

        public String getCareer() {
            return this.career;
        }

        public String getFood() {
            return this.food;
        }

        public int getScore() {
            return this.score;
        }
    }
}
