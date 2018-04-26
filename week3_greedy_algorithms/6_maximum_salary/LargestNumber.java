import java.util.*;
import java.util.stream.Collectors;


public class LargestNumber {
    private static String largestNumber(String[] a) {
        return Arrays.stream(a)
                .sorted((s1,s2) -> Integer.compare(Integer.parseInt(s2), Integer.parseInt(s1)))
                .collect(Collectors.joining(""));
       
        // return result.toString();
        // return Arrays.asList(a).stream()
        //         .flatMap(s -> Arrays.stream(s.split(""))) // Flat Map -> Map + Flatten 
        //          // Stream<String> -> (split gives Array) Convert to Stream<String[]> -> Stream<String>
        //         .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.toString())).reversed())
        //          // Sort on Descending Order -> Integer.compare(s2, s1)
        //         .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

