package pentristesting;
public class TurtleBlockA extends Block {

    private int[][] turtleBlockA = new int[5][10];

    public TurtleBlockA() {
        super.setColor(8);
        this.turtleBlockA = turtleBlockA;
    }

    public int[][] getturtleBlockA() {
        return turtleBlockA;
    }

    //@Override
    public void createGrid() {
        turtleBlockA[3][4] = 2;
        turtleBlockA[3][5] = 2;
        turtleBlockA[3][6] = 2;
        turtleBlockA[4][5] = 2;
        turtleBlockA[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return turtleBlockA[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + turtleBlockA[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
