package com.iderserve;

public class FindPeakElement {

    /*
    //peak element is which has smaller in both sides.
    //Corner case last element is peak if second-last is smaller
    // first element is peak if second is smaller

    8 4 6 7 8 9 2 4 6

    : 8,6,9 are peak elements

    We need to find just 1.

    That con be done with linear search o(n)

    is there any better way? ( YES)
    take any element: pick 2: both side a bigger element is present: 2->4->6 ( 6 is peak) and on right side 2->9 is peak
    take another example: pick 6: 7 is bigger element to right: 7-8-9->2 which means 9 is peak element
    even if we go to left: we can have 8 is peak but what if 8 is not present there, then no peak on left side of 6

    with above a pattern emerges: for any e -> if left(e) > e then there must be a peak element on left side of e and same for right side

    so we can actually use binary search with above mentioned condition and then search will o(logn).

    */


    public int findPeakElement(int[] arr) {
        return findPeakElement(arr, 0, arr.length - 1);
    }

    private int findPeakElement(int[] arr, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPeak(arr, mid)) {
                return mid;
            }
            if (mid >= 1 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            else if (mid < (arr.length - 1) && arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] arr, int mid) {
        int left = mid - 1;
        int right = mid + 1;

        boolean isPeak = true;
        if (left >= 0) {
            isPeak = arr[mid] > arr[left];
        }
        if (right < arr.length) {
            isPeak = isPeak && (arr[mid] > arr[right]);
        }

        return isPeak;
    }

    public static void main(String[] args) {
        int[] arr = {50, 1, 6, 3, 8, 9, 34};
        int peakElement = new FindPeakElement().findPeakElement(arr);
        if (peakElement != -1) {
            System.out.println(arr[peakElement]);
        }
    }
}
