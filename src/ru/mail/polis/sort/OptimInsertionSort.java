package ru.mail.polis.sort;

public class OptimInsertionSort {
    public static int[] sort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int k = Helper.binSearch(array, array[i], 0, j);
            for (int l = j; l >= k; l--) {
                if (k != - 1) {
                    Helper.swap(array, l, l + 1);
                }
            }
        }

        return array;
    }
}
