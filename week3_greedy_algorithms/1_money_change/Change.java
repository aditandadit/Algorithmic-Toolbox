import java.util.Scanner;

public class Change {
    private static long getChange(int m) {
        long count = 0;
	while (m > 0) {
//		 System.out.println("count" + count);
		while (m > 0 && m - 10 >= 0) {
			m = m - 10;
			count ++;
//			 System.out.println("count" + count);
		}
		while (m > 0 && m - 5 >=0) {
			m  = m -5;
			count++;
//			 System.out.println("count" + count);
		}
		while ( m > 0 && m -1 >=0) {
		//	System.out.println(m);
			m = m - 1;
			count++;
//			System.out.println("count" + count);
		}
//		System.out.println("loop");
	}
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

