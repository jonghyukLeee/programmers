package lv12;

public class Q92335 {
    public static void main(String[] args) {수
        System.out.println(solution(110011, 10));
    }
    static int solution(int n, int k) {
        int answer = 0;

        String parse = Integer.toString(n, k);
        String [] numbers = parse.split("0");

        for (String numberString : numbers) {
            // 0이 연속됐을경우 공백이 들어옴
            if (numberString.length() > 0) {
                if (isPrime(Long.parseLong(numberString))) answer++;
            }
        }
        return answer;
    }
    static boolean isPrime(Long num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
