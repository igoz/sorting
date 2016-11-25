package ru.mail.polis.sort;

public class MergeSort {
    public static void merge(int[] array, int left, int mid, int right) {
    int it1 = 0;
    int it2 = 0;
    int[] result = new int[right - left];

    while ((left + it1 < mid) && (mid + it2 < right)) {
        if (array[left + it1] <= array[mid + it2]) {
            result[it1 + it2] = array[left + it1];
            it1++;
        } else {
            result[it1 + it2] = array[mid + it2];
            it2++;
        }
    }

    while (left + it1 < mid) {
        result[it1 + it2] = array[left + it1];
        it1++;
    }

    while (mid + it2 < right) {
        result[it1 + it2] = array[mid + it2];
        it2++;
    }

    for (int i = 0; i < it1 + it2; i++) {
        array[left + i] = result[i];
    }
}

    public static int[] sort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i *= 2) {
            for (int j = 0; j < size - i; j += 2 * i) {
                merge(array, j, j + i, Math.min(j + 2 * i, size));
            }
        }

        return array;
    }
}
