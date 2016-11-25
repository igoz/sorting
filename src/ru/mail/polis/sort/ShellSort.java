package ru.mail.polis.sort;

public class ShellSort {
    public static int[] sort(int[] array) {
        int increment = array.length / 2;
        while (increment > 0) {
            for (int i = increment; i < array.length; i++) {
                int j = i;
                int tmp = array[i];
                while (j >= increment && array[j - increment] > tmp) {
                    array[j] = array[j - increment];
                    j = j - increment;
                }
                array[j] = tmp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }

        return array;
    }
}
