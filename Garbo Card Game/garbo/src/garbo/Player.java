/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbo;

/**
 *
 * @author ss
 */
public class Player {

    private final Hand hand;
    private int score;

    public Player() {
        this.score = 0;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void printHand() {
        int temp = 1;
        for (int i = 0; i < this.getHand().getNumOfCArds(); i++) {
            System.out.print("  card " + temp + ":" + this.getHand().getCard(i).getName());
            temp++;
        }
        System.out.println(" ");
    }

    public void addToScore(int score) {
        this.score += score;
    }
}
