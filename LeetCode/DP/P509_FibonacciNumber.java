public class P509_FibonacciNumber {

    public static void main(String[] args) {
        fib_recursive(2);  // 1
        fib_memoization(3);  // 2
        fib_memoization(4);  // 3
    }

    // #1. 재귀 함수 (8ms / 40.2MB)
    public static int fib_recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    // #2. memoization + iterative (0ms / 39.72MB)
    public static int fib_memoization(int n) {
        int[] fibo = new int[n + 1];

        if (n <= 1) {
            return n;
        }

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];
    }
}
