import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * FileShredder.java
 *
 * Java program which takes a file, separates the content
 * into fragments of the form:
 * {fragment 1}{fragment 2} {fragment 3} ... {fragment N}
 * and writes it to a new file.
 * 
 * @author Eliot Luna
 */
public class FileShredder {

    /**
     * Main function - ensures program is run with correct arguments
     * and then calls other functions.
     * 
     * @param args[0] - file being read.
     * @param args[1] - file being written.
     */
    public static void main(String[] args) {
        // Set number of copies of file to be fragmented
        int numCopies = 10;

        // set min and max size of fragments
        int minFragmentSize = 10;
        int maxFragmentSize = 30;

        // If no argument, or more than two arguments are specified
        // Print help message and exit
        if (args.length != 2) {

            System.out.println("Error, usage: java FileShredder inputfile outputfile");
            System.exit(1);

        }
        // If two arguments specified, fragment inputFile and write it to outputFile
        else {
            fragmentDocument(args[0], args[1], numCopies, minFragmentSize, maxFragmentSize);
        }
    }

    /**
     * Takes content of file and separates it into fragments,
     * then writes fragments into outputFile
     * 
     * @param inputFile       - file being read.
     * @param outputFile      - file being written.
     * @param numcopies       - amount of copies of file to be fragmented.
     * @param minFragmentSize - smallest fragment size
     * @param maxFragmentSize - largest fragment size
     */
    static void fragmentDocument(String inputFile, String outputFile, int numCopies, int minFragmentSize,
            int maxFragmentSize) {
        // Get content of inputFile
        String fileContent = copyFileToString(inputFile);

        createFile(outputFile);

        // Make numCopies shredded copies of file
        // and write them to outputFile
        for (int i = 0; i < numCopies; i++) {
            String fragments = createFragments(fileContent, minFragmentSize, maxFragmentSize);
            writeToFile(outputFile, fragments);
        }
    }

    /**
     * Takes content of file and puts it in a String
     * 
     * @param inputFile - file being read.
     * @return - content of file.
     */
    static String copyFileToString(String inputfile) {

        StringBuilder sb = new StringBuilder();
        try {
            Scanner reader = new Scanner(new FileInputStream(inputfile));
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);

        }

        String fileContent = sb.toString();
        return fileContent;
    }

    /**
     * Creates file outputFile, or exits if file exists already
     * 
     * @param outputFile - file being created.
     */
    static void createFile(String outputFile) {
        try {
            File myFile = new File(outputFile);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Creates fragments of String 'content' and returns string containing all
     * fragments.
     * 
     * @param content         - string to be fragmented
     * @param minFragmentSize - smallest fragment size
     * @param maxFragmentSize - largest fragment size
     * @return - string containing all fragments
     */
    static String createFragments(String content, int minFragmentSize, int maxFragmentSize) {
        Random rand = new Random();
        String fragments = "";
        int currentPos = 0;
        while (currentPos < content.length() - maxFragmentSize) {
            int randomNum = rand.nextInt(maxFragmentSize - minFragmentSize + 1) + minFragmentSize;
            fragments += "{" + content.substring(currentPos, currentPos + randomNum) + "}";
            currentPos += randomNum;
        }
        fragments += "{" + content.substring(currentPos, content.length()) + "}";

        return fragments;
    }

    /**
     * Writes string content to outputFile
     * 
     * @param outputFile - file being written to
     * @param content    - string to write to file
     */
    static void writeToFile(String outputFile, String content) {

        try {
            FileWriter myWriter = new FileWriter(outputFile, true);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
