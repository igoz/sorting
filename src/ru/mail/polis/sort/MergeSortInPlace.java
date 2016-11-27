package ru.mail.polis.sort;

public class MergeSortInPlace {
    static void mergeSort(int[] array, int min, int max){
        if(max - min == 0){
        } else if (max - min == 1) {
            if(array[min] > array[max])
                Helper.swap(array, min, max);
        } else {
            int mid=((int) Math.floor((min + max) / 2));

            mergeSort(array, min, mid);
            mergeSort(array, mid + 1, max);
            merge(array, min, max, mid);
        }
    }

    static void merge(int[] array, int min, int max, int mid) {
        int i = min;
        while(i <= mid) {
            if(array[i] > array[mid + 1]) {
                Helper.swap(array, i, mid + 1);
                push(array, mid + 1, max);
            }
            i++;
        }
    }

    static void push(int[] array, int s, int e){
        for(int i = s; i < e; i++){
            if(array[i] > array[i + 1])
                Helper.swap(array, i, i + 1);
        }
    }

    static int[] sort(int[] array) {
        mergeSort(array, 0, array.length - 1);

        return array;
    }
}
