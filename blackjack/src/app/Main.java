package app;

import java.util.Scanner;
import service.BlackjackGame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlackjackGame game = new BlackjackGame();
        game.startGame(scanner);
        scanner.close();
    }
}