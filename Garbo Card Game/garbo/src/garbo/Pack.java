/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ss
 */
public class Pack {

    private final ArrayList<Card> cards;
    private int cardNum = -1;

    public Pack() {
        ArrayList<Card> cardsArr = new ArrayList<>();

        int[] siutArr = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
        int[] rankArr = {5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12};

        for (int i = 0; i < rankArr.length; i++) {
            cardsArr.add(new Card(siutArr[i], rankArr[i]));
        }

        this.cards = cardsArr;
    }//end of constructor 

    public void shuffle() {
        Collections.shuffle(this.cards); //shuffle cards
    }

    public Card getTopCard() {
        this.cardNum++;
        return cards.get(cardNum);
    }

    public int getNumberOfCardsLeft() {
        return (cards.size() - this.cardNum) - 1;
    }

}//end of class
