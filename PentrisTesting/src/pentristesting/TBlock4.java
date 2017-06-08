
package pentristesting;

public class TBlock4 extends Block{
   private int[][] tBlock = new int[5][10];

    public TBlock4() {
        super.setColor(6);
        this.tBlock = tBlock;
    }

    public int[][] gettBlock() {
        return tBlock;
    }

    //@Override
    public void createGrid() {
        tBlock[2][4] = 2;
        tBlock[3][4] = 2;
        tBlock[3][5] = 2;
        tBlock[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return tBlock [x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + tBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    } 
}
