import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
        	if (maxIndex == -1 || numbers[i] > numbers[maxIndex]) {
        		maxIndex = i;
        	} 
        }

        int nextIndex = -1;
        for (int i=0;i<n;i++) {
        	if (i!=maxIndex && 
        		(nextIndex == -1 || numbers[i] > numbers[nextIndex])){
        		nextIndex = i;
        	}
        }

        long result = (long) numbers[maxIndex] * (long) numbers[nextIndex];
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}