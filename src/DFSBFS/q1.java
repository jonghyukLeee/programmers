package DFSBFS;

import java.util.ArrayList;

public class q1 {
    /**
     * 프로그래머스 코딩테스트 고득점 kit > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
     *
     * 문제설명
     * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
     * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
     * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

     */
    static public int solution(int[] numbers, int target) {
        int answer = 0;
        int res = 0;
        ArrayList<Integer> resArr = new ArrayList<Integer>();
        calc(numbers,0,res,resArr);
        for(int i : resArr)
        {
            if(i == target) answer++;
        }
        return answer;
    }
    static public void calc(int[] numbers, int idx, int res, ArrayList resArr)
    {
        if(numbers.length == idx)
        {
            resArr.add(res);
            return;
        }
        else {
            plus(numbers, idx, res, resArr);
            minus(numbers, idx, res, resArr);
        }
    }
    static public void plus(int [] numbers, int idx, int res, ArrayList resArr)
    {
        res += numbers[idx++];
        calc(numbers,idx,res,resArr);
    }
    static public void minus(int [] numbers, int idx, int res, ArrayList resArr)
    {
        res -= numbers[idx++];
        calc(numbers,idx,res,resArr);
    }
    public static void main(String[] args) {
        int n [] = new int[]{1,2,1,2};
        System.out.println(solution(n,2));
    }
}
