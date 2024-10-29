/*
 * Date: 12/6/2023
 * Description: This is the helper file for the program that creates a simple trivia game that uses arrays to store
 * the questions and answers.
 */ 

import java.util.Scanner;

public class TriviaHelper {
    
    private static final int SIZE = 5;

    //runs the program
    public static void run() {
        Scanner console = new Scanner(System.in);
        String[] questions = new String[SIZE];
        String[] answers = new String[SIZE];
        int[] points = new int[SIZE];
        int score = 0;
        boolean more = true;
        //answer options if they want to continue
        String option1 = "yes";
        String option2 = "no";
        
        initialize(questions, answers, points); //stores the information in the arrays

        while (more) {
            score = play(console, questions, answers, points); //user answers questions and score is stored
            System.out.println("Your score is: " + score);

            System.out.println("Play Again? (yes/no)"); //asks for user if replay game
            String answer = console.nextLine();

            if (answer.equals(option1)) { //if yes, game keeps going
                more = true;
                System.out.println();
            } else if (answer.equals(option2)) { //if no, game stops
                more = false;
            } else { //if anything else besides that, stops game
                System.out.println("Not a valid answer. Ending program.");
                more = false;
            }
        }
    }

    public static void initialize(String[] questions, String[] answers, int[] points) { //stores information into the arrays
        questions[0] = "What pokemon is a yellow duck and has headaches constantly? (1 Point)";
        answers[0] = "psyduck";
        points[0] = 1;
        
        questions[1] = "What popular video game was made in 2011 and features a blocky design? (1 Point)";
        answers[1] = "minecraft";
        points[1] = 1;

        questions[2] = "What is the name of the 2001 romance anime that features zodiac animals and was recently remade in 2019? (2 Point)";
        answers[2] = "fruits basket";
        points[2] = 2;

        questions[3] = "What is the name of this Disney 2007 film that featured a cooking rat? (2 Point)";
        answers[3] = "ratatouille";
        points[3] = 2;

        questions[4] = "What does FNAF stand for? (3 Point)";
        answers[4] = "five nights at freddy's";
        points[4] = 3;
    }

    public static int play(Scanner console, String[] questions, String[] answers, int[] points) { //runs the game and asks questions
        int score = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Question " + (i+1)); //"Question 1" and so on
            System.out.print(questions[i] + " "); //prints question
            String input = console.nextLine(); //user input
            input = input.toLowerCase(); //makes user input lowercase to better compare

            if (input.equals(answers[i])) { //if user correct
                score += points[i];
                System.out.println("That is correct!");
            } else { //if incorrect
                System.out.println("Wrong. The correct answer is: " + answers[i]);
            }
            System.out.println();
        }
        return score;
    }
}
