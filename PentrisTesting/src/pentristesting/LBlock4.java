/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentristesting;

public class LBlock4 extends Block{
    private int[][] lBlock = new int[5][10];

    public LBlock4() {
        super.setColor(4);
        this.lBlock = lBlock;
    }

    public int[][] getlBlock() {
        return lBlock;
    }

    //@Override
    public void createGrid() {
        lBlock[2][4] = 2;
        lBlock[3][4] = 2;
        lBlock[4][4] = 2;
        lBlock[4][5] = 2;
    }
    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return lBlock [x][y];
    }


    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + lBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }
}

