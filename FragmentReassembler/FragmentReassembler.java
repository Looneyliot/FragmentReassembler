import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * FragmentReassembler.java
 *
 * Java program reads an input of text fragments and reassembles them
 * using Greedy Approximation Algorithm
 * 
 * @author Eliot Luna
 */

public class FragmentReassembler {

    // Used to keep superstrings temporarily as they are created
    static String tempSuperString;

    /**
     * Main function - calls other functions and prints results.
     * 
     * @param args - possible file being read.
     */
    public static void main(String[] args) {
        // If no argument specified then run these test cases
        // Create your own input cases here
        if (args.length < 1) {
            String[] arr = { "all is well", "ell that en", "hat end", "t ends well" };

            String[] arr2 = { "staaaaaht", "taaaa", "aaaat", "aaaath", "aaaah", "staaaa", "staaaaaht", "a" };

            String[] arr3 = { "s well tha", "ell" };

            String[] arr4 = { "a", "a", "a", "a", "a", "a", "a", "a" };

            System.out.println("Fragments Reassembled:\n" + reassembleFragment(arr, arr.length));
            System.out.println();

            System.out.println("Fragments Reassembled:\n" + reassembleFragment(arr2, arr2.length));
            System.out.println();

            System.out.println("Fragments Reassembled:\n" + reassembleFragment(arr3, arr3.length));
            System.out.println();

            System.out.println("Fragments Reassembled:\n" + reassembleFragment(arr4, arr4.length));
            System.out.println();
        }
        // If file name is specified then take content of file
        // write it to string array, and reassemble fragments
        // Expected file format: {fragment 1}{fragment 2} {fragment 3} ... {fragment N}
        else if (args.length == 1) {
            String[] fileArray = inputFileToArrayList(args[0]);

            System.out.println("Fragments Reassembled:\n" + reassembleFragment(fileArray, fileArray.length));
        }
        // If more than one argument given print help message
        else {
            System.out.println("Error, usage: java ClassName inputfile");
            System.out.println("Or for existing test cases: java ClassName");
            System.exit(1);
        }

    }

    /**
     * Function to reassemble fragments
     * of array into a single string
     * 
     * @param arr - array of fragments
     * @param len - length of array
     */
    static String reassembleFragment(String[] arr, int len) {
        // run len-1 times to consider every pair
        while (len != 1) {
            int longestOverlap = -1;
            int overlap = 0;

            int indexA = 0;
            int indexB = 0;
            String longestOverlapString = "";

            // Find longest overlap items for first len items in arr
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((overlap = findOverlap(arr[i], arr[j])) > longestOverlap) {
                        longestOverlap = overlap;
                        indexA = i;
                        indexB = j;
                        longestOverlapString = tempSuperString;
                    }
                }
            }

            // Ignore last element in next cycle
            len--;

            // If there is no overlap, add the last item to the first item
            if (longestOverlap == -1) {
                arr[0] += arr[len];
            } else {
                // New superstring goes to
                arr[indexA] = longestOverlapString;

                // Last item goes to IndexB
                arr[indexB] = arr[len];
            }
        }
        tempSuperString = "";
        return arr[0];
    }

    /**
     * Function to calculate maximum
     * overlap of two given strings
     * 
     * @param a - first string to be compared
     * @param b - second string to be compared
     * @return the size of the overlap
     */
    static int findOverlap(String a, String b) {
        int maxOverlap = -1;
        int len1 = a.length();
        int len2 = b.length();

        // Check if a is contained in b
        if (b.contains(a)) {
            // The combined string is simply the longer string
            tempSuperString = b;
            maxOverlap = a.length();
            return maxOverlap;
        }

        // Check if b is contained in a
        if (a.contains(b)) {
            // The combined string is simply the longer string
            tempSuperString = a;
            maxOverlap = b.length();
            return maxOverlap;
        }

        // Check suffix of a matches prefix of b
        for (int i = 1; i <= min(len1, len2); i++) {
            // Compare last i characters in a with first i characters in b
            if (a.substring(len1 - i).compareTo(b.substring(0, i)) == 0) {
                if (i > maxOverlap) {
                    // Update maxOverlap and tempSuperString
                    maxOverlap = i;
                    tempSuperString = a + b.substring(i);
                }
            }
        }

        // Check suffix of b matches prefix of a
        for (int i = 1; i <= min(len1, len2); i++) {
            // Compare last i characters in b with first i characters in a
            if (b.substring(len2 - i).compareTo(a.substring(0, i)) == 0) {
                if (maxOverlap < i) {
                    // Update maxOverlap and tempSuperString
                    maxOverlap = i;
                    tempSuperString = b + a.substring(i);
                }
            }
        }
        return maxOverlap;
    }

    /**
     * Function to calculate min of two numbers
     * 
     * @param a - number 1
     * @param b - number 2
     * @return the min of both numbers
     */
    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    /**
     * Function to put content of input file into a string array.
     * Expected file format: {fragment 1}{fragment 2} {fragment 3} ... {fragment N}
     * 
     * @param inputFile - file to read from
     * @return string array with content of input file
     */
    static String[] inputFileToArrayList(String inputFile) {

        ArrayList<String> fileArray = new ArrayList<String>();

        try {
            Scanner reader = new Scanner(new FileInputStream(inputFile));
            reader.useDelimiter("[}]");

            while (reader.hasNext()) {
                fileArray.add(reader.next().trim().substring(1));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // change arraylist<string> to array string
        String[] stringArray = fileArray.toArray(new String[fileArray.size()]);
        return stringArray;
    }
}