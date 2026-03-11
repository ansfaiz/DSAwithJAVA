package sliding;

public class p1652 {
    /**
     * Problem: Decrypt String at Index (LeetCode 1652)
     *
     * What we need to do:
     * Given a circular array `code` and an integer `k`, we need to replace each element `code[i]`
     * with the sum of `k` adjacent elements.
     * - If `k > 0`, we sum the *next* `k` elements.
     * - If `k < 0`, we sum the *previous* `k` elements (using the absolute value of `k`).
     * - If `k = 0`, all elements in the result should be 0.
     *
     * Algorithm (Sliding Window):
     * This problem is efficiently solved using a sliding window.
     *
     * 1.  **Handle `k = 0`:** If `k` is zero, the result array will simply be all zeros.
     *     The result array is initialized with zeros, so this case is implicitly handled by returning the initialized array.
     *
     * 2.  **Handle `k > 0` (Sum of Next `k` Elements):**
     *     - First, calculate the sum for `rslt[0]` by summing `code[1]` through `code[k]`.
     *     - Then, for each subsequent element `rslt[i]`, slide the window:
     *       - Subtract the element that just left the window (`code[i]`).
     *       - Add the new element entering the window (`code[(i + k) % n]`).
     *       - The modulo operator (`% n`) handles the circular nature of the array.
     *
     * 3.  **Handle `k < 0` (Sum of Previous `k` Elements):**
     *     - Convert `k` to its absolute value.
     *     - First, calculate the sum for `rslt[0]` by summing `code[n - abs(k)]` through `code[n - 1]`.
     *     - Then, for each subsequent element `rslt[i]`, slide the window:
     *       - Subtract the element that just left the window (`code[(i - 1 + n - abs(k)) % n]`).
     *       - Add the new element entering the window (`code[(i - 1 + n) % n]`).
     *       - The `(index + n) % n` pattern ensures correct positive indices for circular access.
     *
     * Time Complexity: O(N) - We iterate through the array a constant number of times.
     * Space Complexity: O(N) - For the result array.
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] rslt = new int[n];

        if (k == 0) {
            return rslt; // Already initialized to zeros
        }

        if (k > 0) {
            int sum = 0;
            // Calculate initial sum for rslt[0]
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            rslt[0] = sum;

            // Slide window for remaining elements
            for (int i = 1; i < n; i++) {
                sum -= code[i]; // Element leaving the window
                sum += code[(i + k) % n]; // Element entering the window
                rslt[i] = sum;
            }
        } else { // k < 0
            int sum = 0;
            k = Math.abs(k); // Use absolute value for window size

            // Calculate initial sum for rslt[0]
            // Sum elements from (n - k) to (n - 1)
            for (int i = n - k; i < n; i++) {
                sum += code[i];
            }
            rslt[0] = sum;

            // Slide window for remaining elements
            for (int i = 1; i < n; i++) {
                // Element leaving the window: (i - 1) - k. Handle circularity.
                sum -= code[(i - 1 + n - k) % n];
                // Element entering the window: (i - 1). Handle circularity.
                sum += code[(i - 1 + n) % n];
                rslt[i] = sum;
            }
        }
        return rslt;
    }

    public static void main(String[] args) {
        p1652 solver = new p1652();

        // Helper to print arrays
        java.util.function.BiConsumer<String, int[]> printArray = (label, arr) -> {
            System.out.print(label + ": [");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
            }
            System.out.println("]");
        };

        // Test Case 1: k > 0
        int[] code1 = {5, 7, 1, 4};
        int k1 = 3;
        int[] result1 = solver.decrypt(code1, k1);
        printArray.accept("Code: [5, 7, 1, 4], k = 3 -> Result", result1); // Expected: [12, 10, 16, 13]

        // Test Case 2: k < 0
        int[] code2 = {2, 4, 9, 3};
        int k2 = -2;
        int[] result2 = solver.decrypt(code2, k2);
        printArray.accept("Code: [2, 4, 9, 3], k = -2 -> Result", result2); // Expected: [12, 5, 6, 13]

        // Test Case 3: k = 0
        int[] code3 = {1, 2, 3, 4};
        int k3 = 0;
        int[] result3 = solver.decrypt(code3, k3);
        printArray.accept("Code: [1, 2, 3, 4], k = 0 -> Result", result3); // Expected: [0, 0, 0, 0]

        // Test Case 4: Another k > 0
        int[] code4 = {1, 2, 3, 4, 5};
        int k4 = 2;
        int[] result4 = solver.decrypt(code4, k4);
        printArray.accept("Code: [1, 2, 3, 4, 5], k = 2 -> Result", result4); // Expected: [5, 7, 9, 6, 3]
    }
}
