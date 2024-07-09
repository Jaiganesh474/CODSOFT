import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    private static final int MINRANGE = 1;
    private static final int MAXRANGE = 10;
    private static final int MAXATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int score = 0;

        while (true) {
            int numberToGuess = random.nextInt(MAXRANGE - MINRANGE + 1) + MINRANGE;
            int attempts = 0;
            rounds++;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + rounds + ": I'm thinking of a number between " + MINRANGE + " and " + MAXRANGE + ". Can you guess it?");
            
            while (attempts < MAXATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAXATTEMPTS + ". Enter your guess: ");
                
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    continue;
                }
                
                attempts++;
                
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number!");
                    score++;
                    guessedCorrectly = true;
                    System.out.println("\nGame completed! You played " + rounds + " rounds and won " + score + " times.");
		    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
                System.out.println("Do you want to play again? (yes/no): ");
            }

            
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and won " + score + " times.");
        scanner.close();
    }
    
}
