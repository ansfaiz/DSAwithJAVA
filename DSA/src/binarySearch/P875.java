package binarySearch;

public class P875 {
    /**
     * Problem: Koko Eating Bananas
     *
     * Algorithm: Binary Search on Answer
     *
     * 1. The eating speed 'k' can range from 1 to the maximum pile size.
     *    - Lower bound (l) = 1
     *    - Upper bound (r) = max(piles)
     *
     * 2. We perform a binary search on this range [l, r] to find the minimum 'k'.
     *
     * 3. In each step of binary search:
     *    - Calculate mid = l + (r - l) / 2.
     *    - Check if Koko can eat all bananas within 'h' hours at speed 'mid'.
     *
     * 4. If she can eat all bananas at speed 'mid':
     *    - This speed is valid, but we want the *minimum* speed.
     *    - So, we try smaller speeds: r = mid.
     *
     * 5. If she cannot eat all bananas at speed 'mid':
     *    - The speed is too slow.
     *    - We need to increase the speed: l = mid + 1.
     *
     * 6. The loop terminates when l == r, which gives the minimum eating speed.
     *
     * Time Complexity: O(N * log(M)), where N is the number of piles and M is the maximum pile size.
     * Space Complexity: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        // Find the maximum pile size to set the upper bound of the search space
        for (int x : piles) {
            r = Math.max(r, x);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canEat(piles, mid, h)) {
                // If possible to eat within h hours, try a smaller speed
                r = mid;
            } else {
                // If not possible, need a faster speed
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * Helper function to check if it's possible to eat all bananas
     * within 'h' hours at a given speed 'k'.
     */
    private boolean canEat(int[] nums, int k, int h) {
        int actualhr = 0;
        for (int x : nums) {
            actualhr += x / k;
            if (x % k != 0) {
                actualhr += 1;
            }
        }
        return actualhr <= h;
    }

    public static void main(String[] args) {
        P875 p = new P875();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Minimum eating speed per hour is: " + p.minEatingSpeed(piles, h));
    }
}
