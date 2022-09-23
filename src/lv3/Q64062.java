package lv3;

public class Q64062 {
    static int len;
    public static void main(String[] args) {

    }
    static int solution(int[] stones, int k) {
        int answer = 0;
        len = stones.length;

        int min = 1;
        int max = 200_000_000;
        while (min < max) {
            int mid = (min + max) / 2;

            if (isPossible(stones, k, mid)) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return answer;
    }
    static boolean isPossible(int [] stones, int k, int friends) {
        int cnt = 0;
        for (int stone : stones) {
            if ((stone - friends) <= 0) {
                cnt++;
                if (cnt == k) return false;
            }
            else {
                cnt = 0;
            }
        }
        return true;
    }
}
