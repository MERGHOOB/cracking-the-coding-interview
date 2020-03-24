package com.margub.questions;

public class Ch10_3_SearchInRotatedArray {


    private int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;


            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {

                if (nums[mid] > nums[right] && // mid is greater than right
                        target <= nums[right]) { // target is less than right
                    left = mid + 1; // left to move to mid+1;
                } else {
                    right = mid - 1;
                }

            } else {
                if (nums[mid] < nums[left] && // mid is smaller than left
                        target >= nums[left]        // target is greater than left
                ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return -1;
    }

    private int searchUsingRecursion(int[] nums, int left, int right, int target) {

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (right < left) {
            return -1;
        }

        /*
        Either left or right normally ordered
         */
        if (nums[left] < nums[mid]) { // left is ordered
            if (target >= nums[left] && target < nums[mid]) {
                return searchUsingRecursion(nums, left, mid - 1, target);
            } else {
                return searchUsingRecursion(nums, mid + 1, right, target);
            }
        } else if (nums[mid] < nums[left]) { // right half is ordered
            if (target > nums[mid] && target <= nums[right]) {
                return searchUsingRecursion(nums, mid + 1, right, target);
            } else {
                return searchUsingRecursion(nums, left, mid - 1, target);
            }
        } else { // left half or right half is all repeats
            if (nums[mid] != nums[right]) { // if right is different, search it
                return searchUsingRecursion(nums, mid + 1, right, target);
            } else { // we have to search both
                int result = searchUsingRecursion(nums, mid + 1, right, target);
                if (result == -1) {
                    return searchUsingRecursion(nums, left, mid - 1, target);
                }
                return result;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {
                15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
        };

        System.out.println(new Ch10_3_SearchInRotatedArray().search(arr, 5));
        System.out.println(new Ch10_3_SearchInRotatedArray().search(arr, 15));
        System.out.println(new Ch10_3_SearchInRotatedArray().searchUsingRecursion(arr, 0, arr.length-1, 14));
    }
}
