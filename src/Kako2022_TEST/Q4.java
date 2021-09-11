package Kako2022_TEST;

public class Q4 {
    public static void main(String[] args) {

    }
    static int[] solution(int n, int[] info) {
        int[] answer = {};
        int cnt;

        for(int i = 0 ; i < info.length; ++i)
        {
            int [] ryan = new int[info.length];
            cnt = n;
            loop : for(int j = 0; j < info.length; ++j)
            {
                while(ryan[j] > info[j])
                {
                    ryan[j]++;
                    cnt--;
                    if(cnt == 0) break loop;
                }
            }
            int rPoint,aPoint;

        }
        return answer;
    }
}
