package binarySearch;

public class P34 {
    /**
     * Problem: Find First and Last Position of Element in Sorted Array (LeetCode 34)
     *
     * Algorithm:
     * Since the array is sorted, we can use Binary Search to find the target.
     * However, simply finding the target is not enough; we need the starting and ending positions.
     * We can achieve this by running Binary Search twice:
     *
     * 1. First Binary Search (leftB):
     *    - The goal is to find the *first* occurrence of the target (left boundary).
     *    - When we find `nums[mid] == target`, we don't stop. Instead, we continue searching
     *      in the left half (by setting `r = mid - 1`) to see if there is an earlier occurrence.
     *
     * 2. Second Binary Search (rightB):
     *    - The goal is to find the *last* occurrence of the target (right boundary).
     *    - When we find `nums[mid] == target`, we don't stop. Instead, we continue searching
     *      in the right half (by setting `l = mid + 1`) to see if there is a later occurrence.
     *
     * Time Complexity: O(log n) - We perform two binary searches.
     * Space Complexity: O(1) - We use constant extra space.
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        // Find the first occurrence
        int first = leftB(nums, target);
        // If the target is not found at all, leftB returns -1.
        // In that case, we can immediately return {-1, -1}.
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        // Find the last occurrence
        int last = rightB(nums, target);
        
        return new int[] { first, last };
    }

    /**
     * Finds the first occurrence (left boundary) of the target.
     */
    private int leftB(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                // If we found the target or a larger value, try to find the target in the left half
                r = mid - 1;
            } else {
                // If the value is smaller than target, search in the right half
                l = mid + 1;
            }
        }
        // After the loop, 'l' points to the first element >= target.
        // Check if 'l' is within bounds and actually equals the target.
        if (l < nums.length && nums[l] == target) {
            return l;
        }
        return -1;
    }

    /**
     * Finds the last occurrence (right boundary) of the target.
     */
    private int rightB(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                // If we found the target or a smaller value, try to find the target in the right half
                l = mid + 1;
            } else {
                // If the value is larger than target, search in the left half
                r = mid - 1;
            }
        }
        // After the loop, 'r' points to the last element <= target.
        // Check if 'r' is within bounds and actually equals the target.
        if (r >= 0 && nums[r] == target) {
            return r;
        }
        return -1;
    }

    public static void main(String[] args) {
        P34 p = new P34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = p.searchRange(nums, target);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
