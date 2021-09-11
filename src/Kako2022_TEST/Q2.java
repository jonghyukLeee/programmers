package Kako2022_TEST;

import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) {
        System.out.print(solution(1000000,3));
    }
    static int solution(int n, int k) {
        int answer = 0;
        if(n == 0) return 0;
        String str = convert(n,k);

        str = str.replaceAll("[0]+"," ");
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens())
        {
            long cur = Long.parseLong(st.nextToken());
            if(isPrime(cur)) answer++;
        }
        return answer;
    }
    static boolean isPrime(long n)
    {
        if(n == 1) return false;
        for(long i = 2; i*i<= n; ++i)
        {
            if(n % i == 0) return false;
        }
        return true;
    }
    static String convert(int val, int k)
    {
        StringBuilder sb = new StringBuilder();
        while(val >= 1)
        {
            sb.insert(0,val % k);
            val /= k;
        }
        return sb.toString();
    }
}
