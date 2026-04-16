package model;

public class Dealer extends Player{
    public Dealer() {
        super("Dealer");
    }
    public boolean shouldHit() {
        return getHand().getValue() < 17;
    }
}
