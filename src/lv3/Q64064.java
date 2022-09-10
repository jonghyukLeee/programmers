package lv3;

import java.util.*;
import java.util.regex.Pattern;

public class Q64064 {
    static int bannedLen;
    static List<String> [] list;
    static Set<String> resultSet;
    static int solution(String[] user_id, String[] banned_id) {
        bannedLen = banned_id.length;
        list = new List[bannedLen];
        resultSet = new HashSet<>();
        for (int i = 0; i < bannedLen; i++) {
            list[i] = new ArrayList<>();
            String pattern = banned_id[i].replace("*",".");
            for (String userId : user_id) {
                if (Pattern.matches(pattern, userId)) {
                    list[i].add(userId);
                }
            }
        }

        comb(0, new TreeSet<>());
        return resultSet.size();
    }
    static void comb(int idx, TreeSet<String> set) {
        if (set.size() == bannedLen) {
            StringBuilder sb = new StringBuilder();
            for (String id : set) {
                sb.append(id);
            }
            resultSet.add(sb.toString());
            return;
        }

        if (idx >= bannedLen) return;

        for (String id : list[idx]) {
            if (!set.contains(id)) {
                TreeSet<String> tmpSet = new TreeSet<>(set);
                tmpSet.add(id);
                comb(idx + 1, tmpSet);
            }
        }
    }
}
