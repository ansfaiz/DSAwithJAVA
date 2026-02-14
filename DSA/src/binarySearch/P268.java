package binarySearch;

public class P268 {
    /**
     * Approach 1: Arithmetic Sum
     *
     * Algorithm:
     * 1. Calculate the expected sum of the first n integers using the formula: sum = n * (n + 1) / 2.
     * 2. Calculate the actual sum of the elements in the given array.
     * 3. The difference between the expected sum and the actual sum is the missing number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return totalSum - sum;
    }

    /**
     * Approach 2: Bit Manipulation (XOR)
     *
     * Algorithm:
     * 1. Initialize a variable `xor` to 0.
     * 2. XOR all numbers in the range [0, n].
     * 3. XOR all elements present in the array.
     * 4. Due to the property a ^ a = 0 and a ^ 0 = a, all numbers present in both the range and the array will cancel out.
     * 5. The remaining value in `xor` will be the missing number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumberByXor(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR with all elements in the array
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] num = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        P268 p = new P268();
        System.out.println("Missing number (Sum): " + p.missingNumber(num));
        System.out.println("Missing number (XOR): " + p.missingNumberByXor(num));
    }
}
