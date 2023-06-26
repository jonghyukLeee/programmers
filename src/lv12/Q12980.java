package lv12;

public class Q12980 {
    public static void main(String[] args) {

    }
    static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) n /= 2;
            else {
                n--;
                answer++;
            }
        }
        return answer;
    }
}
