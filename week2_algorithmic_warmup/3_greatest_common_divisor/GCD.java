import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
//    System.out.println(a + " "+ b);
    if (b == 0) return a;
    if (b == 1) return 1;  
    if (b > a) return gcd_naive(b,a);
    return gcd_naive(a%b,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
