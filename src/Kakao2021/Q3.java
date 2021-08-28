package Kakao2021;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Q3 {
    static HashMap<String, ArrayList<Integer>> map;
    public static void main(String[] args) {
        String [] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100","- and - and - and - 150"};
        for(int i : solution(info,query)) System.out.print(i+" ");
    }
    static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        for(String in : info)
        {
            String [] infoArr = in.split(" ");
            comb("",0,infoArr);
        }

        for(String key : map.keySet()) Collections.sort(map.get(key));
        int queryIdx = 0;
        for(String q : query)
        {
            String str = q.replace(" and ","");
            String [] tmp = str.split(" ");
            answer[queryIdx++] = binarySearch(tmp[0],Integer.parseInt(tmp[1]));
        }
        return answer;
    }
    static void comb(String str,int depth,String [] arr) {
        if (depth == 4) {
            int score = Integer.parseInt(arr[4]);
            if (map.containsKey(str)) map.get(str).add(score);
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                map.put(str, tmp);
            }
            return;
        }

        comb(str + "-", depth + 1, arr);
        comb(str + arr[depth], depth + 1, arr);
    }

    static int binarySearch(String query, int score)
    {
        if(!map.containsKey(query)) return 0;
        ArrayList<Integer> tmpList = map.get(query);
        int start = 0, end = tmpList.size()-1;
        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(score > tmpList.get(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return tmpList.size() - start;
    }
}
