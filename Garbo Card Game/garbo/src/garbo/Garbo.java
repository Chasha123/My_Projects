/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
L1
 0 1 1 1 0 1 1 2 0 1 1 3 0 1 1 4 0 1 2 1 0 1 2 2 0 1 2 3 0 1 2 4 0 1 3 1 0 1 3 2 0 1 3 3 0 1 3 4 0 1 4 1 0 1 4 2 0 1 4 3  0 1 4 4 

 0 1 1 1 0 1 1 2 0 1 1 3 0 1 1 4 0 1 2 1 0 1 2 2 0 1 2 3 0 1 2 4 0 1 3 1 0 1 3 2 0 1 3 3 0 1 3 4 0 1 4 1 0 1 4 2 0 1 4 3  0 1 4 4 
L2
 */
package garbo;

import java.util.Scanner;

/**
 *
 * @author ss
 */
public class Garbo {

    private final Field field;
    private final Field oldField;
    private final Pack pack;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player notCurrentPlayer;

    public Garbo() {
        this.field = new Field();
        this.oldField = new Field();
        this.pack = new Pack();
        this.player1 = new Player();
        this.player2 = new Player();
        this.currentPlayer = this.player1;
        this.notCurrentPlayer = this.player2;
    }//end of constructor

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setNotCurrentPlayer(Player notCurrentPlayer) {
        this.notCurrentPlayer = notCurrentPlayer;
    }

    public void dealCardsToEachPlayer(int numOfCards) {
        //this.topCard 
        for (int i = 0; i < numOfCards; i++) {
            Card card = this.getPack().getTopCard();
            this.getPlayer1().getHand().addCard(card);
            card = this.getPack().getTopCard();
            this.getPlayer2().getHand().addCard(card);
        }
    }

    public void printCurrentPlayerShowHandMessage() {
        if (this.getCurrentPlayer() == this.getPlayer1()) {
            System.out.println("Player1 turn \n enter any number to show  Player1 hand ");
        } else {
            System.out.println("Player2 turn \n enter any number to show Player2 hand ");
        }
    }

    public void printFieldV2() {
        //int i = 0;
        System.out.println("   1\t  2\t  3\t  4");
        for (int r = 0; r < 4; r++) {
            System.out.print(r + 1);//i++;
            for (int c = 0; c < 4; c++) {
                if (this.getField().getCell(r, c) == this.getOldField().getCell(r, c)) {
                    System.out.print(this.field.getCell(r, c).getName() + "\t");
                } else {
                    System.out.print(this.field.getCell(r, c).getNameL2() + "\t");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public Player getNotCurrentPlayer() {
        return notCurrentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Pack getPack() {
        return pack;
    }

    public Field getField() {
        return field;
    }

    public Field getOldField() {
        return oldField;
    }

    public int calRankPoints(Card card, int r, int c) {
        int points = 0;
        int playedCard = card.getRankValue();

        //check row
        for (int i = 1; i < 5; i++) {
            if (playedCard == this.field.getCell(r + i, c).getRankValue()) {
                points += playedCard;
            }
            if (playedCard == this.field.getCell(r - i, c).getRankValue()) {
                points += playedCard;
            }
        }
        //check columns
        for (int i = 1; i < 5; i++) {
            if (playedCard == this.field.getCell(r, c + i).getRankValue()) {
                points += playedCard;
            }
            if (playedCard == this.field.getCell(r, c - i).getRankValue()) {
                points += playedCard;
            }
        }
        //diagonals
        for (int i = 1; i < 5; i++) {
            if (playedCard == this.field.getCell(r - i, c - i).getRankValue()) {
                points += playedCard;
            }
            if (playedCard == this.field.getCell(r - i, c + i).getRankValue()) {
                points += playedCard;
            }
            if (playedCard == this.field.getCell(r + i, c + i).getRankValue()) {
                points += playedCard;
            }
            if (playedCard == this.field.getCell(r + i, c - i).getRankValue()) {
                points += playedCard;
            }
        }
        return points;
    }

    public int calSiutPoints(Card card, int r, int c) {
        int points = 0;
        int playedCard = card.getSuitValue();

        if (playedCard == this.field.getCell(r - 1, c - 1).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r - 1, c).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r - 1, c + 1).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r, c - 1).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r, c + 1).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r + 1, c - 1).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r + 1, c).getSuitValue()) {
            points += playedCard;
        }
        if (playedCard == this.field.getCell(r + 1, c + 1).getSuitValue()) {
            points += playedCard;
        }

