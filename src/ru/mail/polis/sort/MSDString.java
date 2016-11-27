package ru.mail.polis.sort;

public class MSDString {
    private static final int MAX_DIGIT = 256;

    private static int character(String string, int idx) {
        return idx < string.length() ? string.charAt(idx) : 0;
    }

    public static void msdSort(String[] array, String[] res, int left, int right, int r) {
        if (r > MAX_DIGIT || left >= right) return;
        int[] count = new int[257];
        for (int i = left; i <= right; i++) {
            count[character(array[i], r)]++;
        }
        for (int i = 1; i < 257; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            count[character(array[i], r)] -= 1;
            res[left + count[character(array[i], r)]] = array[i];
        }
        System.arraycopy(res, left, array, left, right - left + 1);
        for (int i = 0; i < 256; i++) {
            msdSort(array, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }

    public static String[] sort(String[] array) {
        String[] res = new String[array.length];
        msdSort(array, res, 0, array.length - 1, 0);
        return res;
    }
}
