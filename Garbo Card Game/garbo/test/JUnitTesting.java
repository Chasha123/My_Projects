/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import garbo.Card;
import garbo.Field;
import garbo.Garbo;
import static garbo.Garbo.calPoints;
import garbo.Pack;
import garbo.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ss
 */
public class JUnitTesting {

    /*
    public JUnitTesting() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    /**/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void rankValueOfPlaceholder() {
        Card card = new Card(0, 0);
        assertEquals(0, card.getRankValue());
    }

    @Test
    public void suitValueOfPlaceholder() {
        Card card = new Card(0, 0);
        assertEquals(0, card.getSuitValue());
    }

    @Test
    public void suitValueOfANormalCard() {
        for (int i = 1; i <= 4; i++) {
            Card card = new Card(i, 0);

            assertEquals(i, card.getSuitValue());
        }
    }

    @Test
    public void rankValueOfNormalCard() {
        for (int i = 5; i <= 12; i++) {
            Card card = new Card(0, i);

            assertEquals(i, card.getRankValue());
        }
    }

    @Test
    public void rankValueOfAllCardsInPack() {
        Pack pack = new Pack();
        int expectedValue = 5;
        for (int i = 0; i < 32 / 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(expectedValue, pack.getTopCard().getRankValue());
            }
            expectedValue++;
        }
    }

    @Test
    public void siutValueOfAllCardsInPack() {
        Pack pack = new Pack();
        int expectedValue = 1;
        for (int i = 0; i < 32 / 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(expectedValue, pack.getTopCard().getSuitValue());
                expectedValue++;
            }
            expectedValue = 1;
        }
    }

    @Test
    public void numOfCardInPail() {
        Pack pack = new Pack();
        int numOfCardsInPack = pack.getNumberOfCardsLeft();

        assertEquals(32, numOfCardsInPack);
    }

    @Test
    public void removeCard() {
        Garbo garbo = new Garbo();
        garbo.dealCardsToEachPlayer(4);
        garbo.getPlayer1().getHand().removeCard(0);
        int numOfCardsInHand = garbo.getPlayer1().getHand().getNumOfCArds();

        assertEquals(3, numOfCardsInHand);
    }

    @Test
    public void dealingCards() {
        Garbo garbo = new Garbo();
        garbo.dealCardsToEachPlayer(4);
        int numOfCardsInHand = garbo.getPlayer1().getHand().getNumOfCArds();
        int numOfCardsInHandP2 = garbo.getPlayer2().getHand().getNumOfCArds();
        int numOfcardsLeftInThePile = garbo.getPack().getNumberOfCardsLeft();
        assertEquals(4, numOfCardsInHand);
        assertEquals(4, numOfCardsInHandP2);
        assertEquals(32 - 8, numOfcardsLeftInThePile);
    }

    @Test
    public void dealingDifferentCards() {
        Pack pack = new Pack();
        Card card = pack.getTopCard();
        Card card2 = pack.getTopCard();

        assertNotEquals(card, card2);
    }

    @Test
    public void defoltScore() {
        Garbo garbo = new Garbo();
        int score = garbo.getPlayer1().getScore();
        assertEquals(0, score);
    }

    @Test
    public void playerAddTOScore() {
        Player player = new Player();
        player.addToScore(11);
        player.addToScore(8);
        assertEquals(19, player.getScore());
    }

    @Test
    public void invalidGridCoordinates() {
        Field field = new Field();

        assertNotNull(field.getCell(9, 9));
    }

    @Test
    public void invalidGridCoordinates2() {
        Field field = new Field();

        assertNotNull(field.getCell(-9, 9));
    }

    @Test
    public void invalidGridCoordinates3() {
        Field field = new Field();

        assertNotNull(field.getCell(9, -9));
    }

    @Test
    public void invalidGridCoordinates4() {
        Field field = new Field();

        assertNotNull(field.getCell(-9, -9));
    }

    @Test
    public void makeCopyField() {
        Field field = new Field();
        Field field2 = new Field();
        Pack pack = new Pack();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card card = pack.getTopCard();
                field.addCard(i, j, card);
            }
        }

        field2.makeCopy(field);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card expectedCard = field.getCell(i, j);
                Card card = field2.getCell(i, j);

                assertEquals(expectedCard, card);

            }
        }

    }

    @Test
    public void setCurrentPlayer() {
        Garbo garbo = new Garbo();
        Player player = new Player();
        garbo.setCurrentPlayer(player);

        assertEquals(player, garbo.getCurrentPlayer());
    }

    @Test
    public void setNotCurrentPlayer() {
        Garbo garbo = new Garbo();
        Player player = new Player();
        garbo.setNotCurrentPlayer(player);

        assertEquals(player, garbo.getNotCurrentPlayer());
    }

    @Test
    public void calculatePoints() {
        Garbo garbo = new Garbo();
        garbo.getField().addCard(0, 0, new Card(4, 7));
        garbo.getField().addCard(0, 1, new Card(3, 9));
        int obtainedPoints = calPoints(garbo, new Card(3, 7), 1, 0);

        assertEquals(10, obtainedPoints);
    }

    @Test
    public void calculatePoints2() {
        Garbo garbo = new Garbo();
        garbo.getField().addCard(0, 0, new Card(4, 7));
        garbo.getField().addCard(0, 1, new Card(3, 9));
        int obtainedPoints = calPoints(garbo, new Card(3, 7), 3, 0);

        assertEquals(7, obtainedPoints);
    }

    @Test
    public void calculatePoints3() {
        Garbo garbo = new Garbo();
        garbo.getField().addCard(0, 0, new Card(4, 7));
        garbo.getField().addCard(0, 1, new Card(3, 9));
        int obtainedPoints = calPoints(garbo, new Card(3, 7), 1, 2);

        assertEquals(3, obtainedPoints);
    }

}//ss
