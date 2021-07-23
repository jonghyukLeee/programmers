package Kakao;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Food
{
    String menu;
    int cnt;
    public Food(String menu, int cnt)
    {
        this.menu = menu;
        this.cnt = cnt;
    }
    public void addCnt(int cnt)
    {
        this.cnt++;
    }
}
public class Menu {
    static String [] orders;
    static int [] course;
    static HashMap<String,Integer> hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        orders = new String[n];
        course = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; ++i)
        {
            orders[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; ++i)
        {
            course[i] = Integer.parseInt(st.nextToken());
        }

        for(String answer : solution(orders,course))
        {
            System.out.print(answer+" ");
        }
    }
    static public String[] solution(String[] orders, int[] course) {
        String[] answer;
        ArrayList<String> answerAl = new ArrayList<>();
        for(int len : course)
        {
            hm = new HashMap<>();
            for(int i = 0; i < orders.length; ++i)
            {
                if(len > orders[i].length()) continue;
                comb(orders[i],"",0,len);

                Set<String> keys = hm.keySet();
                Iterator<String> it = keys.iterator();

                while(it.hasNext())
                {
                    String menuStr = it.next();
                    if(hm.get(menuStr) > 1) continue;
                    nextMenu : for(int idx = i+1; idx < orders.length; ++idx)
                    {
                        for(int menuIdx = 0; menuIdx < len; ++menuIdx)
                        {
                            if(!orders[idx].contains(menuStr.charAt(menuIdx)+"")) continue nextMenu;
                        }
                        hm.put(menuStr,hm.get(menuStr)+1);
                    }
                }

            }
            List<Map.Entry<String,Integer>> tmpList = new LinkedList<>(hm.entrySet());
            tmpList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            if(!tmpList.isEmpty())
            {
                int maxVal = tmpList.get(0).getValue();
                for(Map.Entry<String,Integer> tmp : tmpList)
                {
                    int val = tmp.getValue();
                    if(val < 2 || val != maxVal) break;
                    answerAl.add(tmp.getKey());
                    hm.replace(tmp.getKey(),0);
                }
            }

        }
        for(int k = 0; k < answerAl.size(); ++k)
        {
            char [] tmpArr = answerAl.get(k).toCharArray();
            Arrays.sort(tmpArr);
            answerAl.set(k,Arrays.toString(tmpArr)
                    .replace("[","")
                    .replace("]","")
                    .replace(", ",""));
        }
        Collections.sort(answerAl);
        answer = new String[answerAl.size()];
        for(int i = 0; i < answerAl.size(); ++i)
        {
            answer[i] = answerAl.get(i);
        }
        return answer;
        }


    static void comb(String target, String curStr, int idx,int len)
    {
        if(len == 0) // 조합완성
        {
            hm.putIfAbsent(curStr, 1);
            return;
        }

        for(int i = idx; i < target.length(); ++i)
        {
            comb(target,curStr+target.charAt(i),i+1,len-1);
        }
    }
}
