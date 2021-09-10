package Kakao2021;

import java.sql.Array;
import java.util.*;

public class Q2 {
    static HashMap<String,Integer> hm;
    static int maxValue;
    public static void main(String[] args) {
       String [] orders = {"XYZ", "XWY", "WXA"};
       int [] course = {2,3,4};
       for(String s : solution(orders,course)) System.out.print(s+" ");
    }
    static String[] solution(String[] orders, int[] course) {
        String[] answer;
        PriorityQueue<String> q = new PriorityQueue<>();
        for(int courseNum : course) // 코스의 개수
        {
            maxValue = Integer.MIN_VALUE;
            hm = new HashMap<>();
            for(int ordersIdx = 0; ordersIdx < orders.length; ++ordersIdx)
            {
                String order = orders[ordersIdx];
                comb(order,"",0,courseNum);
                // 메뉴 조합완료
            }
            List<String> list = new ArrayList<>(hm.keySet());
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return 0;
                }
            });

            for(String key : hm.keySet()) if(hm.get(key) == maxValue && maxValue > 1) q.add(key);

        }
        answer = new String[q.size()];

        for(int i = 0; i < answer.length; ++i)
        {
            answer[i] = q.poll();
        }
        return answer;
    }
    static void comb(String order, String combStr, int idx, int len)
    {
        if(len == 0)
        {
            char [] tmpArr = combStr.toCharArray();
            Arrays.sort(tmpArr);
            String inputStr = "";
            for(int i = 0; i < tmpArr.length; ++i) inputStr+=tmpArr[i];
            hm.put(inputStr,hm.getOrDefault(inputStr,0)+1);
            maxValue = Math.max(maxValue,hm.get(inputStr));
            return;
        }
        for(int i = idx; i < order.length(); ++i)
        {
            comb(order,combStr+order.charAt(i),i+1,len-1);
        }
    }
}
