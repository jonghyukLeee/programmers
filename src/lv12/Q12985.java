package lv12;

public class Q12985 {
    public static void main(String[] args) {

    }
    static int solution(int n, int a, int b)
    {
        int answer = 0;
        while (a != b) {
            answer++;
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
        }
        return answer;
    }
}
