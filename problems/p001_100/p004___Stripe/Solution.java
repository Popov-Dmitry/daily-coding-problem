package p001_100.p004___Stripe;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Integer[] array1 = { 3, 4, -1, 1 };
        Integer[] array2 = { 11, 12, 0, 15, -4, 4, 3, 2, 1 };
        System.out.println(solution1(array1));
        System.out.println(solution1(array2));
        System.out.println(solution2(array1));
        System.out.println(solution2(array2));
    }

    public static int solution1(Integer[] array) {
        if (array == null) {
            return 1;
        }
        if (array.length < 2) {
            if (array.length == 0) {
                return 1;
            }
            if (array[0] != 1) {
                return 1;
            }
            return 2;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 1) {
                continue;
            }
            if (array[i] < array.length) {
                int tmp = array[array[i] - 1];
                array[array[i] - 1] = array[i];
                array[i] = tmp;
            }
        }
        if (array[0] > 1) {
            return 1;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] > 1 || array[i + 1] < 1 || array[i + 1] > array.length) {
                return array[i] + 1;
            }
        }

        return array[array.length - 1] + 1;
    }

    public static int solution2(Integer[] array) {
        if (array == null) {
            return 1;
        }
        if (array.length < 2) {
            if (array.length == 0) {
                return 1;
            }
            if (array[0] != 1) {
                return 1;
            }
            return 2;
        }

        Set<Integer> set = Stream.of(array).collect(Collectors.toSet());

        for (int i = 1; i < set.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return set.size() + 1;
    }
}
