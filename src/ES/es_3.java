package ES;
public class es_3 {
    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tot = brown + yellow;
        int x = 0, y = 0;
        for(int i = 2; i <= Math.sqrt(tot);++i) {
            if ((tot % i) == 0) {
                x = tot / i;
                y = i;
                if ((x + y - 2) * 2 == brown) {
                    answer[0] = tot / i;
                    answer[1] = i;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int res[] = new int[2];
        res = solution(24,24);
        for(int i : res)
        {
            System.out.print(i+" ");
        }
    }
}
