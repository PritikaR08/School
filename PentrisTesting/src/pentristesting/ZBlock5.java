package pentristesting;

public class ZBlock5 extends Block {

    private int[][] zBlock = new int[5][10];

    public ZBlock5() {
        super.setColor(1);
        this.zBlock = zBlock;
    }

    public int[][] getzBlock() {
        return zBlock;
    }

    //@Override
    public void createGrid() {
        zBlock[2][4] = 2;
        zBlock[2][5] = 2;
        zBlock[3][5] = 2;
        zBlock[4][5] = 2;
        zBlock[4][6] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return zBlock[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + zBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
