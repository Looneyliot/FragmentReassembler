<!-- ABOUT THE PROJECT -->
## About The Project

### Fragment Reassembler:

This program reads an input of text fragments and reassembles them using a Greedy Approximation Algorithm. <br><br>
The program reads a collection of fragments and then processes them in a series of rounds. Each round examines all possible pairings and for each pair considers all possible alignments. This identifies the pair with the longest overlap. Those two fragments are then aligned at the point of maximal overlap and merged into a superstring that has the two original fragments as substrings. Each round decreases the count of fragments by one. The process repeats until it reaches a single result. <br> <br>
Finding the optimal reassembly is equivalent to the shortest common superstring, a classic problem in theoretical computer science. The shortest superstring program is NP-hard, which means no efficient, polynomial-time solution is believed to exist.

### File Shredder:

This program is used to create test input for *Fragment Reassembler*. It takes a file, duplicates it numCopies times, fragments it into the format {fragment 1}{fragment 2} {fragment 3} ... {fragment N}, and outputs it to a new text file.
In the *fragmentDocument* method you have the option to change the minimum and maximum fragment sizes, and the number of copies to shred.

### Built With

Java: Openjdk version "11.0.16.1" 2022-08-12 LTS

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

**You will need Java installed. To install click [here](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)**

### Fragment Reassembler:

1. Clone the project.
2. Open a command prompt/terminal in the *FragmentReassembler* directory where the project is cloned.
3. To compile the code type:
```
javac FragmentReassembler.java
```


4. Run the program:
    + To run the program on the sample inputs type: 
    ```
    java FragmentReassembler
    ```
    + To run the program on nameOfFile.txt (any .txt file with fragments of the form {fragment 1}{fragment 2} {fragment 3} ... {fragment N}) type:
    ```
    java FragmentReassembler nameOfFile.txt  
    ```

### File Shredder:

1. Clone the project.
2. Open a command prompt/terminal in the *FileShredder* directory where the project is cloned.
3. To compile the code type:
```
javac FileShredder.java
```
4. Run the program:
    + To fragment inputFile and write the output to outputFile type: 
    ```
    java FileShredder inputFile outputFile
    ```


    
## Getting input to test:  

You have 2 main options to test reassembling fragments:
1. Go into FragmentReassembler and create an array with your fragments. Run method on your array and print result in main:
```
System.out.println("Fragments Reassembled:\n" + reassembleFragment(myArray, myArray.length));
```
Then run *FragmentReassembler* with no arguments: 
```
java FragmentReassembler
```
2. Use *FileShredder* to shred an existing text file into fragments : 
```
java FileShredder inputFile outputFile. 
```

Then run *FragmentReassembler* with the shredded file as an argument: 
```
java FragmentReassembler shreddedFile
```

## Examples:

There are several fragmented text files in the *FragmentReassembler* directory which you can run FragmentReassembler.java on: shreddedFireBird.txt (~instant reassembly time), shreddedGhostPoem.txt (~30 second reassembly time), shreddedSpiderFly.txt (~3.5 minute reassembly time).

The output of running FragmentReassembler on these text files is seen [here](https://github.com/Looneyliot/FragmentReassembler/tree/main/FragmentReassembler/ExampleImages).




<!-- CONTACT -->
## Contact

Eliot Luna - 3liot33@gmail.com

Project Link: [https://github.com/Looneyliot/repo_name](https://github.com/Looneyliot/FragmentReassembler)
