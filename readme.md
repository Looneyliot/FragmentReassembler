<!-- ABOUT THE PROJECT -->
## About The Project

This program reads an input of text fragments and reassembles them using a Greedy Approximation Algorithm. <br><br>
The program reads a collection of fragments and then processes them in a series of rounds. Each round examines all possible pairings and for each pair considers all possible alignments. This identifies the pair with the longest overlap. Those two fragments are then aligned at the point of maximal overlap and merged into a superstring that has the two original fragments as substrings. Each round decreases the count of fragments by one. The process repeats until it reaches a single result. <br> <br>
Finding the optimal reassembly is equivalent to the shortest common superstring, a classic problem in theoretical computer science. The shortest superstring program is NP-hard, which means no efficient, polynomial-time solution is believed to exist.

### Built With

Java: Openjdk version "11.0.16.1" 2022-08-12 LTS

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

**You will need Java installed. To install click [here]()**

1. Clone the project.
2. Open a command prompt/terminal in the directory where the project is cloned.
3. Type 'javac FragmentReassembler.java' and press enter to compile the code.
4. Run the program:
    + To run the program on the sample inputs type: 
    ```
    java FragmentReassembler.java
    ```
    + To run the program on test.txt type:
    ```
    java FragmentReassembler.java test.txt  
    ```
    
    
<!-- CONTACT -->
## Contact

Eliot Luna - 3liot33@gmail.com

Project Link: [https://github.com/Looneyliot/repo_name](https://github.com/your_username/repo_name)