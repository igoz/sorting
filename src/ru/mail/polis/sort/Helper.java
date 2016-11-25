package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int binSearch(int[] array, int key, int start, int end) {
        int l = start;
        int r = end;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (array[m] < key) {
                l = m;
            } else if (array[m] == key) {
                return m;
            } else {
                r = m;
            }
        }
        if (array[l] > key) {
            return l;
        }
        if (array[r] < key){
            return -1;
        }

        return r;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }
}
