/*Rock, Paper, Scissors game */

import java.util.Random;
import java.util.Scanner;

public class rockpaperscissorsgame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        System.out.println("-----------------------------------------------------------");
        System.out.println("|       Welcome to the ROCK, PAPER, SCISSORS GAME!        |");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Choose your move: rock, paper, or scissors");

        String[] moves = {"rock", "paper", "scissors"};
        String userMove, computerMove;

        do {
            System.out.print("Your move: ");
            userMove = inputScanner.nextLine().toLowerCase();

            if (!isValidMove(userMove)) {
                System.out.println("Invalid . Please choose rock, paper, or scissors.");
                continue;
            }

            computerMove = moves[randomGenerator.nextInt(moves.length)];

            System.out.println("Computer's move: " + computerMove);

            determineRoundWinner(userMove, computerMove);

            System.out.print("Do you want to play again? (yes/no): ");
        } while (inputScanner.nextLine().equalsIgnoreCase("yes"));
        System.out.println("-------------------------------------------------------------");
        System.out.println("|     Thanks for playing the Rock, Paper, Scissors Game!    |");
        System.out.println("-------------------------------------------------------------");
        inputScanner.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static void determineRoundWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            System.out.println("It's a draw!");
        } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                (userMove.equals("paper") && computerMove.equals("rock")) ||
                (userMove.equals("scissors") && computerMove.equals("paper"))) {
            System.out.println("You win this round!");
        } else {
            System.out.println("Computer wins this round!");
        }
    }
}
