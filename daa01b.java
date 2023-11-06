public class Fibonacci {
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
    
    public static void main(String[] args) {
        int n = 10; // Change this to the desired Fibonacci number you want to calculate.
        long result = calculateFibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}
// Time Complexity (Recursive): O(2^n)
// Space Complexity (Recursive): O(n) due to the function call stack