package binarySearch;

public class P240 {
    /** Question is-----:
     * Searches for a target value in an m x n integer matrix.
     * The matrix has the following properties:
     * - Integers in each row are sorted in ascending from left to right.
     * - Integers in each column are sorted in ascending from top to bottom.
     *
     * Algorithm i use.....:
     * 1. Start from the top-right corner of the matrix.
     * 2. If the current element equals the target, return true.
     * 3. If the current element is greater than the target, move left (decrement column).
     *    This is because all elements below the current one in the same column are also greater than the target.
     * 4. If the current element is less than the target, move down (increment row).
     *    This is because all elements to the left of the current one in the same row are also smaller than the target.
     * 5. Repeat until the target is found or the indices go out of bounds.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int current = matrix[row][column];
            if (target == current) {
                return true;
            } else if (current > target) {
                column -= 1;
            } else {
                row += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;
        P240 p = new P240();
        System.out.println("Target found: " + p.searchMatrix(matrix, target));
    }
}
