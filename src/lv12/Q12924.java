package lv12;

public class Q12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int tmpSum = 0;
            for (int j = i; j <= n; j++) {
                tmpSum += j;
                if (tmpSum == n) {
                    answer++;
                    break;
                }
                else if (tmpSum > n) break;
            }
        }
        return answer;
    }
}
