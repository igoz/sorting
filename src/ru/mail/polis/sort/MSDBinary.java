package ru.mail.polis.sort;

public class MSDBinary {
    private static final int MAX_DIGIT = 20;
    static int[] array = {4, 3, 2, 1};

    private static int digit(int num, int idx) {
        return (num >> (MAX_DIGIT - idx)) & 1;
    }

    public static void msdSort(int[] array, int[] res, int left, int right, int r) {
        if (r > MAX_DIGIT || left >= right) return;
        int[] count = new int[3];
        for (int i = left; i <= right; i++) {
            count[digit(array[i], r)]++;
        }
        for (int i = 1; i < 3; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            count[digit(array[i], r)] -= 1;
            res[left + count[digit(array[i], r)]] = array[i];
        }
        System.arraycopy(res, left, array, left, right - left + 1);
        for (int i = 0; i < 2; i++) {
            msdSort(array, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }

    public static int[] sort(int[] array) {
        int[] res = new int[array.length];
        msdSort(array, res, 0, array.length - 1, 0);
        return res;
    }
}
