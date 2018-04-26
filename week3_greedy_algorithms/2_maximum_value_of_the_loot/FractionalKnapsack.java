import java.util.Scanner;

public class FractionalKnapsack {

    private static int getMaxDensity(int [] values, int [] weights) {
		int maxIndex = 0;
		double maxValue = 0;
		for (int i = 0; i<values.length; i++ ) {
	//		System.out.println("density " + i + " " +densities[i]);
			if (weights[i] != 0 && ((double) values[i]) / weights[i]  > maxValue) {
					maxIndex = i;
					maxValue = ((double) values[i]) / weights[i];
			}
		}
		return maxIndex;	
 	}
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
	    double value = 0;

	    for (int i =0; i< weights.length; i++) {
	    	if (capacity <=0) return value;

	    	int index = getMaxDensity(values, weights);
	    	int a = Math.min(capacity, weights[index]);
	    	value += a * (double) values[index] / weights[index];
	    	weights[index] -= a;
	    	capacity -= a;
	    }

	    return value;
	}

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
