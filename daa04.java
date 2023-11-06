// Write a program to solve a 0/1 Knapsack using Branch and Bound or dynamic
// programming.


public class KnapsackDP {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        int maxProfit = knapsack(values, weights, capacity);
        System.out.println("Maximum profit: " + maxProfit);
    }
}


// Time Complexity: O(n * capacity)

// Here, 'n' is the number of items, and 'capacity' is the maximum capacity of the knapsack.
// The nested loops iterate over 'n' items and 'capacity' values.
// Each iteration involves constant-time operations, such as comparisons and value calculations.


// Space Complexity: O(n * capacity)

// The space complexity is determined by the 2D array dp used for dynamic programming.
// The array has dimensions (n+1) x (capacity+1), where 'n' is the number of items and 'capacity' is the maximum knapsack capacity.
// Therefore, the space complexity is O(n * capacity).