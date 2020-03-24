package com.margub.chap10;

import java.util.Arrays;

/*

select a pivot and partition array such that all numbers less than partitioning element come before element all that are greater than it.

Key: Partitioning
which can be performed efficiently with a series of swap


 */
public class QuickSort {


    void quickSort(int[] arr, int left, int right) {

        int index = partition(arr, left, right);

        if (left < index - 1) { // sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }

    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            //Find element on the left that should be on right
            while (arr[left] < pivot) {
                left++;
            }
            //Find element on the right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swapElements(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        printArray(arr);

        int[] arr1 = {8, 7, 6, 5, 4, 3, 2, 1};
        new QuickSort().quickSort(arr1, 0, arr1.length - 1);
        printArray(arr1);


        int[] arr2 = {8};
        new QuickSort().quickSort(arr2, 0, arr2.length - 1);
        printArray(arr2);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
