package Kakao2020;

import java.util.ArrayList;

public class intern_Q2 {
        static boolean [] isVis;
        static long maxVal = Integer.MIN_VALUE;
        static ArrayList<Long> numbers;
        static ArrayList<Character> opers;
        public static void main(String[] args) {
            System.out.print(solution("100-200*300-500+20"));
        }
        static long solution(String expression) {
            char [] opArr = {'+','-','*'};
            numbers = new ArrayList<>();
            opers = new ArrayList<>();
            StringBuilder sb = new StringBuilder(expression);

            for(int i = 0; i < sb.length(); ++i)
            {
                char c = sb.charAt(i);
                if(c == '+' || c == '-' || c == '*')
                {
                    opers.add(c);
                    sb.setCharAt(i,' ');
                }
            }
            String [] tmpNum = sb.toString().split(" ");
            for(String s : tmpNum) numbers.add(Long.parseLong(s));
            isVis = new boolean[3];
            perm(opArr,"");
            return maxVal;
        }
        static void perm(char [] arr, String curStr)
        {
            if(curStr.length() == 3)
            {
                calc(curStr);
                return;
            }
            for(int i = 0; i < 3; ++i)
            {
                if(isVis[i]) continue;
                isVis[i] = true;
                perm(arr,curStr+arr[i]);
                isVis[i] = false;
            }
        }
        static void calc(String str)
        {
            ArrayList<Long> tmpAl = new ArrayList<>(numbers);
            ArrayList<Character> tmpOP = new ArrayList<>(opers);
            for(int i = 0; i < str.length(); ++i)
            {
                char op = str.charAt(i);
                for(int j = 0; j < tmpOP.size(); ++j)
                {
                    if(tmpOP.get(j) == op)
                    {
                        if(op == '+') tmpAl.set(j,tmpAl.get(j)+tmpAl.get(j+1));
                        else if(op == '-') tmpAl.set(j,tmpAl.get(j)-tmpAl.get(j+1));
                        else tmpAl.set(j,tmpAl.get(j)*tmpAl.get(j+1));
                        tmpAl.remove(j+1);
                        tmpOP.remove(j);
                        j -= 1;
                    }
                }
            }
            maxVal = Math.max(maxVal,Math.abs(tmpAl.get(0)));
        }
    }
