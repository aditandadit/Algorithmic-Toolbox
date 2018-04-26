import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    private static long getFibonacciSumFast(long n) {
	if (n <=1) return n;
	long index = (n + 2) % 60;
	long a = 0, b =1 , c = 1;
	long sum = 1;
	for (int i = 2; i <=index ; i++) {
		c = a%10 + b%10;
		a = b%10;
		b = c%10;
	}
	if (c==0) return 9;	
	return (c-1)%10;
    }   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
//	for (int i = 0; i < n ; i++ ) {
//	long s = getFibonacciSumNaive(i);
//       System.out.println(s);
//	}
//	long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

