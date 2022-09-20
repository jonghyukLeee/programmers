package lv12;

import java.util.*;

public class Q92341 {
    static int MIN_TIME,MIN_COST,TIME_PER,COST_PER;
    public static void main(String[] args) {

    }
    static int[] solution(int[] fees, String[] records) {
        int[] answer;
        MIN_TIME = fees[0];
        MIN_COST = fees[1];
        TIME_PER = fees[2];
        COST_PER = fees[3];

        Map<String, Integer> parkingLot = new HashMap<>();
        Map<String, Integer> total = new TreeMap<>();

        for (String record : records) {
            String[] values = record.split(" ");
            String[] timeSplit = values[0].split(" ");
            String carNumber = values[1];
            String status = values[2];

            int time = (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);

            // 입차
            if (status.equals("IN")) {
                parkingLot.put(carNumber, time);
            }
            //출차
            else {
                int parkingTime = (time - parkingLot.get(carNumber));
                total.put(carNumber, total.getOrDefault(carNumber, 0) + parkingTime);
                parkingLot.remove(carNumber);
            }
        }
        //출차 안한 차
        if (!parkingLot.isEmpty()) {
            int lastTime = (23 * 60) + 59;
            for (String key : parkingLot.keySet()) {
                int time = lastTime - parkingLot.get(key);
                total.put(key, total.getOrDefault(key, 0) + time);
            }
        }
        answer = new int[total.size()];
        int idx = 0;
        for (String keys : total.keySet()) {
            int totalTime = total.get(keys);
            int result = MIN_COST;
            if (totalTime > MIN_TIME) {
                totalTime -= MIN_TIME;
                result += ((totalTime / TIME_PER) * COST_PER);
                if (totalTime % TIME_PER > 0) result += COST_PER;
            }
            answer[idx++] = result;
        }

        return answer;
    }
}
