import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    long a = 0;
    long b = 1;
    long c = 0;
    for (int i = 2 ; i <= n ;i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i=0;i<n;i++) { System.out.println(i + " " + calc_fib(i)); }
}
}
