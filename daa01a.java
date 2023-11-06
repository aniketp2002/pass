
// Write a program to calculate  Fibonnaci numbers and find its step count.

public class Fibonacci {
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        long fib = 0;
        long prev = 1;
        long prevPrev = 0;
        
        for (int i = 2; i <= n; i++) {
            fib = prev + prevPrev;
            prevPrev = prev;
            prev = fib;
        }
        
        return fib;
    }
    
    public static void main(String[] args) {
        int n = 10; // Change this to the desired Fibonacci number you want to calculate.
        long result = calculateFibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}

// Time Complexity (Non-Recursive): O(n)
// Space Complexity (Non-Recursive): O(1)