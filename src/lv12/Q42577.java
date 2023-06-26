package lv12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q42577 {
    public static void main(String[] args) { }
    static boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        loop: for (String phone: phone_book) {
            int length = phone.length();
            for (int i = 1; i < length; i++) {
                if (set.contains(phone.substring(0, i))) {
                    answer = false;
                    break loop;
                }
            }
        }
        return answer;
    }
}
