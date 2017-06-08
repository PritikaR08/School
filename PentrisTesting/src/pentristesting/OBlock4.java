/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentristesting;

public class OBlock4 extends Block {
    private int[][] oBlock = new int[5][10];

    public OBlock4() {
        super.setColor(7);
        this.oBlock = oBlock;
    }

    public int[][] getOBlock() {
        return oBlock;
    }

    //@Override
    public void createGrid() {
        oBlock[3][4] = 2;
        oBlock[3][5] = 2;
        oBlock[4][5] = 2;
        oBlock[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return oBlock [x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + oBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    } 
}