        return points;
    }

    public int level2calPoints(Card card, int r, int c) {
        int points = 0;

        //level 2 the card underneath
        if (card.getSuitValue() == this.oldField.getCell(r, c).getSuitValue()) {
            points = card.getSuitValue() * 10;
        } else if (card.getRankValue() == this.oldField.getCell(r, c).getRankValue()) {
            points = card.getRankValue() * 10;
        }

        return points;
    }

    public void winner() {
        if (this.player1.getScore() > this.player2.getScore()) {
            System.out.println("player1 wins");
        } else {
            System.out.println("player2 wins");
        }
    }

    public boolean winTime() {
        return this.getPack().getNumberOfCardsLeft() == 0
                && this.getPlayer1().getHand().getNumOfCArds() == 0
                && this.getPlayer2().getHand().getNumOfCArds() == 0;
    }

    public static int calPoints(Garbo garbo, Card card, int r, int c) {
        int num;
        int RankPoints = garbo.calRankPoints(card, r, c);
        int SiutPoints = garbo.calSiutPoints(card, r, c);
        int L2points = garbo.level2calPoints(card, r, c);
        num = RankPoints + SiutPoints + L2points;
        return num;
    }

    public static void turn(Garbo garbo, int cardNumber, int row, int column) {

        if (cardNumber <= garbo.getCurrentPlayer().getHand().getNumOfCArds()
                && cardNumber >= 1
                && row <= 4
                && row >= 1
                && column <= 4
                && column >= 1
                && (garbo.getField().getCell(row - 1, column - 1).getRankValue() == 0
                || garbo.getField().getCell(row - 1, column - 1) == garbo.getOldField().getCell(row - 1, column - 1))) { // if the user inputs are valid -> place a card

            int r = row - 1;
            int c = column - 1;
            int cardNum = cardNumber - 1;

            Card tempCard = garbo.getCurrentPlayer().getHand().getCard(cardNum);
            garbo.getField().addCard(r, c, tempCard);
            garbo.getCurrentPlayer().getHand().removeCard(cardNum);
            int addToScore = calPoints(garbo, tempCard, r, c);
            garbo.getNotCurrentPlayer().addToScore(addToScore);

            System.out.println("");
            System.out.println("Player1 score : " + garbo.getPlayer1().getScore() + "\t Player2 score : " + garbo.getPlayer2().getScore());
            if (garbo.getCurrentPlayer() == garbo.getPlayer1()) {
                garbo.setCurrentPlayer(garbo.getPlayer2());
                garbo.setNotCurrentPlayer(garbo.getPlayer1());
            } else {
                garbo.setCurrentPlayer(garbo.getPlayer1());
                garbo.setNotCurrentPlayer(garbo.getPlayer2());
            }
        } else {
            System.out.println("\n YOU CANNOT PLACE A CARD OUTSIDE OF THE FIELD OR ON TOP OF ANOTHER CARD ,TWICE,"
                    + " \n BEFORE COMPLETING OF LEVEL 1"
                    + "\n YOU ALSO CANNOT PLAY A CARD YOU DO NOT HAVE ");
        }
    }//end of playCadAndCalSocre

    public static void main(String[] args) {
        Garbo garbo = new Garbo();
        boolean firstDealing = true;
        boolean state2 = false;
        boolean state3 = false;

        Scanner userInput = new Scanner(System.in);

        System.out.println("\t wellcome");
        //shuffle cards
        System.out.println("shuffling cards");
        garbo.getPack().shuffle();
        //deal 4 cards to P1 && p2 
        System.out.println("dealing 4 cards to each player");
        garbo.dealCardsToEachPlayer(4);

        //play the first 8 cards 
        while (firstDealing) {   ///<<<<<<<<<<<-------------------------------------state1 
            garbo.getField().printField();
            garbo.printCurrentPlayerShowHandMessage();
            int showHand = userInput.nextInt();

            garbo.getCurrentPlayer().printHand();

            System.out.println("enter the card  NUMBER you what to play");
            int cardNum = userInput.nextInt();

            System.out.println("enter the ROW you what to place the card in");
            int r = userInput.nextInt();

            System.out.println("enter the COLUMN you what to place the card in");
            int c = userInput.nextInt();

            turn(garbo, cardNum, r, c);

            if (garbo.getPlayer2().getHand().getNumOfCArds() == 0) {
                state2 = true;
                firstDealing = false;
            }

        }//end of state1

        //deal cards 
        System.out.println("dealing 8 cards to each player ");
        garbo.dealCardsToEachPlayer(8);

        // System.out.println("num of cards dealt since begging of the game "+garbo.getTopCard());
        System.out.println("the number of cards left in the pile : " + (garbo.getPack().getNumberOfCardsLeft()));

        while (state2) { // play 8 cards (4 cards each) <<-------------------------------------state2
            garbo.getField().printField();
            garbo.printCurrentPlayerShowHandMessage();
            int showHand = userInput.nextInt();

            garbo.getCurrentPlayer().printHand();

            System.out.println("enter the card  NUMBER you what to play");
            int cardNum = userInput.nextInt();

            System.out.println("enter the ROW you what to place the card in");
            int r = userInput.nextInt();

            System.out.println("enter the COLUMN you what to place the card in");
            int c = userInput.nextInt();

            turn(garbo, cardNum, r, c);

            if (garbo.getPlayer2().getHand().getNumOfCArds() == 4) {
                state3 = true;
                state2 = false;
            }
        }//end of state 2 while loop

        garbo.getOldField().makeCopy(garbo.getField());

        garbo.getField().printField();
        System.out.println("level 2 begins");

        System.out.println("dealing 4 cards to each player");
        garbo.dealCardsToEachPlayer(4);
        System.out.println("number of cards left in the pile : " + garbo.getPack().getNumberOfCardsLeft());

        if (garbo.getPlayer1().getScore() > garbo.getPlayer2().getScore()) {
            garbo.setCurrentPlayer(garbo.getPlayer1());
            garbo.setNotCurrentPlayer(garbo.getPlayer2());
        } else if (garbo.getPlayer2().getScore() > garbo.getPlayer1().getScore()) {
            garbo.setCurrentPlayer(garbo.getPlayer2());
            garbo.setNotCurrentPlayer(garbo.getPlayer1());
        }

        while (state3) { // play 8 cards (4 cards each) <<<-------------------state 3
            garbo.printFieldV2();
            garbo.printCurrentPlayerShowHandMessage();

            int showHand = userInput.nextInt();

            garbo.getCurrentPlayer().printHand();

            System.out.println("enter the card  NUMBER you what to play");
            int cardNum = userInput.nextInt();

            System.out.println("enter the ROW you what to place the card in");
            int r = userInput.nextInt();

            System.out.println("enter the COLUMN you what to place the card in");
            int c = userInput.nextInt();

            turn(garbo, cardNum, r, c);

            if (garbo.winTime()) {
                garbo.printFieldV2();
                garbo.winner();
                System.out.println("");

                state3 = false;
            }

        }// end of while loop state 3

        // System.out.println("p1 cards num "+garbo.getPlayer1().getHand().getNumOfCArds());
        // System.out.println("p2 cards num "+garbo.getPlayer2().getHand().getNumOfCArds());
    }//end of main

}//end of class
