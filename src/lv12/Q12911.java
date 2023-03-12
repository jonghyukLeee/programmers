package lv12;

public class Q12911 {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }
    static int solution(int n) {
        int answer = 0;
        int bitCount = Integer.bitCount(n);

        for (int i = n + 1; i <= 1000000; i++) {
            int tmpCnt = Integer.bitCount(i);

            if (tmpCnt == bitCount) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}