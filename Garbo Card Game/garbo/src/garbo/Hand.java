/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbo;

import java.util.ArrayList;

/**
 *
 * @author ss
 */
public class Hand {

    private final ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public Card getCard(int num) {
        return hand.get(num);
    }

    public int getNumOfCArds() {
        return hand.size();
    }

    public void addCard(Card c) {
        this.hand.add(c);
    }

    public void removeCard(int index) {
        this.hand.remove(index);
    }
}
