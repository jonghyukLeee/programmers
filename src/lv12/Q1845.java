package lv12;

import java.util.HashSet;
import java.util.Set;

public class Q1845 {
    public static void main(String[] args) {

    }
    static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int numsSize = nums.length;

        for (int n : nums) {
            set.add(n);
        }

        return Math.min(set.size(), numsSize / 2);
    }
}
