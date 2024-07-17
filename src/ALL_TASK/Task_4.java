package ALL_TASK;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task_4 {
	static int score = 0;
    static int currentQuestion = 0;
    static boolean answered = false;

    static String[][] questions = {
        {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "3"},
        {"What is 5 + 7?", "10", "12", "13", "14", "2"},
        {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "2"},
        {"What is the largest mammal?", "Elephant", "Blue Whale", "Shark", "Giraffe", "2"}
    };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        for (currentQuestion = 0; currentQuestion < questions.length; currentQuestion++) {
            displayQuestion(currentQuestion);
            answered = false;

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("\nTime's up!");
                        nextQuestion();
                    }
                }
            };
            timer.schedule(task, 10000); // 10 seconds per question

            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();
            answered = true;

            if (answer == Integer.parseInt(questions[currentQuestion][5])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
            task.cancel(); // Stop the timer if the user answers early
        }

        timer.cancel();
        displayResults();
        scanner.close();
    }

    public static void displayQuestion(int questionIndex) {
        System.out.println("\n" + questions[questionIndex][0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + ". " + questions[questionIndex][i]);
        }
    }

    public static void nextQuestion() {
        currentQuestion++;
        if (currentQuestion < questions.length) {
            displayQuestion(currentQuestion);
        }
    }

    public static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            System.out.println("Correct answer: " + questions[i][Integer.parseInt(questions[i][5])]);
        }
    }


	}


