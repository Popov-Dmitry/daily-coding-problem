package p001_100.p001___Google;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 3, 12, 4, 8, 2};
        System.out.println(solution1(array, 5));
        System.out.println(solution2(array, 5));
    }

    public static boolean solution1(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solution2(int[] array, int k) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (set.contains(value - k)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }
}
