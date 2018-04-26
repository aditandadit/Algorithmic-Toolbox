import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long  tmp_previous = previous%10;
            previous = current%10;
            current = (tmp_previous%10 + current%10)%10;
        }

        return current%10;
    }
    public static int getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;

        int[] result = new int[n + 1];
        int a = 0 ;
        int b = 1;
        int c = 1;
        for (int i = 2; i < n + 1; i++) {
            c = (a + b) % 10;
            a = b % 10;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

