package lv12;

public class Q12977 {
    static int answer;
    static int maxValue;
    static int size;
    static int [] n;
    static boolean [] isNotPrime;
    public static void main(String[] args) {

    }
    static int solution(int[] nums) {
        answer = 0;
        n = nums;
        //중복없이 숫자 하나의 최댓값이 1000이므로 넉넉하게 nums배열의 크기 * 1000까지의 소수를 구함.
        size = nums.length;
        maxValue = size * 1000;
        isNotPrime = new boolean[maxValue+1];
        isNotPrime[0] = isNotPrime[1] = true;
        setPrime();

        dfs(0,0,0);
        return answer;
    }
    static void setPrime() {
        for (int i = 2; i * i <= maxValue; i++){
            if (!isNotPrime[i]){
                for (int j = i * i; j <= maxValue; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
    }
    static void dfs(int idx, int sum,int depth) {
        if (depth == 3){
            if (!isNotPrime[sum]) answer++;
            return;
        }

        for (int i = idx; i < size; i++){
            dfs(i+1,sum + n[i], depth + 1);
        }
    }
}
