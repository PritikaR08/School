
package pentristesting;

public class SBlock5 extends Block {

    private int[][] sBlock = new int[5][10];

    public SBlock5() {
        super.setColor(5);
        this.sBlock = sBlock;
    }

    public int[][] getsBlock() {
        return sBlock;
    }

    //@Override
    public void createGrid() {
        sBlock[2][5] = 2;
        sBlock[2][6] = 2;
        sBlock[3][5] = 2;
        sBlock[4][4] = 2;
        sBlock[4][5] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return sBlock[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + sBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
