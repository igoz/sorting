package ru.mail.polis.sort;

public class LSDLong {
    private final static int MAX_BYTE = 8;

    private static int digit(long num, int idxByte) {
        return (int)(num >> ((MAX_BYTE - idxByte) * 0x8)) & 0xFF;
    }

    public static void lsdSort(long[] array, long[] res) {
        final int r = 256;
        int d = MAX_BYTE + 1;
        for (int k = 0; k < d; k++) {
            int[] count = new int[r];
            for (long x : array) count[digit(x, k)]++;
            for (int i = 1; i < r; i++) {
                count[i] += count[i - 1];
            }
            for (int i = array.length - 1; i >= 0; i--) {
                res[--count[digit(array[i], k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, array.length);
        }
    }

    public static long[] sort(long[] array) {
        long[] res = new long[array.length];
        lsdSort(array, res);

        return res;
    }
}
