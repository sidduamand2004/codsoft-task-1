import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create a random number generator
        Random random = new Random();

        // Define the range of numbers
        int minRange = 1;
        int maxRange = 100;

        // Initialize variables for tracking attempts and score
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        // Create a flag for playing again
        boolean playAgain = true;

        // Main game loop
        while (playAgain) {
            // Generate a random target number within the specified range
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");

            // Initialize variables for user's guess and tracking if they guessed correctly
            int guess;
            boolean hasGuessedCorrectly = false;

            System.out.println("You have 10 attempts to guess the number.");

            // Loop for up to 10 attempts
            while (attempts < 10) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Check if the user didn't guess correctly within the limit
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Your score: " + score + " rounds won.");
            } else {
                attempts = 0; // Reset attempts for the next round
            }
        }

        // Close the scanner
        scanner.close();
    }
}
