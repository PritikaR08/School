
package pentristesting;

public class JBlock5 extends Block {

    private int[][] jBlock = new int[5][10];

    public JBlock5() {
        super.setColor(3);
        this.jBlock = jBlock;
    }

    public int[][] getjBlock() {
        return jBlock;
    }

    //@Override
    public void createGrid() {
        jBlock[2][6] = 2;
        jBlock[3][6] = 2;
        jBlock[4][6] = 2;
        jBlock[4][5] = 2;
        jBlock[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return jBlock[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + jBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
