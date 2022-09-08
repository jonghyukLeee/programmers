package skillcheck.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        System.out.print(solution("FRANCE","french"));
    }
    static int solution(String str1, String str2) {
        char [] str1Arr = str1.toUpperCase().toCharArray();
        char [] str2Arr = str2.toUpperCase().toCharArray();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        comb(str1Arr, map1);
        comb(str2Arr, map2);

        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }

        double intersection = 0;
        double union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
                map2.remove(key);
            }
            else union += map1.get(key);
        }

        for (String key : map2.keySet()) {
            union += map2.get(key);
        }

        return (int)Math.floor((intersection / union) * 65536);
    }
    static void comb(char [] arr, Map<String, Integer> map) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            char left = arr[i];
            char right = arr[i + 1];

            if (bothAlpha(left, right)) {
                String tmp = left + "" + right;
                map.put(tmp, map.getOrDefault(tmp , 0) + 1);
            }
        }
    }
    static boolean bothAlpha(char l, char r) {
        return r >= 65 && l >= 65 && l <= 90 && r <= 90;
    }
}
