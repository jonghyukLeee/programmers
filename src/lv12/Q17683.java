package lv12;

import java.util.PriorityQueue;
import java.util.Queue;

class Music {
    int time;
    String title;

    public Music(int time, String title) {
        this.time = time;
        this.title = title;
    }
}

public class Q17683 {
    public static void main(String[] args) {
        String [] music = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution("ABC", music));
    }
    static String solution(String m, String[] musicinfos) {
        String inputMusic = convertMusic(m);

        Queue<Music> pq = new PriorityQueue<>((o1,o2) -> o2.time - o1.time);
        for (String music : musicinfos) {
            String [] arr = music.split(",");
            //time
            int originTime = getTimeFromString(arr[0], arr[1]);
            int time = originTime;
            String title = arr[2];
            String convertedOriginMusic = convertMusic(arr[3]);
            int originMusicLen = convertedOriginMusic.length();
            String targetMusic = convertedOriginMusic;
            // 더 짧게 들은경우
            if (time < originMusicLen) {
                targetMusic = convertedOriginMusic.substring(0, time);
            }
            // 크거나 같음
            else {
                time -= originMusicLen;
                while (time > originMusicLen) {
                    targetMusic += convertedOriginMusic;
                    time -= originMusicLen;
                }
                targetMusic += convertedOriginMusic.substring(0, time);
            }
            // 일치하는 문자열이 존재한다면
            if (targetMusic.length() > targetMusic.replace(inputMusic,"").length()) {
                pq.add(new Music(originTime, title));
            }
        }
        return pq.isEmpty() ? "(None)" : pq.poll().title;
    }
    static int getTimeFromString(String start, String end) {
        String [] startTime = start.split(":");
        String [] endTime = end.split(":");

        int hour = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60;
        int min = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);

        return hour + min;
    }
    static String convertMusic(String music) {
        String result = music;
        result = result.replace("A#","a");
        result = result.replace("C#","c");
        result = result.replace("D#","d");
        result = result.replace("F#","f");
        result = result.replace("G#","g");
        return result;
    }

}
