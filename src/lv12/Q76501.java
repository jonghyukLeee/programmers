package lv12;

public class Q76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = signs.length;
        for(int i = 0; i < len; i++)
        {
            int nextVal = absolutes[i];
            answer += signs[i] ? nextVal : -nextVal;
        }
        return answer;
    }
}
