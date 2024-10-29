/*
 * Date: 10/27/2023
 * Description: The helper file for game where the user tries to guess the correct number picked by the computer.
 */ 

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberHelper {

    public static void playGame() {

        boolean startGame = true;
        while (startGame) {

            Scanner console = new Scanner(System.in);

            Random r = new Random();
            int answer = r.nextInt(100) + 1; //random number between 1-100

            int tries = 0; //number of user's attempts
            String counter = ""; //history of user's attempts
            boolean repeat = true;

            while (repeat) {
                
                System.out.print("Please enter an integer between 1 and 100: ");
                int userAnswer = console.nextInt();

                if (userAnswer > answer) {
                    System.out.println("Your number is too high");
                    tries++;
                    counter += userAnswer + "\n";
                } else if (userAnswer < answer) {
                    System.out.println("Your answer is too low");
                    tries++;
                    counter += userAnswer + "\n";
                } else {
                    tries++;
                    counter += userAnswer + "\n";
                    repeat = false; //if got correct answer, end loop
                }
            }

            System.out.println("Congratulations!! You won!!");
            System.out.println("You had " + tries + " tries");

            System.out.println("Here is the history of your attempts");
            System.out.println(counter);

            System.out.print("Would you like to play again? Enter y or n ");
            String continuee;
            continuee = console.next();
            char letter = continuee.charAt(0); //checks to see if user put y or n
            
            if (letter == 'y') {
                startGame = true; //if y, start again
            } else if (letter == 'n') {
                startGame = false; //if n, stop
            } else {
                System.out.println("Invalid"); //if answer was not y or n, stop program
                startGame = false;
            }
        }
    }
}
