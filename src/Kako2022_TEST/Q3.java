package Kako2022_TEST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Car
{
    int in;
    int total = 0;
    boolean isOut;

    public Car(int in, boolean isOut)
    {
        this.in = in;
        this.isOut = isOut;
    }
    public void setStatus()
    {
        this.isOut = !this.isOut;
    }
    public void setTotal(int val)
    {
        this.total += val;
    }
}
public class Q3 {
    public static void main(String[] args) {
        int [] fees = {180, 5000, 10, 600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT"
                , "22:59 5961 IN", "23:00 5961 OUT"};
        for(int i : solution(fees,records)) System.out.println(i+" ");
    }
    static int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<Integer,Car> hm = new HashMap<>();

        for(String rec : records)
        {
            String [] arr = rec.split(" ");
            String [] timeArr = arr[0].split(":");
            int time = (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
            int carId = Integer.parseInt(arr[1]);
            String action = arr[2];

            if(action.equals("IN"))
            {
                if(hm.get(carId) == null)
                {
                    hm.put(carId,new Car(time,false));
                }
                else
                {
                    hm.get(carId).in = time;
                    hm.get(carId).setStatus();
                }
            }
            else
            {
                int outTime = time - hm.get(carId).in;
                hm.get(carId).setStatus();
                hm.get(carId).setTotal(outTime);
            }
        }
        for(int key : hm.keySet())
        {
            if(!hm.get(key).isOut)
            {
                int outTime = 1439 - hm.get(key).in;
                hm.get(key).setTotal(outTime);
            }
        }
        List<Integer> tmpList = new ArrayList<>(hm.keySet());
        tmpList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int answerIdx = 0;
        answer= new int[hm.size()];

        for(int val : tmpList)
        {
           answer[answerIdx++] = calc(fees,hm.get(val).total);
        }
        return answer;
    }
    static int calc(int [] fees, int val) // 340
    {
        int base = fees[1];
        if(val <= fees[0]) return base;
        return base + (int)Math.ceil((double)(val- fees[0]) / fees[2]) * fees[3];
    }
}
