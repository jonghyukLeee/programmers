package lv3;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q17678 {
    public static void main(String[] args) {

    }
    static String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            String [] tmp = time.split(":");
            int hour = Integer.parseInt(tmp[0]);
            int min = Integer.parseInt(tmp[1]);

            pq.add((hour * 60) + min);
        }
        int curTime = 9 * 60;
        int m_count = 0;
        int lastCrew = 0;
        for (int i = 0; i < n; i ++) {
            m_count = 0;

            while (!pq.isEmpty() && pq.peek() <= curTime) {
                m_count++; //한명 태우고
                lastCrew = pq.poll(); // 마지막 탑승객의 시간 갱신

                if (m_count == m) {
                    // 탑승객 꽉차면 다음 버스로
                    break;
                }
            }
            // 다음 배차시간
            curTime += t;
        }

        int answer = m_count == m ? lastCrew - 1 : curTime - t;

        return timeToString(answer);
    }

    static String timeToString(int time) {
        String hour = String.format("%02d", time / 60);
        String min = String.format("%02d", time % 60);
        return hour + ":" + min;
    }
}
