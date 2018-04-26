import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {

        // Max value derived from Knapsack Capacity W by using items i to w.length;
        int [][] MAX = new int [W + 1][w.length + 1];

        // OPTIMAL SUBPROBLEM -> 2 Choices Either Keep Ith item or NOT
        // IF Keep Ith Item => Max Value = MaxValue[W - w[i]][i-1] + v[i]; i -> i -1 Reduce W -> W -w[i]
        // IF NOT KEEP Ith item => Max Value = MaxValue[W][i-1] ie i -> i-1 W -> W (same)


        for (int weight = 0; weight <= W; weight++) {
            for (int i = 0; i<= w.length; i++) {

                if (i == 0 || weight == 0) {
                    // Item 0 or weight 0
                    MAX[weight][i] = 0;
                } else {
                    int dontUseIthItem = MAX[weight][i-1];

                    // Maximising Problem -> Need to Set to - INFINITY
                    int useIthItem = Integer.MIN_VALUE;

                    // Check if there is enough weight for ith Item
                    // ith Item's weight is w[i-1]
                    if (weight - w[i-1] >= 0) {
                        useIthItem = MAX[weight - w[i-1]][i-1] + w[i-1];
                    }

                    MAX[weight][i] = Math.max(useIthItem, dontUseIthItem);
                }
            }
        }

        return MAX[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

