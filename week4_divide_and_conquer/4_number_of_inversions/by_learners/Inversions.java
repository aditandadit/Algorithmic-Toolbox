import java.util.*;

public class Inversions {

    private static int mergeAndCount(int[] A, int[] b, int left, int mid, int right) {
        // All indices are Inclusice -> 0 to length - 1;
        int i = left;
        int j = mid;
        int k = left;
        int inversionCount = 0;

        // LEFT ARRAY from left to mid -1 
        // RIGHT ARRAY from mid to right (Inclusive);


        // Every Time the right side has shorter element than left
        // All the elemnts are i on the left are inversions for the jth element on right
        while (i <= mid - 1 && j <= right) {
            if (A[i] <= A[j]) {
                b[k++] = A[i++];
            } else {
                // Left 1 3 5 7  Right 2 4 6 8
                // when i is at 3, Inversions are (3,2) (5,2) (7,2) for j at 2;
                // when i is at 5 and j at 4 Inversions are (5,4) & (7,4) 

                // Mid -> beginning Index of right   i -> Current Index at left;
                inversionCount += mid - i;  
                b[k++] = A[j++]; 
            }

        } 

         // Elements Left on either sides are already sorted so Just add them
        while (i <= mid - 1) {
            b[k++] = A[i++];
        }

        while (j <= right) {
            b[k++] = A[j++];
        }

        for (i=left; i <= right; i++) {

            A[i] = b[i];
        }

        return inversionCount;

    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;

        // Trivial Condition Check left > right is not valid
        if (right <= left) {
            return numberOfInversions;
        }
        // int mid = (left + right) / 2; BAD left + right could overflow

        int mid = left + (right - left) / 2;

        // Add number of Inversions on LEFT AND RIGHT sub problems
        // Both Left and Right indices are Inclusive ( 0 , length -1 )
        numberOfInversions += getNumberOfInversions(a, b, left, mid);
        numberOfInversions += getNumberOfInversions(a, b, mid + 1, right);
        // Merge Step T(n) = 2 T(n/2) + k.n -> k.n is merge cost
        //Add number of Inversions across the left and right parts;
        numberOfInversions += mergeAndCount(a,b, left, mid+1, right);

        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }
}

