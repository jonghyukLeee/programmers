package lv12;

public class Q87390 {
    public static void main(String[] args) {
    }
    static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long r = i / n;
            long c = i % n;
            answer[idx++] = (int)(Math.max(r, c) + 1);
        }
        return answer;
    }
}
