package p001_100.p002___Uber;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution1(array)));
        System.out.println(Arrays.toString(solution2(array)));
        System.out.println(Arrays.toString(solution3(array)));
    }

    public static int[] solution1(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int[] result = new int[array.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    result[i] *= array[j];
                }
            }
        }
        return result;
    }

    public static int[] solution2(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int product = Arrays.stream(array).reduce((x ,y) -> x * y).getAsInt();
        array = Arrays.stream(array).map(x -> product / x).toArray();
        return array;
    }

    public static int[] solution3(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int product = 1;

        for (int value : array) {
            product *= value;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = product / array[i];
        }

        return array;
    }
}
