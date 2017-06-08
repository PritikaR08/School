package pentristesting;


public class IBlock4 extends Block {

    private int[][] iBlock = new int[5][10];

    public IBlock4() {
        super.setColor(2);
        //this.iBlock = iBlock;
    }

    public int getiBlock(int x, int y) {
        return iBlock[x][y];
    }

    public int[][] getiBlock() {
        return iBlock;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return iBlock [x][y];
    }

    

    //@Override
    public void createGrid() {
        iBlock[1][4] = 2;
        iBlock[2][4] = 2;
        iBlock[3][4] = 2;
        iBlock[4][4] = 2;
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + iBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}


