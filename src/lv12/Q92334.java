package lv12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Q92334 {
    public static void main(String[] args) {

    }
    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        Map<String, HashSet<String>> reports = new HashMap<>();
        //결괏값을 담기 위한 인덱스
        Map<String,Integer> memberIdx = new HashMap<>();

        int listSize = id_list.length;
        for(int i = 0; i < listSize; i++)
        {
            memberIdx.put(id_list[i],i);
            reports.put(id_list[i],new HashSet<>());
        }

        for(String reportInfo : report)
        {
            StringTokenizer st = new StringTokenizer(reportInfo);
            String reportFrom = st.nextToken();
            String reportTo = st.nextToken();

            // 신고한 멤버 이름 추가 , HashSet으로 중복신고 제외
            reports.get(reportTo).add(reportFrom);
        }

        answer = new int[listSize];

        for(String key : reports.keySet())
        {
            HashSet<String> set = reports.get(key);
            //누적 신고횟수가 k 이상일 경우
            if(set.size() >= k)
            {
                // 신고한 멤버의 카운트++
                for(String member : set) answer[memberIdx.get(member)]++;
            }
        }
        return answer;
    }
}
