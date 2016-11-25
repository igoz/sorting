package ru.mail.polis.sort;

public class InsertionSort {
    public static int[] sort(int[] array) {
        int size = array.length;
        boolean wasSwapped = false;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                Helper.swap(array, j, j - 1);
                wasSwapped = true;
            }
            wasSwapped = false;
        }

        return array;
    }
}
