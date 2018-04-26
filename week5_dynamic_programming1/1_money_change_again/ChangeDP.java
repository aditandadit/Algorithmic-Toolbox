import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] denom = {1,3,4};
        int[] cache = new int[m+1];
        cache[0] = 0;
        for (int i = 1; i<=m ;i++) {
            cache[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < denom.length; j++) {

                if (i - denom[j] >= 0) {
                    // Choices -> Use Denom1 OR Denom2 OR Denom ....
                    // When making a Choice min(cache[money], cache[money - denom]) + 1
                    cache[i] = Math.min(cache[i], cache[i-denom[j]] + 1);
                }
            }
        }

        return cache[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

