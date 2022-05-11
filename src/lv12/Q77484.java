package lv12;

public class Q77484 {
    public static void main(String[] args) {

    }
    static int[] solution(int[] lottos, int[] win_nums) {
        //맞춘 개수에 따른 점수 idx = 맞춘개수, val = 순위
        int [] rank = {6,6,5,4,3,2,1};

        //당첨 번호
        boolean [] winNum = new boolean[46];
        for(int n : win_nums) winNum[n] = true;

        int correctCnt = 0;
        int zeroCnt = 0;

        for(int n : lottos)
        {
            if(n == 0) zeroCnt++;
            else if(winNum[n]) correctCnt++;
        }

        //최소는 직접 맞춘 개수
        int min = correctCnt;
        //최대는 가려진 수가 모두 당첨번호일때
        int max = correctCnt + zeroCnt;

        return new int[] {rank[max],rank[min]};
    }
}
