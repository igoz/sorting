package ru.mail.polis.sort;

import java.util.Random;

public class ThreeWayQuickSort {
    public static void sort(int[] array, int l, int r) {
        if (r <= l || r < 0) {
            return;
        }
        int pivot = l + (new Random()).nextInt(r - l + 1);
        int v = array[pivot];
        Helper.swap(array, pivot, r);
        int i = l;
        int j = r - 1;
        int p = l - 1;
        int q = r;
        while (true) {
            while (i <= j && array[i] < v) {
                i += 1;
            }
            while (i <= j && array[j] > v) {
                if (j == l) {
                    break;
                }
                j -= 1;
            }
            if (i >= j) {
                break;
            }
            Helper.swap(array, i, j);
            if (array[i] == v) {
                p++;
                Helper.swap(array, p, i);
            }
            if (array[j] == v) {
                q--;
                Helper.swap(array, q, j);
            }
        }
        Helper.swap(array, i, r);
        j = i - 1;
        i++;
        for (int k = l; k < p; k++, j--) {
            Helper.swap(array, k, j);
        }
        for (int k = r - 1; k > q; k--, i++) {
            Helper.swap(array, k, i);
        }
        sort(array, l, j);
        sort(array, i, r);
    }

    public static int[] getSortedArray(int[] array) {
        sort(array, 0, array.length - 1);

        return array;
    }
}
