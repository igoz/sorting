package ru.mail.polis.sort;

public class QuickSort {
    public static int partition(int[] array, int l, int r) {
        int v = array[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (array[i] < v) {
                i++;
            }
            while (array[j] > v) {
                j--;
            }
            if (i <= j) {
                Helper.swap(array, i++, j--);
            }
        }

        return i;
    }

    public static void sort(int[] array, int l, int r) {
        if (l < r) {
            int q = partition(array, l, r);
            if (l < q - 1) {
                sort(array, l, q - 1);
            }
            if (q < r) {
                sort(array, q, r);
            }
        }
    }

    public static int[] getSortedArray(int[] array) {
        sort(array, 0, array.length - 1);

        return array;
    }
}
