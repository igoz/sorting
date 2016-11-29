package ru.mail.polis.sort;

import java.util.Random;

public class ThreeWayQuickSort {
    public static int[] getSortedArray(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        quickSortRandom(arr, 0, arr.length - 1);

        return arr;
    }

    private static void quickSortRandom(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        Random rand = new Random();
        int index = rand.nextInt(right - left + 1) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;
        int k = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < x) {
                j++;
                Helper.swap(arr, i , j);
            } else if (arr[i] == x) {
                k++;
                j++;
                Helper.swap(arr, i, j);
                Helper.swap(arr, k, j);
            }
        }

        int oldJ = j;
        for (int i = left; i <= k; i++) {
            Helper.swap(arr, i, j--);
        }

        quickSortRandom(arr, left, j);
        quickSortRandom(arr, oldJ + 1, right);
    }
//    public static void sort(int[] array, int l, int r) {
//        if (r <= l || r < 0) {
//            return;
//        }
//        int pivot = l + (new Random()).nextInt(r - l + 1);
//        int v = array[pivot];
//        Helper.swap(array, pivot, r);
//        int i = l;
//        int j = r - 1;
//        int p = l - 1;
//        int q = r;
//        while (true) {
//            while (i <= j && array[i] < v) {
//                i += 1;
//            }
//            while (i <= j && array[j] > v) {
//                if (j == l) {
//                    break;
//                }
//                j -= 1;
//            }
//            if (i >= j) {
//                break;
//            }
//            Helper.swap(array, i, j);
//            if (array[i] == v) {
//                p++;
//                Helper.swap(array, p, i);
//            }
//            if (array[j] == v) {
//                q--;
//                Helper.swap(array, q, j);
//            }
//        }
//        Helper.swap(array, i, r);
//        j = i - 1;
//        i++;
//        for (int k = l; k < p; k++, j--) {
//            Helper.swap(array, k, j);
//        }
//        for (int k = r - 1; k > q; k--, i++) {
//            Helper.swap(array, k, i);
//        }
//        sort(array, l, j);
//        sort(array, i, r);
//    }
//
//    public static int[] getSortedArray(int[] array) {
//        sort(array, 0, array.length - 1);
//
//        return array;
//    }
}
