package p001_100.p009___Airbnb;

public class Solution {
    public static void main(String[] args) {
        int[] array1 = {2, 4, 6, 2, 5};
        int[] array2 = {5, 1, 1, 5};
        System.out.println(solution(array1));
        System.out.println(solution(array2));
    }

    public static int solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 3) {
                answer += Math.max(array[i] + array[i + 2], array[i + 1]);
                break;
            }
            if (i == array.length - 2) {
                answer += Math.max(array[i], array[i + 1]);
                break;
            }
            if (i == array.length - 1) {
                answer += array[i];
                break;
            }

            if (Math.max(array[i] + array[i + 2], array[i + 1] + array[i + 3]) >= array[i] + array[i + 3]) {
                if (array[i] + array[i + 2] > array[i + 1] + array[i + 3]) {
                    answer += array[i] + array[i + 2];
                    i += 3;
                }
                else {
                    answer += array[i + 1] + array[i + 3];
                    i += 4;
                }
            }
            else {
                answer += array[i] + array[i + 3];
                i += 4;
            }
        }

        return answer;
    }

}
