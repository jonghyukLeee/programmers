package skillcheck.lv2;

public class Q1 {
    public static void main(String[] args) {

    }
    static int solution(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n] % 1234567;
    }
}
