package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public int getValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();
        }
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }
        while (total > 21 && aceCount > 0) {
            total -= 10; // treating ace as 1 instead of 11
            aceCount--;
        }
        return total;
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards + " (Value: " + getValue() + ")";
    }
}
