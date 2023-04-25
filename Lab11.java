/* Write a program that inputs two strings from the user and checks

if they are the same. This program needs to be case insensitive

Your program needs to use recursion (write a recursive 

method : public static boolean isSame( String s1, String s2) )  and

report  "Both Strings are Same" or "Both Strings are Not Same"

depending on the the return value of the method. The method 

returns true if the string are of length 0 or they are the same.

If any of the letters are not the same or the strings 

do not have the same length, then the method returns false.

*/

/**
 * @author Roque Busto
 * Date: 4/25/2023
 */
import java.util.*;

public class Lab11 {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string: ");

        String first = sc.next().toLowerCase();

        System.out.println("\nEnter the second string: ");

        String second = sc.next().toLowerCase();

        if (!isSame(first, second)){
            System.out.println("\nThe strings are not the same.");
        } else {
            System.out.println("\nBoth strings are the same.");
        }
    }
    public static boolean isSame(String s1, String s2){
        if (s1.length() < s2.length() || s1.length() > s2.length()){
            return false;
        } else if (s1.length() == s2.length()){
            char letter1 = s1.charAt(0);
            char letter2 = s2.charAt(0);
            if (letter1 == letter2){
                return true;
            } else {
                return false;
            }
        }
        return isSame(s1.substring(1), s2.substring(1));
    }
}
