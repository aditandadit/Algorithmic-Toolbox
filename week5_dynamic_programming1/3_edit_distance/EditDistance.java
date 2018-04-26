import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {

        int [][] edit = new int[s.length() + 1][t.length() + 1];

        // String first is Empty => any Other String edit distance with First is its length
        for (int i = 0; i <= s.length(); i++) {
            edit[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j++) {
            edit[0][j] = j;
        }

        // Indexing is starting from 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                // Edit Distance of FirstString till i-1 and SecondString till j-1

                edit[i][j] = Integer.MAX_VALUE;

                // Chars are equal -> check edit distance S[0 i-1] And T[0 j-1]
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    edit[i][j] = edit[i-1][j-1];
                }
                // Replacement -> Once Replaced 1 + Edit Distance of s[0 i-1] and T[0 j-1]
                int substitution = edit[i-1][j-1] + 1;

                // Insertion -> Insert in String 1 to Make Same as String 2;
                // Once Inserted -> str1[i+1] == str2[j] so move str2 -> j-1
                int insertion = edit[i][j-1] + 1;

                // Deletion ->  Delete at str1[i] => (i-1,j)
                int deletion = edit[i-1][j] + 1;

                edit[i][j] = min(edit[i][j] , substitution, insertion, deletion);
            }
        }

        return edit[s.length()][t.length()];
    }

    public static int min(int ...arr) {
        int result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.min(result, arr[i]);
        }
        return result;
    }
    
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
