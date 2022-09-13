package lv3;

import java.util.*;

public class Q43164 {
    static Map<String, List<String>> map;
    static Map<String, Integer> ticketCount;
    static String resultString;
    static int resultSize;
    static boolean isDone;
    public static void main(String[] args) {
        //String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String [][] tickets ={{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        //String[][] tickets = {{"ICN", "ATL"}, {"ICN", "SFO"}, {"SFO", "UFO"}};

        for (String t : solution(tickets)) {
            System.out.println(t);
        }
    }

    static String[] solution(String[][] tickets) {
        String[] answer;
        map = new HashMap<>();
        ticketCount = new HashMap<>();

        resultSize = tickets.length;

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            String sum = from.concat(to);
            ticketCount.put(sum, ticketCount.getOrDefault(sum, 0) + 1);

            List<String> list = new ArrayList<>();
            if (map.containsKey(from)) {
                list = map.get(from);
            }
            list.add(to);
            map.put(from, list);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        dfs("ICN", "ICN", 1);

        answer = resultString.split(" ");
        return answer;
    }
    static void dfs(String from, String result, int resultCount) {
        if (!isDone) {
            if (resultCount == resultSize + 1) {
                resultString = result;
                isDone = true;
                return;
            }

            if (map.containsKey(from)) {
                List<String> getDest = map.get(from);
                for (String to : getDest) {
                    String ticket = from.concat(to);
                    int curCount = ticketCount.get(ticket);
                    if (curCount > 0) {
                        ticketCount.put(ticket, curCount - 1);
                        dfs(to, result + " " + to, resultCount + 1);
                        ticketCount.put(ticket, curCount);
                    }
                }
            }
        }
    }
}