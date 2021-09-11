package Etc;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        String [] research = {"yxxy","xxyyy"};
        int n = 2, k = 1;
        System.out.print(solution(research,n,k));
    }
    static String solution(String[] research, int n, int k) {
        String answer = "";
        int [][] map = new int[26][research.length];
        for(int i = 0; i < research.length; ++i)
        {
            for(int j = 0; j < research[i].length(); ++j)
            {
                char cur = research[i].charAt(j);
                map[cur-97][i]++;
            }
        }

        int total = 2 * n * k;
        int maxVal = Integer.MIN_VALUE;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < map.length; ++i)
        {
            for(int j = 0; j < map[0].length; ++j)
            {
                int tmpTotal = 0;
                for(int l = j; l < j+n; ++l)
                {
                    if(l == research.length) break;
                    if(map[i][l] < k) break;
                    else
                    {
                        tmpTotal += map[i][l];
                    }
                }
                if(tmpTotal >= total)
                {
                    char c = (char)(i+97);
                    hm.put(c,hm.getOrDefault(c,0)+1);
                    maxVal = Math.max(maxVal,hm.get(c));
                }
            }
        }
        if(maxVal == Integer.MIN_VALUE) return "None";
        List<Character> tmpList = new ArrayList<>(hm.keySet());
        tmpList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });

        for(char c : tmpList)
        {
            if (hm.get(c) == maxVal)
            {
                answer = c + "";
                break;
            }
        }
        return answer;
    }
}
