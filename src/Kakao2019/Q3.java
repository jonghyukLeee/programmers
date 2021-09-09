package Kakao2019;

import java.util.ArrayList;
import java.util.Collections;

public class Q3 {
        public int solution(String[][] relation) {
            int answer = 0;
            ArrayList<ArrayList<String>> map = new ArrayList<>();

            for(int i = 0; i < relation[0].length; ++i)
            {
                map.add(new ArrayList<>());
                for(String s : relation[i]) map.get(i).add(s);
                Collections.sort(map.get(i));
            }

            String tmp = "";
            boolean isUnique = false;
            boolean [] isVis = new boolean[relation[0].length];
            next : for(int i = 0; i < map.size(); ++i)
            {
                isUnique = false;
                for(String s : map.get(i))
                {
                    if(!tmp.equals(s))
                    {
                        tmp = s;
                    }
                    else continue next;
                    isUnique = true;
                }
                if(isUnique)
                {
                    isVis[i] = true;
                    answer++;
                }
            }

            return answer;
        }
}
