package Etc;

public class Q4 {
    static int answerIdx = 0;
    static int [] answer;
    static int [] pn = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    public static void main(String[] args) {
        for(int i : solution(18)) System.out.print(i+" ");
    }
    static int[] solution(int n) {
        answer = new int [n];

        int [] arr = new int[n];
        for(int i = 0; i < n; ++i) arr[i] = i+1;

        mix(arr);
        return answer;
    }
    static int findP(int len)
    {
        for(int n : pn)
        {
            if((len % n) == 0) return n;
        }
        return 0;
    }

    static void mix(int [] arr)
    {
        if(arr.length == 1)
        {
            answer[answerIdx++] = arr[0];
            return;
        }
        int p = findP(arr.length);
        int [][] newArr = new int[p][arr.length/p];
        int arrIdx = 0;
        for(int i = 0; i < newArr[0].length; ++i)
        {
            for(int j = 0; j < newArr.length; ++j)
            {
                newArr[j][i] = arr[arrIdx++];
            }
        }
        for(int [] i : newArr) mix(i);
    }
}
