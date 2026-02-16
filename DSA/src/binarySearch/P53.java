package binarySearch;

public class P53 {
        /* “I use Kadane’s Algorithm.
        I keep a running sum of the current subarray.
        If the sum becomes negative, I reset it because a negative sum would reduce any future subarray.
        I track the maximum sum seen so far.” */
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int rslt = Integer.MIN_VALUE;
            for (int x : nums) {
                sum += x;
                rslt = Math.max(rslt, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return rslt;
        }
        public static void main (int[] args){
            P53 p=new P53();
            System.out.println("max sum of subarray is :"+p.maxSubArray(new int[]{-2,1,-3,4,-1,2}));
        }
}
