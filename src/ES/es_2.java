package ES;

import java.util.HashSet;
import java.util.Iterator;

public class es_2 {
    /**
     * 프로그래머스 코딩테스트 고득점 kit > 완전탐색 > 소수찾기
     *
     * 문제 설명
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     *
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
     * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

     */
    static public int solution(String numbers) {
        int answer = 0;
        char arr [] = numbers.toCharArray();
        HashSet<Integer> num = new HashSet<Integer>();
        for(int i = 0; i < arr.length; ++i)
        {
            num.add(arr[i]-'0');
        }
        for(int i = 1; i < arr.length; ++i)
        {
            perm(arr,0,i,num);
        }
        Iterator it = num.iterator();
        while(it.hasNext())
        {
            int n = (int)it.next();

            if(n < 2) continue;
            if(n == 2)
            {
                answer++;
                continue;
            }
            int p = 1;
            for(int i = 2; i < Math.sqrt(n);++i)
            {
                if((n % i) == 0)
                {
                    p ^= 1;
                    break;
                }
            }
            if(p == 1)
            {
                answer++;
            }

        }
        return answer;
    }
    static public void perm(char[] arr, int depth, int k, HashSet num) {
        if (depth == k) {
            // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            add(arr, k, num);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, i, depth);
                perm(arr, depth + 1, k, num);
                swap(arr, i, depth);
            }
        }
    }

    static public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static public void add(char[] arr, int k, HashSet num) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < k+1; ++i)
        {
           sb.append(arr[i]);
        }
        num.add(Integer.parseInt(sb.toString()));
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
