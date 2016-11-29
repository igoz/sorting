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

    public static void swapLongs(long[] a, int i, int j) {
        long x = a[i];
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

    public static long[] genLongs(int n) {
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swapLongs(a, i, j);
        }

        return a;
    }

    public static int[] genReverse(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i;
        }

        return result;
    }

    public static int[] genSorted(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }

        return result;
    }
    public static int[] genBadForQuickSort(int size) {
        int N = size;
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;

        if (N == 2) {
            arr[0] = 2;
            arr[1] = 1;
            return arr;
        } else if(N == 1) {
            arr[0] = 1;
            return arr;
        }

        int right = 2;
        for (int i = 4; i <= N; i++) {
            int mid = (right + 1) / 2;
            arr[right + 1] = i;
            swap(arr, mid, right + 1);
            right++;
        }
        return arr;
    }

    public static int[] genIncreasing(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = i;
        }
        return result;
    }

    public static int[] genDecreasing(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = n - i;
        }
        return result;
    }

    public static int[] genSawtooh(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; i += 5) {
            result[i] = 0;
            result[i + 1] = 1;
            result[i + 2] = 2;
            result[i + 3] = 3;
            result[i + 4] = 4;
        }
        return result;
    }

    public static int[] genMaxMix(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            if (i <= n / 2) {
                result[i] = Integer.MAX_VALUE;
            } else {
                result[i] = Integer.MIN_VALUE;
            }
        }

        return result;
    }

    public static int[] genStagger(int n, int m) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = m * (i + 1) % n;
        }

        return  result;
    }

    public static int[] genPlateau(int n, int m) {
        int[] result = new int[n];
        for (int i = 0; i < m; i++) {
            result[i] = m;
        }
        for (int i = m; i < n; i++) {
            result[i] = r.nextInt(i + 1);
        }

        return  result;
    }

    public static String[] genStrings(int count, int n) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String[] result = new String[count];

        for (int i = 0; i != count; ++i) {
            StringBuilder str = new StringBuilder();
            int size = rand.nextInt(n) + 1;
            for (int j = 0; j != size; ++j) {
                int pos = rand.nextInt(alphabet.length());
                str.append(alphabet.charAt(pos));
            }
            result[i] = str.toString();
        }
        return result;
    }
}
