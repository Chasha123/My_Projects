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
public class Field {

    private final Card[][] grid;

    public Field() {
        this.grid = new Card[4][4];

        Card temp = new Card(0, 0);

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                this.grid[r][c] = temp;
            }
        }

    }//end of constructor

    public Card getCell(int r, int c) {
        if (r >= 0 && r < 4 && c >= 0 && c < 4) {
            return grid[r][c];
        } else {
            return new Card(0, 0);
        }
    }

    public void addCard(int r, int c, Card card) {
        this.grid[r][c] = card;
    }

    public void makeCopy(Field f) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                this.grid[i][j] = f.grid[i][j];
            }
        }
    }

    public void printField() {
        System.out.println("   1\t  2\t  3\t  4");
        for (int r = 0; r < 4; r++) {
            System.out.print(r + 1);
            for (int c = 0; c < 4; c++) {
                System.out.print(grid[r][c].getName() + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
