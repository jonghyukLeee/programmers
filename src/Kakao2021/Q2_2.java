package Kakao2021;

import java.util.*;

public class Q2_2 {
    static HashMap<String,Integer> hm;
    public static void main(String[] args) {
        String [] orders = {"XYZ", "XWY", "WXA"};
        int [] course = {2,3,4};
        for(String s : solution(orders,course)) System.out.print(s+" ");
    }
    static String[] solution(String[] orders, int[] course) {
        String[] answer;
        PriorityQueue<String> q = new PriorityQueue<>();
        for(int c : course)
        {
            hm = new HashMap<>();
            for(String order : orders)
            {
                if(c > order.length()) continue;
                String tmp = "";
                String [] arr = order.split("");
                Arrays.sort(arr);
                for(String s : arr) tmp+=s;
                comb("",tmp,c,0);
            }
            if(!hm.isEmpty())
            {
                List<String> tmpList = new ArrayList<>(hm.keySet());
                tmpList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return hm.get(o2) - hm.get(o1);
                    }
                });
                int pre = Integer.MIN_VALUE;
                for(String tmp : tmpList)
                {
                    int cur = hm.get(tmp);
                    if(cur > 1 && cur >= pre)
                    {
                        pre = cur;
                        q.add(tmp);
                    }
                    else break;
                }
            }
        }
        answer = new String[q.size()];
        for(int i = 0; i < answer.length; ++i) answer[i] = q.poll();
        return answer;
    }
    static void comb(String str,String order, int len,int idx)
    {
        if(len == 0)
        {
            hm.put(str,hm.getOrDefault(str,0)+1);
            return;
        }

        for(int i = idx; i < order.length(); ++i)
        {
            comb(str+order.charAt(i)+"",order,len-1,i+1);
        }
    }
}
