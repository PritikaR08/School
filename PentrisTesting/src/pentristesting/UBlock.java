package pentristesting;

public class UBlock extends Block {

    private int[][] uBlock = new int[5][10];

    public UBlock() {
        super.setColor(7);
        this.uBlock = uBlock;
    }

    public int[][] getuBlock() {
        return uBlock;
    }

    //@Override
    public void createGrid() {
        uBlock[3][4] = 2;
        uBlock[3][6] = 2;
        uBlock[4][4] = 2;
        uBlock[4][5] = 2;
        uBlock[4][6] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return uBlock[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + uBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
