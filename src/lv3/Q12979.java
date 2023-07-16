package lv3;

public class Q12979 {
    public static void main(String[] args) {
    }
    static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        for (int station: stations) {
            if (start < station - w) {
                answer += getStationCount(start, station - w, w);
            }
            start = station + w + 1;
        }

        if (start <= n) {
            answer += getStationCount(start, n + 1, w);
        }
        return answer;
    }

    static int getStationCount(int start, int end, int w) {
        int notConnectedSize = end - start;

        int stationCount = notConnectedSize / ((w * 2) + 1);
        int remain = notConnectedSize % ((w * 2) + 1);
        stationCount = remain > 0 ? stationCount + 1 : stationCount;

        return stationCount;
    }

}
