package Kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Stage
{
    int cnt,stay,idx;
    double val;

    public Stage(int cnt,int stay)
    {
        this.cnt = cnt;
        this.stay = stay;
    }
    public Stage(int idx,double val)
    {
        this.idx = idx;
        this.val = val;
    }
    public void addCnt()
    {
        this.cnt++;
    }
    public void addStay()
    {
        this.stay++;
    }
}

public class Q2 {
    public static void main(String[] args) {
        int [] stages = {4,4,4,4,4};
        for(int i : solution(4,stages)) System.out.print(i+" ");
    }
    static int [] solution(int N, int [] stages)
    {
        int[] answer;
        ArrayList<Stage> al = new ArrayList<>();

        for(int i = 0; i <= N+1; ++i) al.add(new Stage(0,0));
        for(int stage : stages) // 2, 1, 2, 6, 2, 4, 3, 3
        {
            if(stage <= N) al.get(stage).addStay();
            while(stage-- > 0) al.get(stage+1).addCnt();
        }
        ArrayList<Stage> answerAl = new ArrayList<>();
        answerAl.add(new Stage(Integer.MAX_VALUE,Integer.MIN_VALUE));
        for(int i = 1; i < al.size(); ++i)
        {
            double stay = al.get(i).stay, cnt = al.get(i).cnt;
            if(stay == 0 || cnt == 0)
            {
                if(i > N) continue;
                answerAl.add(new Stage(i,0.0));
            }
            else
            {
                answerAl.add(new Stage(i,stay/cnt));
            }
        }

        Collections.sort(answerAl,new Comparator<Stage>()
        {
            @Override
            public int compare(Stage o1, Stage o2)
            {
                if(o1.val == o2.val)
                {
                    return o1.cnt - o2.cnt;
                }
                return o2.val > o1.val ? 1: -1;
            }
        });
        answer = new int[N];
        for(int i = 0; i < N; ++i)
        {
            answer[i] = answerAl.get(i).idx;
        }

        return answer;
    }
}
