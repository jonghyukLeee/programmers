package Kakao2019;

import java.util.ArrayList;
import java.util.Collections;

public class Q3 {
    public static void main(String[] args) {
        String [][] str = {{"100","ryan","music","2"}
                ,{"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}};
        System.out.print(solution(str));
    }
        static public int solution(String[][] relation) {
            int answer = 0;
            ArrayList<ArrayList<String>> map = new ArrayList<>();

            for(int i = 0; i < relation[0].length; ++i)
            {
                map.add(new ArrayList<>());
                for(int j = 0; j < relation.length; ++j)
                {
                    map.get(i).add(relation[j][i]);
                }
                Collections.sort(map.get(i));
            }
            for(ArrayList<String> al : map)
            {
                for(String s : al) System.out.print(s+" ");
                System.out.println();
            }
            String tmp = "";
            boolean isUnique = false;
            boolean [] isVis = new boolean[relation[0].length];


            return answer;
        }
}
