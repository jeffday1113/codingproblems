package javasolutions.strings;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    
    /* PROBLEM: Write a method to compute all permutations of a string
     * 
     * SOLUTION:
     * -If the string is empty, then it has no characters and all of the permutations are [""] (an
     * empty string)
     * -Lets add one letter to it a1, then it has one character a1 and all of the permutations are
     * ["a1"] 
     * -Lets add another letter to it a2, then its had two characters a1 and a2 and all of the
     * permutations for two letters are adding a2 to all of the possible positions of the solutions
     * for a1. ["a1a2", "a2a1"] 
     * -Just keep doing this, and let the recursion build the list 
     * 
     * RUNNING TIME: O(n!)
     * -F(n) = length of set returned by stringPerms when passed a string of length n 
     * -we know F(0) = 1, because if we pass it nothing it returns a set with the blank string
     * -If we pass in a string with length n, that call of stringPerms calls itself recursively with
     * a string of length n-1 (because it cuts off the first letter and passes in the rest).
     * -That means the length of the set returned by that recursive call is F(n-1)
     * -For each word returned in the basePerms set, we add the firstChar letter to n different
     * positions (n-1 letters in all of the words in F(n-1) plus an end position), giving a total of
     * n * F(n-1) total words to the perms set when done
     * -F(n) = n * F(n-1), F(n-1) = n-1 * F(n-2), sub that in
     *  F(n) = n * n-1 * F(n-2), eventually n becomes 0
     *  ...
     *  F(n) = n * n-1 * n-2 * ... F(0)
     *  F(n) = n * n-1 * n-2 * ... * 1 , which is n!*/
    
    public static Set<String> stringPerms(String str) {
        if (str == null) {
            return null;
        }
        Set<String> perms = new HashSet<String>();
        /* Set recursive base case, if the string is empty, we know we have gone through all of the
         * recursive calls that we need to */
        if (str.equals("")) {
            perms.add("");
            return perms;
        } else {
            /* Get the first character of the string passed in, we will be adding that to whatever
             * is returned by our recursive call on the rest of the word */
            String firstChar = str.substring(0, 1);
            String restOfString = str.substring(1);
            Set<String> basePerms = stringPerms(restOfString);
            /* Now the baseParams set has all of the perms created from the rest of the string, now
             * we just need to add the first letter in all possible positons */
            for (String word : basePerms) {
                for (int i = 0; i <= word.length(); i++) { // Need <= so that we can add to the last position afterwards 
                    String newPerm = word.substring(0, i) + firstChar + word.substring(i);
                    perms.add(newPerm);
                }
            }
        }
        return perms;
    }
    
    public static void main(String[] args) {
        String test = "abcd";
        Set<String> perms = stringPerms(test);
        for (String perm : perms) {
            System.out.println(perm);
        }
    }

}
