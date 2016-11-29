package ru.mail.polis.sort;

public class QuickSortBinary {
    private static final int MAX_DISCHARGE = 22;

    private static int digit(int num, int idx) {
        return (num >> (MAX_DISCHARGE - idx)) & 1;
    }

    private static void qSort(int[] array, int l, int r, int d) {
        int i = l, j = r;
        if (d > MAX_DISCHARGE || l >= r) {
            return;
        }
        while (j != i) {
            while (i < j && digit(array[i], d) == 0) {
                i += 1;
            }
            while (i < j && digit(array[j], d) == 1) {
                j -= 1;
            }
            Helper.swap(array, i, j);
        }
        if (digit(array[r], d) == 0) {
            j += 1;
        }
        qSort(array, l, j - 1, d + 1);
        qSort(array, j, r, d + 1);
    }

    public static int[] sort(int[] array) {
        qSort(array, 0, array.length - 1, 0);

        return array;
    }
}
