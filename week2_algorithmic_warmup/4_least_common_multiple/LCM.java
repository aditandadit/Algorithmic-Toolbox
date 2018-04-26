import java.util.*;
import java.math.BigInteger;
public class LCM {
    private static long lcm_naive(int a, int b) {
        BigInteger mul = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
        BigInteger hcf = BigInteger.valueOf(gcd(a,b));
        return mul.divide(hcf).longValue();
    }

    private static long gcd(int a, int b) {
        if (b==1) return 1;
        if (b==0) return a;
        if (b>a) return gcd(b,a);
        return gcd(a%b, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}