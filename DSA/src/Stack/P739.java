package Stack;

import java.util.Arrays;

public class P739 {
    /**
     * Given an array of integers `temperatures` representing daily temperatures,
     * this method returns an array `answer` where `answer[i]` is the number of days
     * you have to wait after the i-th day to get a warmer temperature. If there is
     * no future day for which this is possible, `answer[i]` remains 0.
     *
     * This solution uses a monotonic stack to keep track of the indices of the days
     * for which we haven't found a warmer future day yet.
     *
     * @param temperatures An array of daily temperatures.
     * @return An array where each element is the number of days to wait for a warmer day.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // The stack will store indices of the temperatures array.
        // We use an array and a 'top' pointer to simulate a stack for performance.
        int[] stack = new int[temperatures.length];
        // The answer array to be returned. It's initialized to all 0s by default.
        int[] answer = new int[temperatures.length];
        // 'top' points to the top of the stack. -1 indicates an empty stack.
        int top = -1;

        // Iterate through the temperatures array with the current day's index 'i'.
        for (int i = 0; i < temperatures.length; i++) {
            // Check if the stack is not empty and if the current temperature is warmer
            // than the temperature at the index stored at the top of the stack.
            while (top != -1 && temperatures[stack[top]] < temperatures[i]) {
                // If the current day is warmer, we've found the next warmer day
                // for the day at index stack[top].
                int prevIndex = stack[top];
                // Calculate the difference in days and store it in the answer array.
                answer[prevIndex] = i - prevIndex;
                // Pop the index from the stack since we've processed it.
                top--;
            }
            // Push the current day's index onto the stack. We will look for a
            // warmer day for this index in the subsequent iterations.
            stack[++top] = i;
        }

        // For any indices remaining in the stack, there was no warmer day found.
        // The 'answer' array was initialized with 0s, so these entries are already correct.
        return answer;
    }

    /**
     * The main method to test the dailyTemperatures function.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the P739 class to call its method.
        P739 solution = new P739();

        // Define a sample input array of temperatures.
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        // Call the dailyTemperatures method to get the result.
        int[] result = solution.dailyTemperatures(temperatures);

        // Print the input and output for verification.
        System.out.println("Input Temperatures: " + Arrays.toString(temperatures));
        System.out.println("Days to wait for a warmer day: " + Arrays.toString(result));
    }
}
