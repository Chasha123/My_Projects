/*
 *                      "♠♥♣♦"
    "Jack"  == 5     spades    ♠==1  
    "King"  == 6     hearts    ♥==2  
    "Seven" == 7     clubs     ♣==3
    "Eight" == 8     diamonds  ♦==4
    "Nine"  == 9
    "Ten"   == 10
    "Ace"   == 11
    "Queen" == 12
Jack,King,Seven,Eight,Nine,Ten,Ace,Queen,
 */
package garbo;

/**
 *
 * @author ss
 */
public class Card {

    private final int rankValue;
    private final int suitValue;
    private final String suit;
    private final String rank;

    public Card(int suit, int rank) {
        this.rankValue = rank;
        this.suitValue = suit;
        this.suit = suitVal(suit);
        this.rank = rankVal(rank);
    }

    private static String suitVal(int num) {
        if (num == 0) {
            return "○";
        } else if (num == 1) {
            return "♠";
        } else if (num == 2) {
            return "♥";
        } else if (num == 3) {
            return "♣";
        } else {
            return "♦";
        }
    }//end of suit

    private static String rankVal(int num) {
        if (num == 0) {
            return "○";
        } else if (num == 5) {
            return "J";//"Jack"; 
        } else if (num == 6) {
            return "K";//"King";
        } else if (num == 7) {
            return "7";//"Seven";
        } else if (num == 8) {
            return "8";//"Eight";
        } else if (num == 9) {
            return "9";//"Nine";
        } else if (num == 10) {
            return "10";//"Ten";
        } else if (num == 11) {
            return "A";//"Ace";
        } else {
            return "Q";//"Queen";
        }
    }//end of rankVal

    public int getRankValue() {
        return rankValue;
    }

    public int getSuitValue() {
        return suitValue;
    }

    public String getName() {
        return "(" + rank + suit + ")";
    }

    public String getNameL2() {
        return "(" + rank + suit + ")*";
    }

}//end of calss
