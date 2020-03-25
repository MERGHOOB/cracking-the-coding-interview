package com.margub.questions;

/*
input: {"at", "", "", "", "ball", "", "", "car", "", "", "dad","" }
target: "ball"

Given a sorted array of strings interspersed with empty  strings,

 */
public class Ch10_4_SparseSearch {


    public static void main(String[] args) {

        String [] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad","" };

        System.out.println(new Ch10_4_SparseSearch().search(input, "ball"));
    }

    private int search(String[] input, String target) {

        if(input.length < 1) {
            return -1;
        }

        int left = 0;
        while(left < input.length && input[left].isEmpty()) {
            left++;
        }

        int right = input.length-1;
        while(right >=0 && input[right].isEmpty()) {
            right--;
        }


        while(left <= right) {

            int mid = (left + right)/2;

            while (input[mid].isEmpty()) {
                mid++;
            }

            if(input[mid].equals(target)) {
                return mid;
            }
            else {
                if(input[mid].compareTo(target) < 0) {
                    mid +=1;
                    while(input[mid].isEmpty()) {
                        mid++;
                    }
                    left = mid;
                }
                else {
                    mid -=1;
                    while(input[mid].isEmpty()) {
                        mid--;
                    }
                    right = mid;
                }
            }
        }

        return -1;
    }
}
