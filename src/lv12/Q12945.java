package lv12;

public class Q12945 {
    public static void main(String[] args) {

    }
    static int solution(int n) {
        long [] fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        }
        return (int)fibo[n] % 1234567;
    }
}
