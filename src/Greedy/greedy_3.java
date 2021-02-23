package Greedy;

import java.util.Arrays;

public class greedy_3 {
     static public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int cnt = 0;
            int min = 0;
            int max = people.length-1;
            for(int i = max; i >=0; --i)
            {
                if((people[i]+people[min] <= limit) && i != min)
                {
                    min++;
                    cnt += 2;
                    answer++;
                    if(cnt == people.length) break;
                }
                else
                {
                    cnt++;
                    answer++;
                    if(cnt == people.length) break;
                }
            }
            return answer;
        }


    public static void main(String[] args) {
        int people[] = new int[]{70, 80, 50};
        int limit = 100;
        System.out.println(solution(people,limit));
    }
}
