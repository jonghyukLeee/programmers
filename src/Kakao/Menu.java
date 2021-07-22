package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//matches 말고 다른 메서드 찾아봐야할듯 ! (미완성)
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
    static boolean [] isVis;
    static ArrayList<Food> al;
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
            for(int i = 0; i < orders.length; ++i)
            {
                if(len > orders[i].length()) continue;

                al = new ArrayList<>();
                isVis = new boolean[orders[i].length()];
                comb(orders[i],"",0,len);

                for(Food tmp : al)
                {
                    String addedStr = addStar(tmp.menu,len);
                    for(int idx = i+1; idx < orders.length; ++idx)
                    {
                        if(orders[idx].matches(".*."+addedStr+".*"))
                        {
                            System.out.printf(orders[idx]+" contains "+addedStr+"\n");
                            tmp.addCnt(tmp.cnt);
                        }
                    }

                }
                //소트
                al.sort(new Comparator<Food>() {
                    @Override
                    public int compare(Food o1, Food o2) {
                        return o2.cnt - o1.cnt;
                    }
                });
                int maxCnt = al.get(0).cnt;

                for(Food tmp : al)
                {
                    if(tmp.cnt < 2) break;
                    if(tmp.cnt != maxCnt) break;
                    answerAl.add(tmp.menu);
                }
            }
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
            al.add(new Food(curStr,0));
            return;
        }

        for(int i = idx; i < target.length(); ++i)
        {
            comb(target,curStr+target.charAt(i),i+1,len-1);
        }
    }
    static String addStar(String str, int len)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; ++i)
        {
            sb.append(str.charAt(i));
            if(i == len-1) continue;
            sb.append(".");
        }
        return sb.toString();
    }
}
