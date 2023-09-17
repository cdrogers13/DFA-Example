import java.util.*;
import java.io.*;

//CAN I ASSUME THE INPUT WILL BE CONSISTENT? THATS WHAT ASSIGNMENT SAYS - 9/17
public class DFA {
    //Create stateTable as global so that it can always be seen. 4 is the accept state
    static int[][] stateTable = {{2, 1}/*q0 -> q2, q1*/, {2, 1}/*q1-> q2, q1*/, {2, 3}/*q2-> q2, q3*/, {2, 4}/*q3-> q2, q4*/, {2, 1}}/*q4-> q2, q1*/; //2D Array with state tables
        
    public static void main(String[] args) throws IOException
    {
        File inputFile = new File("Text.txt"); //Read file from command line argument
        //Need some input validation. Is parseInt a thing in java?
        Scanner myReader = new Scanner(inputFile);
        int currentState = 0;
        //May need to change this to be hasNext() instead of hasNextLine()
        while(myReader.hasNextLine()) {
            String currentLine = myReader.nextLine();
            
            for (int i = 0; i < currentLine.length(); i++) {
                currentState = nextState(currentState, Character.getNumericValue(currentLine.charAt(i)));
            }
            //currentState = nextState(currentState, Character.getNumericValue(reader.read())); //Cast the character to an int for use in nextState
            //currentState = nextState(currentState, myReader.nextInt());
            System.out.println((currentState == 4) ? "YES" : "NO"); //Print yes if currentState is 4, otherwise print no.
        }
        myReader.close();    
    }

    //Take input and current state. Use stateTable index to return currentState to keep track of where we are in the stateTable
    public static int nextState(int currentState, int input){
                switch(input){
                    case 0: 
                        currentState = stateTable[currentState][0];
                        break; 
                    
                    case 1:
                        currentState = stateTable[currentState][1];
                        break; 

                    default:
                        //System.out.println("Invalid character. Only '0' and '1' are valid inputs.");
                }
                return currentState;
            }
}