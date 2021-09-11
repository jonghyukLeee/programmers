package Etc;

public class Q1 {
    public static void main(String[] args) {
        int [] student = {0, 1, 0};
        int k = 2;
        System.out.print(solution(student,k));
    }
    static int solution(int[] student, int k) {
        int answer = 0;
        int cnt = k;
        for(int i = 0; i < student.length; ++i)
        {
            cnt = k;
            for(int j = i; j < student.length; ++j)
            {
                if(student[j] == 1) cnt--;
                if(cnt == 0)
                {
                    answer++;
                }
            }
        }
        return answer;
    }

}
