import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        if (n == 1) return Arrays.asList(1);

        List<Integer> sequence = new ArrayList<Integer>();
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 0;
        for (int i = 2; i<=n; i++) {

            int mul2 = Integer.MAX_VALUE;
            int mul3 = Integer.MAX_VALUE;
            int add1 = Integer.MAX_VALUE;

            if (i%2 == 0){
                mul2 = cache[i/2] + 1;
            }

            if (i%3 == 0) {
                mul3 = cache[i/3] + 1;
            }

            if (i - 1 >= 0){
                add1 = cache[i-1] + 1;
            }

            cache[i] = Math.min(mul2, Math.min(mul3,add1));
        }

        // Recreate the sequence

        int i = n;
        while(i > 1) {
            sequence.add(i);
            if (cache[i] == cache[i-1] + 1) {
                i = i-1;
            } else if (i%2 == 0 && cache[i] == cache[i/2] + 1) {
                i = i/2;
            } else if (i%3 == 0 && cache[i] == cache[i/3] + 1) {
                i = i/3;
            }
        }

        sequence.add(1);
        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

