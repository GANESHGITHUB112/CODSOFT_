package ALL_TASK;
import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    private static final int MAX_ATTEMPTS = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        boolean playAgain = true;

	        while (playAgain) {
	            int randomNumber = random.nextInt(100) + 1;
	            int attempts = 0;
	            boolean guessedCorrectly = false;

	            System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

	            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
	                System.out.print("Enter your guess: ");
	                int guess = scanner.nextInt();
	                attempts++;

	                if (guess == randomNumber) {
	                    guessedCorrectly = true;
	                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
	                } else if (guess < randomNumber) {
	                    System.out.println("Too low!");
	                } else {
	                    System.out.println("Too high!");
	                }
	            }

	            if (!guessedCorrectly) {
	                System.out.println("Sorry, you've used all your attempts. The number was " + randomNumber + ".");
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next().equalsIgnoreCase("yes");
	        }

	        System.out.println("Thanks for playing! Goodbye.");
	        scanner.close();
	    }
	}

	



