package com.margub.questions;

public class Ch10_9_SortedMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 ||matrix[0].length == 0) {
            return false;
        }
        return binarySearchon2D(matrix, target);
//        return searchWithNaiveApproach(matrix, target);
    }
// undersatnding is enough
    private boolean binarySearchon2D(int[][] matrix, int target) {
        return false;
    }

    private boolean searchWithNaiveApproach(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length -1;
        while (row < matrix.length && col >=0) {
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };


        System.out.println( new Ch10_9_SortedMatrixSearch().searchMatrix(arr, 5));
    }


}
