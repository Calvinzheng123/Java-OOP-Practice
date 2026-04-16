package service;

import java.util.Scanner;
import model.Dealer;
import model.Deck;
import model.Player;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        player = new Player("Player");
        dealer = new Dealer();
    }

    public void startGame(Scanner scanner) {
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());

        System.out.println("Dealer shows: " + dealer.getHand().getCards().get(0));
        System.out.println("Your hand: " + player.getHand());

        playerTurn(scanner);

        if (!player.getHand().isBust()) {
            dealerTurn();
            showWinner();
        } else {
            System.out.println("You busted. Dealer wins.");
        }
    }

    private void playerTurn(Scanner scanner) {
        while (true) {
            System.out.print("Hit or stand? ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("hit")) {
                player.getHand().addCard(deck.dealCard());
                System.out.println("Your hand: " + player.getHand());

                if (player.getHand().isBust()) {
                    break;
                }
            } else if (choice.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("Dealer hand: " + dealer.getHand());

        while (dealer.shouldHit()) {
            dealer.getHand().addCard(deck.dealCard());
            System.out.println("Dealer hits: " + dealer.getHand());
        }
    }

    private void showWinner() {
        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        System.out.println("Final Player Hand: " + player.getHand());
        System.out.println("Final Dealer Hand: " + dealer.getHand());

        if (dealer.getHand().isBust()) {
            System.out.println("Dealer busted. You win!");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("Push.");
        }
    }
}