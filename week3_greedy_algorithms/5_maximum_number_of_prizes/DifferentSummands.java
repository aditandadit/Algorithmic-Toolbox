import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int currentNum = 1;
        int sum = 0;

        while (true) {
            int spaceLeft = n - sum;
            int spaceLeftAfterCurrentAppend = spaceLeft - currentNum;
            // After Adding current currentNum 
            // Is there enough space left to add a Number greater than currentNum
            // Ex ->  After Adding 2 , is there enough space to Add 3?
            if (spaceLeftAfterCurrentAppend > currentNum) {
                // There is enough space to Add CurrentNum and then Greater than CurrentNum
                sum += currentNum;
                summands.add(currentNum);   
                currentNum++; // Try the Next immediate Number
                continue;
            } else {

                // There is not enough space to Add currentNum and then a number greater than it
                // ie just add whatever is left ie Spaceleft
                summands.add(spaceLeft);
                break;
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

